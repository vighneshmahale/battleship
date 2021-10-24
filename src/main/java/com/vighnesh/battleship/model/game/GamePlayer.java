package com.vighnesh.battleship.model.game;

import com.vighnesh.battleship.model.game.board.Board;
import com.vighnesh.battleship.model.game.board.BoardBlock;
import com.vighnesh.battleship.model.game.ship.types.Ship;
import com.vighnesh.battleship.model.game.ship.types.ShipFactory;
import com.vighnesh.battleship.model.game.ship.types.ShipType;
import com.vighnesh.battleship.model.user.PlayerUser;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private PlayerUser playerUser;

    @Getter
    private List<Ship> ships;
    @Getter
    private Board board;
    @Getter
    private int score;

    private ShipFactory shipFactory;

   public GamePlayer(PlayerUser playerUser){
       this.playerUser = playerUser;
       this.shipFactory = new ShipFactory();
       board = new Board();

       ships = new ArrayList<>();
       ships.add(this.shipFactory.getShip(ShipType.CARRIER));
       ships.add(this.shipFactory.getShip(ShipType.BATTLESHIP));

       board.block(0, 0 , ships.get(0).getShipShape(), false);
       board.block(3, 2, ships.get(1).getShipShape(), true);
   }

   public void attack(Ship ship, Board opponentBoard, BoardBlock block) {
       // Can do validations
       ship.attack(opponentBoard, block);

       // score algo
   }

   public boolean isAlive() {
       for (Ship s: ships) {
           if(s.isAlive()) return true;
       }
       return false;
   }

   public void displayBoard() {
       board.displayBoard();
   }

   public Ship getShip(ShipType s) {
       for (Ship ship: ships) {
           if(ship.getShipType().equals(s)){
               return ship;
           }
       }
       return ships.get(0);
   }
}



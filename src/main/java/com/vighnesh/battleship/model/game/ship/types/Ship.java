package com.vighnesh.battleship.model.game.ship.types;

import com.vighnesh.battleship.model.game.board.Board;
import com.vighnesh.battleship.model.game.board.BoardBlock;
import com.vighnesh.battleship.model.game.ship.shape.ShipBlock;
import com.vighnesh.battleship.model.game.ship.shape.ShipShape;
import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Ship {

    protected String id;
    protected ShipType shipType;
    protected Integer length;
    protected ShipShape shipShape;
    protected boolean isAlive;

    public Ship() {
        id = UUID.randomUUID().toString();
    }
    public void acceptDamage(ShipBlock block) {
        block.setDamaged(true);
    }
    public int getLength() {
        return length;
    }
    public abstract void attack(Board opponentBoard, BoardBlock block);

    public abstract ShipType getShipType();

    public boolean isAlive(){
        if(shipShape.countAliveCells()>0){
            return true;
        }
        return false;
    }
}

package com.vighnesh.battleship.model.game.ship.types;

import com.vighnesh.battleship.exception.ShipNotValidException;
import com.vighnesh.battleship.model.game.board.Board;
import com.vighnesh.battleship.model.game.board.BoardBlock;
import com.vighnesh.battleship.model.game.ship.shape.DefaultShape;

public class Carrier extends Ship {

    public Carrier(){
        this.shipShape = new DefaultShape(1, 1);
        this.shipType = ShipType.CARRIER;
    }

    @Override
    public void attack(Board opponentBoard, BoardBlock block) {
        if(!isAlive()) {
            System.out.println("Current Ship is dead");
            return;
        };
        // Any logic which needs to be performed
        block.attack();
    }

    @Override
    public ShipType getShipType() {
        return shipType;
    }

}

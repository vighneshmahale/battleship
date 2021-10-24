package com.vighnesh.battleship.model.game.ship.types;

import com.vighnesh.battleship.exception.ShipNotValidException;
import com.vighnesh.battleship.model.game.board.Board;
import com.vighnesh.battleship.model.game.board.BoardBlock;
import com.vighnesh.battleship.model.game.ship.shape.DefaultShape;

public class BattleShip extends Ship{
    public BattleShip(){
        this.length = 6;
        this.shipShape = new DefaultShape(1,1);
        this.shipType = ShipType.BATTLESHIP;
    }

    @Override
    public void attack(Board board, BoardBlock block) {
        if(!isAlive()) throw new ShipNotValidException();
        // Any logic which needs to be performed
        block.attack();
    }

    @Override
    public ShipType getShipType() {
        return shipType;
    }
}

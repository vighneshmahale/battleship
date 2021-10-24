package com.vighnesh.battleship.model.game.ship.shape;


import com.vighnesh.battleship.model.game.ship.types.Ship;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class ShipBlock {
    private int x_axis;
    private int y_axis;

    @Getter
    @Setter
    private boolean isDamaged;

    public ShipBlock(int x, int y){
        x_axis = x;
        y_axis = y;
        isDamaged = false;
    }

    public void damage(){
        isDamaged = true;
    }

    public boolean isDamaged(){
        return isDamaged;
    }
}

package com.vighnesh.battleship.model.game.board;

import com.vighnesh.battleship.model.game.ship.shape.ShipBlock;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BoardBlock {
    private int x_axis;
    private int y_axis;
    private boolean isAttacked;

    @Getter
    @Setter
    private ShipBlock shipBlock;

    BoardBlock(int x, int y){
        x_axis = x;
        y_axis = y;
        isAttacked = false;
        shipBlock = null;
    }

    public void attack() {
        isAttacked = true;
        if(shipBlock!= null) {
            System.out.println(" Hit");
            shipBlock.damage();
        }
    }

}

package com.vighnesh.battleship.model.game.ship.shape;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DefaultShape extends ShipShape{
    @Getter
    private int length;

    @Getter
    private int breadth;
    private List<List<ShipBlock>> shape;

    public DefaultShape(int length, int bredth){
       this.length = length;
       this.breadth = bredth;

       shape = new ArrayList<>(length);
       for(int i = 0; i< length; i++){
           shape.add(new ArrayList<ShipBlock>(bredth));

           for(int j=0; j< bredth; j++){
               shape.get(i).add(new ShipBlock(i, j));
           }
       }
    }

    @Override
    public String getType() {
        return "Rectangular";
    }

    @Override
    public int countAliveCells(){
        int count = 0;
        for(int i = 0; i< length; i++){
            for (int j = 0; j< breadth; j++){
                if(!shape.get(i).get(j).isDamaged()){
                    count++;
                }
            }
        }
        return count;
    }

    public ShipBlock getBlock(int x, int y, boolean orientation){
        // check for index
        if(orientation) return shape.get(y).get(x);
        return shape.get(x).get(y);
    }

}

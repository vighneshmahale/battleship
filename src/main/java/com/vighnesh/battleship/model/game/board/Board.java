package com.vighnesh.battleship.model.game.board;

import com.vighnesh.battleship.model.game.ship.shape.DefaultShape;
import com.vighnesh.battleship.model.game.ship.shape.ShipBlock;
import com.vighnesh.battleship.model.game.ship.shape.ShipShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    private static final int DEFAULT_ROWS = 10;
    private static final int DEFAULT_COLS = 10;

    private final int ROWS;
    private final int COLS;
    private List<List<BoardBlock>> matrix;

    public Board(){
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    public Board(int rows, int cols) {
        ROWS = rows;
        COLS = cols;

        matrix = new ArrayList<>(ROWS);
        for(int i = 0; i< ROWS; i++){
            matrix.add(new ArrayList<BoardBlock>(COLS));
        }

        for(int i =0 ; i< ROWS; i++) {
            for(int j=0; j< COLS; j++) {
                matrix.get(i).add(new BoardBlock(i, j));
            }
        }
    }

    public void block(int x, int y, ShipShape shape, boolean orientation){
        // allocate based on shape

        int i,j;
        shape = (DefaultShape) shape;

        int length = ((DefaultShape) shape).getLength();
        int breadth = ((DefaultShape) shape).getBreadth();

        if(orientation){
            length = ((DefaultShape) shape).getBreadth();
            breadth = ((DefaultShape) shape).getLength();
        }

        for(i = x; i < x + length; i++){
            for (j = y ; j < y + breadth ; j++){
               ShipBlock shipBlock =  ((DefaultShape) shape).getBlock(i-x, j-y, orientation);
               matrix.get(i).get(j).setShipBlock(shipBlock);
            }
        }
    }

    public void displayBoard() {
        int i,j;

        for (i = 0; i < DEFAULT_ROWS; i++) {
            for (j = 0; j < DEFAULT_COLS; j++) {
                BoardBlock block = matrix.get(i).get(j);

                String shipDisplay = "";
                if(!Objects.isNull(block.getShipBlock())) {
                    shipDisplay = "SHIP";
                }
                System.out.format("%6s%6s", shipDisplay, block.isAttacked());
            }
            System.out.println();
        }
    }

    public BoardBlock getBlock(int x, int y) {
        return matrix.get(x).get(y);
    }
}

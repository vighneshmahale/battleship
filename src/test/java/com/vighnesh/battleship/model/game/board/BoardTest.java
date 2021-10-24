package com.vighnesh.battleship.model.game.board;

import com.vighnesh.battleship.model.game.ship.shape.DefaultShape;
import com.vighnesh.battleship.model.game.ship.shape.ShipBlock;
import com.vighnesh.battleship.model.game.ship.shape.ShipShape;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private ShipShape shipShape = new DefaultShape(2, 3);

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @AfterEach
    void tearDown() {
    }

    // start 0,1
    // end   1,3

    @Test
    void block() {
        board.block(0, 1, shipShape, false);
        assertNotNull(board.getBlock(0,1).getShipBlock());
        assertNotNull(board.getBlock(1, 3).getShipBlock());
        assertNull(board.getBlock(0, 0).getShipBlock());
    }

    // start 0,1
    // end   2,2
    @Test
    void blockTilt() {
        board.block(0, 1, shipShape, true);
        assertNotNull(board.getBlock(0, 1).getShipBlock());
        assertNotNull(board.getBlock(2, 2).getShipBlock());
        assertNull(board.getBlock(1,3).getShipBlock());
    }

    @Test
    void displayBoard() {
        board.displayBoard();
    }

    @Test
    void getBlock() {
        assertNotNull(board.getBlock(0, 0));
    }
}
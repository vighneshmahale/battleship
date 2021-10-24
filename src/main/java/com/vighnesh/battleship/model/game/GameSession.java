package com.vighnesh.battleship.model.game;

import com.vighnesh.battleship.model.game.ship.types.ShipType;
import com.vighnesh.battleship.model.user.PlayerUser;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Can Add Status

public class GameSession {
    private String id;
    private List<GamePlayer> players;
    private static final Integer NUMBER_OF_PLAYERS = 2;
    private Integer currentTurn;
    private Integer winner;
    private Boolean isGameOver;


    public GameSession(List<PlayerUser> users) {
        id = UUID.randomUUID().toString();
        isGameOver = false;
        players = new ArrayList<>();
        currentTurn = 0;
        for (PlayerUser user: users) {
            players.add(new GamePlayer(user));
        }
    }

    public void play(ShipType s, int x, int y) {
        System.out.println("==========Current Player = " + currentTurn + "==============");
        GamePlayer currentPlayer = players.get(currentTurn);
        currentTurn++;
        currentTurn = currentTurn % (players.size());
        GamePlayer opponentPlayer = players.get(currentTurn);

        currentPlayer.attack(currentPlayer.getShip(s), opponentPlayer.getBoard(), opponentPlayer.getBoard().getBlock(x, y));

        if(!opponentPlayer.isAlive()) {
            isGameOver = true;
            winner = currentTurn;
            System.out.println("Game Over, Winner is " + currentTurn);
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void display() {
        System.out.println("Displaying First Player's Board");
        players.get(0).displayBoard();
        System.out.println();
        System.out.println("Displaying Second Person's Board");
        players.get(1).displayBoard();
        System.out.println();
    }
}

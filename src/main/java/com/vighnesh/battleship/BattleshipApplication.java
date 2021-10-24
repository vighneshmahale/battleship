package com.vighnesh.battleship;

import com.vighnesh.battleship.model.game.GameSession;
import com.vighnesh.battleship.model.game.ship.types.ShipType;
import com.vighnesh.battleship.model.user.PlayerUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BattleshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(BattleshipApplication.class, args);

        PlayerUser playerUser1 = new PlayerUser("Vighnesh", "vig@gmail", "pass");
        PlayerUser playerUser2 = new PlayerUser("Anish", "ani@gmai", "pass");

        List<PlayerUser> playerUsers = new ArrayList<>();
        playerUsers.add(playerUser1);
        playerUsers.add(playerUser2);

        GameSession session = new GameSession(playerUsers);

        Scanner sc= new Scanner(System.in);

        while(true) {
            List<Integer> input = splitter(sc.nextLine());

            if(input.get(0) == 1) {
                session.play(ShipType.CARRIER, input.get(1), input.get(2));
            } else if(input.get(0) == 2) {
                session.display();
            }

            if(session.isGameOver()) {
                System.out.println("Game Over");
                break;
            }
        }
    }

    private static List<Integer> splitter(String input) {
        String[] s = input.split("\\s+");

        List<Integer> numberArray = new ArrayList<>();

        for(int i =0 ; i< s.length; i++) {
            numberArray.add(Integer.parseInt(s[i]));
        }
        return numberArray;
    }

}

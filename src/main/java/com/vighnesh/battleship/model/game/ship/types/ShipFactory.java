package com.vighnesh.battleship.model.game.ship.types;

import org.springframework.stereotype.Component;

@Component
public class ShipFactory {
    public Ship getShip(ShipType shipType){
        switch (shipType){
            case CARRIER:
                return new Carrier();
            case BATTLESHIP:
                return new BattleShip();
        }
        return new Carrier();
    }
}

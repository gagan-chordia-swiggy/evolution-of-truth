package org.example.entity;

import org.example.exceptions.InvalidCoinAdditionException;

public class Player {
    private int coins;

    public Player() {
        this.coins = 0;
    }

    public int coins() {
        return this.coins;
    }

    public void add(int coins) {
        if (coins < -1 || coins == 1 || coins > 3) {
            throw new InvalidCoinAdditionException();
        }
        this.coins += coins;
    }
}

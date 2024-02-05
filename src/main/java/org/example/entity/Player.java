package org.example.entity;

import org.example.exceptions.InvalidCoinAdditionException;

public class Player {
    private int coins;
    private boolean willCooperate;

    public Player() {
        this.coins = 0;
        this.willCooperate = false;
    }

    public int coins() {
        return this.coins;
    }

    public void addCoins(int coins) {
        if (coins < -1 || coins == 1 || coins > 3) {
            throw new InvalidCoinAdditionException();
        }
        this.coins += coins;
    }

    public boolean willCooperate() {
        return willCooperate;
    }

    public void willCooperate(boolean willCooperate) {
        this.willCooperate = willCooperate;
    }

    public void transactWith(Player otherPlayer) {
        if (this.willCooperate && otherPlayer.willCooperate()) {
            this.addCoins(2);
            otherPlayer.addCoins(2);
            return;
        }

        if (this.willCooperate && !otherPlayer.willCooperate()) {
            this.addCoins(-1);
            otherPlayer.addCoins(3);
            return;
        }

        if (!this.willCooperate && otherPlayer.willCooperate()) {
            this.addCoins(3);
            otherPlayer.addCoins(-1);
        }
    }
}

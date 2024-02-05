package org.example.entity;

public abstract class Player {
    final Score score;
    protected boolean willCooperate;

    public Player(boolean willCooperate) {
        this.score = new Score();
        this.willCooperate = willCooperate;
    }

    private void addScore(int score) {
        this.score.add(score);
    }

    public Score score() {
        return this.score;
    }

    public void transactWith(Player otherPlayer) {
        boolean player1WillToCooperate = this.willCooperate;
        boolean player2WillToCooperate = otherPlayer.willCooperate;
        int THREE_POINTS = 3;
        int NEGATIVE_ONE_POINT = -1;

        if (player1WillToCooperate) {
            this.addScore(NEGATIVE_ONE_POINT);
            otherPlayer.addScore(THREE_POINTS);
        }

        if (player2WillToCooperate) {
            this.addScore(THREE_POINTS);
            otherPlayer.addScore(NEGATIVE_ONE_POINT);
        }

        new Thread(() -> mimic(otherPlayer)).start();
        new Thread(() -> grudge(otherPlayer)).start();
    }

    private void grudge(Player otherPlayer) {
        if (otherPlayer instanceof Grudger) {
            if (!this.willCooperate) {
                otherPlayer.willCooperate = false;
            }
        }

        if (this instanceof Grudger) {
            if (!otherPlayer.willCooperate) {
                this.willCooperate = false;
            }
        }
    }

    private void mimic(Player otherPlayer) {
        if (otherPlayer instanceof CopyKitten || otherPlayer instanceof Copycat) {
            otherPlayer.willCooperate = this.willCooperate;
        }

        if (this instanceof CopyKitten || this instanceof Copycat) {
            this.willCooperate = otherPlayer.willCooperate;
        }
    }
}

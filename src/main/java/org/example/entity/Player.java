package org.example.entity;

public abstract class Player {
    Score score;
    private final boolean willCooperate;

    public Player(boolean willCooperate) {
        this.score = new Score();
        this.willCooperate = willCooperate;
    }

    private void addScore(int score) {
        this.score.add(score);
    }
//
//    public void willCooperate(boolean willCooperate) {
//        this.willCooperate = willCooperate;
//    }

    public void transactWith(Player otherPlayer) {
        if (this.willCooperate && otherPlayer.willCooperate) {
            this.addScore(2);
            otherPlayer.addScore(2);
            return;
        }

        if (this.willCooperate && !otherPlayer.willCooperate) {
            this.addScore(-1);
            otherPlayer.addScore(3);
            return;
        }

        if (!this.willCooperate && otherPlayer.willCooperate) {
            this.addScore(3);
            otherPlayer.addScore(-1);
        }
    }
}

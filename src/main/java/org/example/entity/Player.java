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
        this.transact(otherPlayer);

        boolean currentPlayerWill = this.updateCooperation(otherPlayer);
        boolean otherPlayerWill = otherPlayer.updateCooperation(this);

        this.willCooperate = currentPlayerWill;
        otherPlayer.willCooperate = otherPlayerWill;
    }

    abstract boolean updateCooperation(Player otherPlayer);

    private void transact(Player otherPlayer) {
        int THREE_POINTS = 3;
        int NEGATIVE_ONE_POINT = -1;

        if (this.willCooperate) {
            this.addScore(NEGATIVE_ONE_POINT);
            otherPlayer.addScore(THREE_POINTS);
        }

        if (otherPlayer.willCooperate) {
            this.addScore(THREE_POINTS);
            otherPlayer.addScore(NEGATIVE_ONE_POINT);
        }
    }
}

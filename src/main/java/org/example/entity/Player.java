package org.example.entity;

public abstract class Player {
    final Score score;
    protected boolean willCooperate;

    private final int THREE_POINTS = 3;
    private final int TWO_POINTS = 2;
    private final int NEGATIVE_ONE_POINT = -1;

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

        if (player1WillToCooperate) {
            this.addScore(NEGATIVE_ONE_POINT);
            otherPlayer.addScore(THREE_POINTS);
        }

        if (player2WillToCooperate) {
            this.addScore(THREE_POINTS);
            otherPlayer.addScore(NEGATIVE_ONE_POINT);
        }
    }
}

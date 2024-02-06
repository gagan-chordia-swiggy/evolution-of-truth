package org.example.entity;

public class Detective extends Player {
    private int roundNo;
    private boolean otherPlayerNeverCheated;

    public Detective() {
        super(true);
        this.roundNo = 1;
        this.otherPlayerNeverCheated = true;
    }

    @Override
    public void transactWith(Player otherPlayer) {
        super.transactWith(otherPlayer);
        ++roundNo;
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        if (!otherPlayerNeverCheated) {
            return otherPlayer.willCooperate;
        }

        if (this.roundNo == 1 && otherPlayer.willCooperate) {
            return false;
        }

        if (this.roundNo <= 2&& !otherPlayer.willCooperate) {
            this.otherPlayerNeverCheated = false;
            return false;
        }

        return roundNo == 2;
    }
}

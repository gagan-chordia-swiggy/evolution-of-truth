package org.example.entity;

public class Grudger extends Player {
    public Grudger() {
        super(true);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        if (!otherPlayer.willCooperate) {
            return false;
        }

        return this.willCooperate;
    }
}

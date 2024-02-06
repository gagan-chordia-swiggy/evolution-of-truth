package org.example.entity;

public class CopyKitten extends Player {
    public CopyKitten() {
        super(true);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        return otherPlayer.willCooperate;
    }
}

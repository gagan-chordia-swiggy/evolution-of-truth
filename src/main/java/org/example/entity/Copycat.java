package org.example.entity;

public class Copycat extends Player {
    public Copycat() {
        super(false);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        return otherPlayer.willCooperate;
    }
}

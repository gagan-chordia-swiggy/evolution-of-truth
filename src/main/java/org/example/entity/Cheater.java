package org.example.entity;

public class Cheater extends Player {
    public Cheater() {
        super(false);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        return false;
    }
}

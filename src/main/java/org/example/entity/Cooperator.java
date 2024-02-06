package org.example.entity;

public class Cooperator extends Player {
    public Cooperator() {
        super(true);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        return true;
    }
}

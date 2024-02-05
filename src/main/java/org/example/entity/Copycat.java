package org.example.entity;

public class Copycat extends Player {
    public Copycat() {
        super(false);
    }

    @Override
    public void transactWith(Player otherPlayer) {
        super.transactWith(otherPlayer);

        if (otherPlayer instanceof Copycat) {
            mimic(super.willCooperate);
            return;
        }

        mimic(otherPlayer.willCooperate);
    }

    private void mimic(boolean willCooperate) {
        this.willCooperate = willCooperate;
    }
}

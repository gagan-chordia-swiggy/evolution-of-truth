package org.example.services;

import org.example.entity.Player;

public class EvolutionOfTrustService {
    private final Player player1;
    private final Player player2;

    public EvolutionOfTrustService(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void transactFor(int numberOfRounds) {
        for (int ii = 0; ii < numberOfRounds; ii++) {
            player1.transactWith(player2);
        }
    }
}

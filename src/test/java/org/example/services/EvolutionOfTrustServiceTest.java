package org.example.services;

import org.example.entity.Cheater;
import org.example.entity.Cooperator;
import org.example.entity.Copycat;
import org.example.entity.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvolutionOfTrustServiceTest {
    @Test
    void testBothPlayersAreCheatersAndAfter5RoundBothHaveZeroPoints() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Cheater();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(0, firstPlayer.score().points());
        assertEquals(0, secondPlayer.score().points());
    }

    @Test
    void testBothPlayersCooperateAndAfter5RoundBothHaveZeroPoints() {
        Player firstPlayer = new Cooperator();
        Player secondPlayer = new Cooperator();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(10, firstPlayer.score().points());
        assertEquals(10, secondPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsACheaterAndSecondPlayerIsCooperatorAndAfter5RoundThereAre15AndNegative5PointsRespectively() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Cooperator();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(15, firstPlayer.score().points());
        assertEquals(-5, secondPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsCheaterAndSecondPlayerWillCopyAndWillHave3AndNegative1PointsRespectivelyAfter3Rounds() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Copycat();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(3);

        assertEquals(0, secondPlayer.score().points());
        assertEquals(0, firstPlayer.score().points());
    }
}

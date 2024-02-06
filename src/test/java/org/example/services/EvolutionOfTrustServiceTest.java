package org.example.services;

import org.example.entity.*;
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

    @Test
    void testFirstPlayerIsCopyKittenAndSecondPlayerIsCooperatorAndWillHave10PointsEachAfter5Rounds() {
        Player firstPlayer = new CopyKitten();
        Player secondPlayer = new Cooperator();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(10, secondPlayer.score().points());
        assertEquals(10, firstPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsCooperatorAndSecondPlayerIsCopyKittenAndWillHave10PointsEachAfter5Rounds() {
        Player firstPlayer = new Cooperator();
        Player secondPlayer = new CopyKitten();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(10, secondPlayer.score().points());
        assertEquals(10, firstPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsGrudgerAndSecondPlayerIsCopycatAndWillHave2And2PointsAfter5Rounds() {
        Player firstPlayer = new Grudger();
        Player secondPlayer = new Copycat();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(2, secondPlayer.score().points());
        assertEquals(2, firstPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsCheaterAndSecondPlayerIsGrudgerAndWillHaveNegative1And3PointsAfter5Rounds() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Grudger();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(5);

        assertEquals(-1, secondPlayer.score().points());
        assertEquals(3, firstPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsDetectiveAndSecondPlayerIsCooperatorAndWillHave16And0PointsRespectivelyAfter6Rounds() {
        Player firstPlayer = new Detective();
        Player secondPlayer = new Cooperator();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(6);

        assertEquals(0, secondPlayer.score().points());
        assertEquals(16, firstPlayer.score().points());
    }

    @Test
    void testFirstPlayerIsDetectiveAndSecondPlayerIsGrudgerAndWill5And1PointsRespectivelyHaveAfter2Rounds() {
        Player firstPlayer = new Detective();
        Player secondPlayer = new Grudger();
        EvolutionOfTrustService service = new EvolutionOfTrustService(firstPlayer, secondPlayer);

        service.transactFor(2);

        assertEquals(1, secondPlayer.score().points());
        assertEquals(5, firstPlayer.score().points());
    }
}

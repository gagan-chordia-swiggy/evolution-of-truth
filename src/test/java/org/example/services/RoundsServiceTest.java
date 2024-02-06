package org.example.services;

import org.example.entity.Cheater;
import org.example.entity.Cooperator;
import org.example.entity.CopyKitten;
import org.example.entity.Copycat;
import org.example.entity.Detective;
import org.example.entity.Grudger;
import org.example.entity.Player;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RoundsServiceTest {
    @Test
    void testBothPlayersAreCheatersAndAfter5RoundBothHaveZeroPoints() {
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Cheater());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, never()).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, never()).invest();
    }

    @Test
    void testBothPlayersCooperateAndAfter5RoundBothHaveZeroPoints() {
        Player firstPlayer = spy(new Cooperator());
        Player secondPlayer = spy(new Cooperator());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, times(5)).gain();
        verify(firstPlayer, times(5)).invest();
        verify(secondPlayer, times(5)).gain();
        verify(secondPlayer, times(5)).invest();
    }

    @Test
    void testFirstPlayerIsACheaterAndSecondPlayerIsCooperatorAndAfter5RoundThereAre15AndNegative5PointsRespectively() {
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Cooperator());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, times(5)).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, times(5)).invest();
    }

    @Test
    void testFirstPlayerIsCheaterAndSecondPlayerWillCopyAndWillHave3AndNegative1PointsRespectivelyAfter3Rounds() {
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Copycat());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(3);

        verify(firstPlayer, never()).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, never()).invest();
    }

    @Test
    void testFirstPlayerIsCopyKittenAndSecondPlayerIsCooperatorAndWillHave10PointsEachAfter5Rounds() {
        Player firstPlayer = spy(new CopyKitten());
        Player secondPlayer = spy(new Cooperator());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, times(5)).gain();
        verify(firstPlayer, times(5)).invest();
        verify(secondPlayer, times(5)).gain();
        verify(secondPlayer, times(5)).invest();
    }

    @Test
    void testFirstPlayerIsCooperatorAndSecondPlayerIsCopyKittenAndWillHave10PointsEachAfter5Rounds() {
        Player firstPlayer = spy(new Cooperator());
        Player secondPlayer = spy(new CopyKitten());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, times(5)).gain();
        verify(firstPlayer, times(5)).invest();
        verify(secondPlayer, times(5)).gain();
        verify(secondPlayer, times(5)).invest();
    }

    @Test
    void testFirstPlayerIsGrudgerAndSecondPlayerIsCopycatAndWillHave2And2PointsAfter5Rounds() {
        Player firstPlayer = spy(new Grudger());
        Player secondPlayer = spy(new Copycat());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(1)).invest();
    }

    @Test
    void testFirstPlayerIsCheaterAndSecondPlayerIsGrudgerAndWillHaveNegative1And3PointsAfter5Rounds() {
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Grudger());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(5);

        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, times(1)).invest();
    }

    @Test
    void testFirstPlayerIsDetectiveAndSecondPlayerIsCooperatorAndWillHave16And0PointsRespectivelyAfter6Rounds() {
        Player firstPlayer = spy(new Detective());
        Player secondPlayer = spy(new Cooperator());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(6);

        verify(firstPlayer, times(6)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(6)).invest();
    }

    @Test
    void testFirstPlayerIsDetectiveAndSecondPlayerIsGrudgerAndWill5And1PointsRespectivelyHaveAfter2Rounds() {
        Player firstPlayer = spy(new Detective());
        Player secondPlayer = spy(new Grudger());
        RoundsService service = new RoundsService(firstPlayer, secondPlayer);

        service.transactFor(2);

        verify(firstPlayer, times(2)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(2)).invest();
    }
}

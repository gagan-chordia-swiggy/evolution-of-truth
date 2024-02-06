package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlayerTest {
    @Test
    void testFirstAndSecondPlayerBothCooperateAndTransactionLedByFirstPlayerAndHave2CoinsEach() {
        // Arrange
        Player firstPlayer = spy(new Cooperator());
        Player secondPlayer = spy(new Cooperator());

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(1)).invest();
    }

    @Test
    void testFirstAndSecondPlayerBothCooperateAndTransactionLedBySecondPlayerAndHave2CoinsEach() {
        // Arrange
        Player firstPlayer = spy(new Cooperator());
        Player secondPlayer = spy(new Cooperator());

        // Act
        secondPlayer.transactWith(firstPlayer);

        // Assert
        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(1)).invest();
    }

    @Test
    void testBothPlayerDoNotCooperateAndHaveZeroCoinsEach() {
        // Arrange
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Cheater());

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        verify(firstPlayer, never()).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, never()).invest();
    }

    @Test
    void testFirstPlayerCooperatesAndHasNegative1CoinAndSecondPlayerCheatsAndHas3Coins() {
        // Arrange
        Player firstPlayer = spy(new Cooperator());
        Player secondPlayer = spy(new Cheater());

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        verify(firstPlayer, never()).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, never()).invest();
    }

    @Test
    void testFirstPlayerCheatsAndHas3CoinsAndSecondPlayerCooperatesAndHasNegative1Coin() {
        // Arrange
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Cooperator());

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, times(1)).invest();
    }

    @Test
    void testFirstPlayerIsCopycatAndSecondPlayerWillCooperateAndWillHave5And1PointsRespectivelyAfter2Rounds() {
        Player firstPlayer = spy(new Copycat());
        Player secondPlayer = spy(new Cooperator());

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        verify(firstPlayer, times(2)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(2)).invest();
    }

    @Test
    void testFirstPlayerIsCopyKittenAndSecondPlayerWillCheatAndWillHaveNegative1And3PointsRespectivelyAfter2Rounds() {
        Player firstPlayer = spy(new CopyKitten());
        Player secondPlayer = spy(new Cheater());

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        verify(firstPlayer, never()).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, never()).invest();
    }

    @Test
    void testFirstPlayerIsGrudgerAndSecondPlayerIsCheaterAndWillHaveNegative1And3PointsRespectivelyAfter2Rounds() {
        Player firstPlayer = spy(new Grudger());
        Player secondPlayer = spy(new Cheater());

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        verify(firstPlayer, never()).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, never()).invest();
    }

    @Test
    void testFirstPlayerIsGrudgerAndSecondPlayerIsCopycatAndWillHave2PointsEachAfter2Rounds() {
        Player firstPlayer = spy(new Grudger());
        Player secondPlayer = spy(new Copycat());

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, times(1)).invest();
        verify(secondPlayer, times(1)).gain();
        verify(secondPlayer, times(1)).invest();
    }

    @Test
    void testFirstPlayerIsACheaterAndSecondPlayerIsDetectiveAndWillHave3AndNegative1PointsAfter2Rounds() {
        Player firstPlayer = spy(new Cheater());
        Player secondPlayer = spy(new Detective());

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        verify(firstPlayer, times(1)).gain();
        verify(firstPlayer, never()).invest();
        verify(secondPlayer, never()).gain();
        verify(secondPlayer, times(1)).invest();
    }
}

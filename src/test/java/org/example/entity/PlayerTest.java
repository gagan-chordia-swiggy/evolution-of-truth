package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void testFirstAndSecondPlayerBothCooperateAndTransactionLedByFirstPlayerAndHave2CoinsEach() {
        // Arrange
        Player firstPlayer = new Cooperator();
        Player secondPlayer = new Cooperator();

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(2, firstPlayer.score.points());
        assertEquals(2, secondPlayer.score.points());
    }

    @Test
    void testFirstAndSecondPlayerBothCooperateAndTransactionLedBySecondPlayerAndHave2CoinsEach() {
        // Arrange
        Player firstPlayer = new Cooperator();
        Player secondPlayer = new Cooperator();

        // Act
        secondPlayer.transactWith(firstPlayer);

        // Assert
        assertEquals(2, firstPlayer.score.points());
        assertEquals(2, secondPlayer.score.points());
    }

    @Test
    void testBothPlayerDoNotCooperateAndHaveZeroCoinsEach() {
        // Arrange
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Cheater();

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(0, firstPlayer.score.points());
        assertEquals(0, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerCooperatesAndHasNegative1CoinAndSecondPlayerCheatsAndHas3Coins() {
        // Arrange
        Player firstPlayer = new Cooperator();
        Player secondPlayer = new Cheater();

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(-1, firstPlayer.score.points());
        assertEquals(3, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerCheatsAndHas3CoinsAndSecondPlayerCooperatesAndHasNegative1Coin() {
        // Arrange
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Cooperator();

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(3, firstPlayer.score.points());
        assertEquals(-1, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerIsCopycatAndSecondPlayerWillCooperateAndWillHave5And1PointsRespectivelyAfter2Rounds() {
        Player firstPlayer = new Copycat();
        Player secondPlayer = new Cooperator();

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        assertEquals(5, firstPlayer.score.points());
        assertEquals(1, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerIsCopyKittenAndSecondPlayerWillCheatAndWillHaveNegative1And3PointsRespectivelyAfter2Rounds() {
        Player firstPlayer = new CopyKitten();
        Player secondPlayer = new Cheater();

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        assertEquals(-1, firstPlayer.score.points());
        assertEquals(3, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerIsGrudgerAndSecondPlayerIsCheaterAndWillHaveNegative1And3PointsRespectivelyAfter2Rounds() {
        Player firstPlayer = new Grudger();
        Player secondPlayer = new Cheater();

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        assertEquals(-1, firstPlayer.score.points());
        assertEquals(3, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerIsGrudgerAndSecondPlayerIsCopycatAndWillHave2PointsEachAfter2Rounds() {
        Player firstPlayer = new Grudger();
        Player secondPlayer = new Copycat();

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        assertEquals(2, firstPlayer.score.points());
        assertEquals(2, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerIsACheaterAndSecondPlayerIsDetectiveAndWillHave3AndNegative1PointsAfter2Rounds() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Detective();

        firstPlayer.transactWith(secondPlayer);
        firstPlayer.transactWith(secondPlayer);

        assertEquals(3, firstPlayer.score.points());
        assertEquals(-1, secondPlayer.score.points());
    }
}

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
    void testBothPlayersAreCheatersAndAfter5RoundBothHaveZeroPoints() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Cheater();

        for (int ii = 0; ii < 5; ii++) {
            firstPlayer.transactWith(secondPlayer);
        }

        assertEquals(0, firstPlayer.score.points());
        assertEquals(0, secondPlayer.score.points());
    }

    @Test
    void testBothPlayersCooperateAndAfter5RoundBothHaveZeroPoints() {
        Player firstPlayer = new Cooperator();
        Player secondPlayer = new Cooperator();

        for (int ii = 0; ii < 5; ii++) {
            firstPlayer.transactWith(secondPlayer);
        }

        assertEquals(10, firstPlayer.score.points());
        assertEquals(10, secondPlayer.score.points());
    }

    @Test
    void testFirstPlayerIsACheaterAndSecondPlayerIsCooperatorAndAfter5RoundThereAre15AndNegative5PointsRespectively() {
        Player firstPlayer = new Cheater();
        Player secondPlayer = new Cooperator();

        for (int ii = 0; ii < 5; ii++) {
            firstPlayer.transactWith(secondPlayer);
        }

        assertEquals(15, firstPlayer.score.points());
        assertEquals(-5, secondPlayer.score.points());
    }
}

package org.example.entity;

import org.example.exceptions.InvalidCoinAdditionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    void testGetPlayerCoinsShouldReturn0() {
        // Arrange
        Player player = new Player();

        // Act
        int actual = player.coins();

        // Assert
        assertEquals(0, actual);
    }

    @Test
    void test3CoinsAreAddedForThePlayer() {
        // Arrange
        Player player = new Player();

        // Act
        player.addCoins(3);
        int actual = player.coins();

        // Assert
        assertEquals(3, actual);
    }

    @Test
    void testNoMoreThan1CoinCanBeDeductedThrowsException() {
        // Arrange
        Player player = new Player();

        // Assert
        assertThrows(InvalidCoinAdditionException.class, () ->
            player.addCoins(-2)
        );
    }

    @Test
    void testJustASingleCoinCannotBeAddedThrowsException() {
        // Arrange
        Player player = new Player();

        // Assert
        assertThrows(InvalidCoinAdditionException.class, () ->
            player.addCoins(1)
        );
    }

    @Test
    void testNoMoreThan3CoinsCanBeAddedAtOnceThrowsException() {
        // Arrange
        Player player = new Player();

        // Assert
        assertThrows(InvalidCoinAdditionException.class, () ->
                player.addCoins(4)
        );
    }

    @Test
    void testIfThePlayerWillCooperateReturnFalse() {
        // Arrange
        Player player = new Player();

        // Act
        boolean actual = player.willCooperate();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testIfPlayerDecidesToCooperateReturnTrue() {
        // Arrange
        Player player = new Player();

        // Act
        player.willCooperate(true);
        boolean actual = player.willCooperate();

        // Assert
        assertTrue(actual);
    }

    @Test
    void testBothPlayerCooperateAndHave2CoinsEach() {
        // Arrange
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        // Act
        firstPlayer.willCooperate(true);
        secondPlayer.willCooperate(true);
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(2, firstPlayer.coins());
        assertEquals(2, secondPlayer.coins());
    }

    @Test
    void testBothPlayerDoNotCooperateAndHaveZeroCoinsEach() {
        // Arrange
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        // Act
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(0, firstPlayer.coins());
        assertEquals(0, secondPlayer.coins());
    }

    @Test
    void testFirstPlayerCooperatesAndHasNegative1CoinAndSecondPlayerCheatsAndHas3Coins() {
        // Arrange
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        // Act
        firstPlayer.willCooperate(true);
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(-1, firstPlayer.coins());
        assertEquals(3, secondPlayer.coins());
    }

    @Test
    void testFirstPlayerCheatsAndHas3CoinsAndSecondPlayerCooperatesAndHasNegative1Coin() {
        // Arrange
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();

        // Act
        secondPlayer.willCooperate(true);
        firstPlayer.transactWith(secondPlayer);

        // Assert
        assertEquals(3, firstPlayer.coins());
        assertEquals(-1, secondPlayer.coins());
    }
}

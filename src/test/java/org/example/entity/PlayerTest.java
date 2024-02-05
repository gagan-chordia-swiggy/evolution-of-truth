package org.example.entity;

import org.example.exceptions.InvalidCoinAdditionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        player.add(3);
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
            player.add(-2)
        );
    }

    @Test
    void testJustASingleCoinCannotBeAddedThrowsException() {
        // Arrange
        Player player = new Player();

        // Assert
        assertThrows(InvalidCoinAdditionException.class, () ->
            player.add(1)
        );
    }

    @Test
    void testNoMoreThan3CoinsCanBeAddedAtOnceThrowsException() {
        // Arrange
        Player player = new Player();

        // Assert
        assertThrows(InvalidCoinAdditionException.class, () ->
                player.add(4)
        );
    }
}

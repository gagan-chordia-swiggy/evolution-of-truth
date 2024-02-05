package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}

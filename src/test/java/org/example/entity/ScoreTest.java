package org.example.entity;

import org.example.exceptions.InvalidPointsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreTest {
    @Test
    void test3PointsAreAddedToTheScore() {
        Score score = new Score();

        score.add(3);

        assertEquals(3, score.points());
    }

    @Test
    void test2PointsAreAddedToTheScore() {
        Score score = new Score();

        score.add(2);

        assertEquals(2, score.points());
    }

    @Test
    void testNegative1PointsAreAddedToTheScore() {
        Score score = new Score();

        score.add(-1);

        assertEquals(-1, score.points());
    }

    @Test
    void test1PointUpdateThrowsException() {
        Score score = new Score();

        assertThrows(InvalidPointsException.class, () -> score.add(1));
    }

    @Test
    void testLessThanNegative1PointUpdateThrowsException() {
        Score score = new Score();

        assertThrows(InvalidPointsException.class, () -> score.add(-2));
    }

    @Test
    void testMoreThan3PointsUpdateThrowsException() {
        Score score = new Score();

        assertThrows(InvalidPointsException.class, () -> score.add(4));
    }
}

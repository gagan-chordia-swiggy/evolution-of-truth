package org.example.entity;

import org.example.exceptions.InvalidPointsException;

public class Score {
    private int points;

    public Score() {
        this.points = 0;
    }

    public void add(int points) {
        if (points < -1 || points == 1 || points > 3) {
            throw new InvalidPointsException();
        }

        this.points += points;
    }

    public int points() {
        return this.points;
    }
}

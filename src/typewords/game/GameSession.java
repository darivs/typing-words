package typewords.game;// Created by Darius on 24.06.2016.

public class GameSession {

    private int lives;
    private int points = 0;

    public GameSession(int initialLives) {
        assert initialLives >= 0;
        lives = initialLives;
    }

    public GameState decrementLives() {
        if(lives == 0) {
            return GameState.LIVES_EXCEEDED;
        }
        lives--;
        return GameState.RUNNING;
    }

    public void incrementPoints() {
        points++;
    }

    public int getLives() {
        return lives;
    }

    public int getPoints() {
        return points;
    }
}

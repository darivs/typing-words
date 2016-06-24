package typewords.game;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

// Created by Darius on 24.06.2016.
public class GameSessionTest {

    @Test(expected = AssertionError.class)
    public void initial_lives_below_zero() {
        new GameSession(-1);
    }

    @Test
    public void decrement_lives() {
        GameSession session = new GameSession(2);
        GameState state = session.decrementLives();
        assertThat(1, equalTo(session.getLives()));
        assertThat(GameState.RUNNING, equalTo(state));
        state = session.decrementLives();
        assertThat(0, equalTo(session.getLives()));
        assertThat(state, equalTo(GameState.RUNNING));
    }

    @Test
    public void decrement_lives_below_zero() {
        GameSession session = new GameSession(1);
        session.decrementLives();
        GameState state = session.decrementLives();
        assertThat(state, equalTo(GameState.LIVES_EXCEEDED));
    }

    @Test
    public void increment_points() {
        GameSession session = new GameSession(1);
        session.incrementPoints();
        assertThat(1, equalTo(session.getPoints()));
    }
}
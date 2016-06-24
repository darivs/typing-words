package typewords.game;// Created by Darius on 22.06.2016.

import typewords.data.DataException;
import typewords.data.WordInterface;
import typewords.data.WordManager;

import java.util.concurrent.ThreadLocalRandom;

public class GameEngine {

    private GameSession session = new GameSession(10);
    private WordInterface wordProvider;

    public GameEngine(){
        wordProvider = new WordManager();
    }

    int xPos = -50, yPos = 75, ms = 3;


    public void moveWord() {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        xPos += 1;
    }

    public int getPositionX() {
        return xPos;
    }

    public int getPositionY() {
        return yPos;
    }

    private void resetPosition() {
        xPos = -50;
        yPos = ThreadLocalRandom.current().nextInt(25, 220);

    }

    public String checkIfCollided(int width, String data, String wordNow) {
        String newWord = null;

        if (xPos >= width) {

            if (data.equals(wordNow)) {
                session.incrementPoints();

                //ms *= 0.95;  --->  Thread.sleep(ONLY INTEGER)
                System.out.println("correct input - points: " + getPoints());
            } else {
                GameState state = session.decrementLives();

                switch (state) {
                    case LIVES_EXCEEDED: System.out.println("GAME OVER! - No lives remaining"); break;
                    case RUNNING: System.out.println("false input: " + data + " - lives remaining: " + getLives()); break;
                    default: break;
                }
            }

            try {
                newWord = wordProvider.declareWord();
            } catch (DataException e) {
                e.printStackTrace();
            }
            resetPosition();
        }

        return newWord;
    }

    public int getLives() {
        return session.getLives();
    }

    public int getPoints() {
        return session.getPoints();
    }
}


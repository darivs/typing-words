package typewords.game;// Created by Darius on 22.06.2016.

import typewords.data.DataException;
import typewords.data.WordInterface;
import typewords.data.WordManager;
import typewords.ui.GamePanel;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameEngine {

    private GameSession session = new GameSession(10);
    private WordInterface wordProvider;
    private long millis;

    public GameEngine(){
        wordProvider = new WordManager();
    }

    int xPos = -50, yPos = 75;
    float ms = 4f;
    String newWord = null;


    public void moveWord() {
        try {
            millis = (long) ms;
            Thread.sleep(millis);
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

        if (xPos >= width) {
            getFaster();

            if (data.equals(wordNow)) {
                session.incrementPoints();

                //ms *= 0.95;  --->  Thread.sleep(ONLY INTEGER)
                System.out.println("correct input - points: " + getPoints() + " | speed:" + millis);
            } else {
                GameState state = session.decrementLives();

                switch (state) {
                    case LIVES_EXCEEDED:
                        endSession(); break;
                    case RUNNING:
                        System.out.println("false input: " + data + " - lives remaining: " + getLives() + " | speed:" + millis); break;
                    case ABORTED:
                        System.exit(0); break;
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

    private void endSession() {
        System.out.println("GAME OVER! - No lives remaining");
        JOptionPane.showMessageDialog(null, "GAME OVER\nLives exceeded!", "No lives remaining", 1);
        new GamePanel().endSession();
    }

    private void getFaster() {

        ms *= 0.5;
    }
}


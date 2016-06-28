package typewords.game;// Created by Darius on 22.06.2016.

import typewords.data.DataException;
import typewords.data.ScoreManager;
import typewords.data.WordInterface;
import typewords.data.WordManager;
import typewords.ui.Main;
import typewords.ui.ScorePanel;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameEngine {

    private GameSession session = new GameSession(3);
    private WordInterface wordProvider;
    private ScoreManager scoreProvider;
    private ScorePanel scoreUI;
    private long millis, wordLength;
    private float factor = 1;

    public GameEngine(){
        wordProvider = new WordManager();
        scoreProvider = new ScoreManager();
        scoreUI = new ScorePanel();
    }

    int xPos = -50, yPos = 75;

    public void moveWord(int length) {
        wordLength = length;

        if (wordLength == 3) wordLength++;
        millis = (long) ((wordLength - 1) * factor);

        try { Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(); }

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
                if (wordLength > 3) {                       //only get faster when correct input and word larger than 3
                    factor = session.getFaster(factor);
                }

                session.incrementPoints();
                System.out.println("correct input | points: " + getPoints() + " | speed:" + millis + " | factor " + factor);
            } else {
                GameState state = session.decrementLives();

                switch (state) {
                    case LIVES_EXCEEDED:
                        endSession();

                        //does not come till here because of system.exit() in main class / line 113
                        scoreProvider.getScore(session.getPoints());
                        scoreUI.enterScore(); break;
                    case RUNNING:
                        System.out.println("false input: " + data + " | lives remaining: " + getLives() + " | speed:" + millis + " | factor " + factor); break;
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

        int result = JOptionPane.showConfirmDialog(null, "all lives exceeded!","Game Over", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            new Main().exit();          // but only want to close frame and open another
        }
    }
}


package typewords.ui;// Created by Darius on 22.06.2016.

import typewords.data.DataException;
import typewords.data.WordInterface;
import typewords.data.WordManager;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private WordInterface wordProvider;

    private int newPoints, newLives = 10;

    public Game(){
        wordProvider = new WordManager();
    }

    int xPos = -50, yPos = 75, ms = 3;

    public int getNewLives() {
        return newLives;
    }

    public int getNewPoints() {
        return newPoints;
    }

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

    public String checkIfCollided(int width, JTextField data, String wordNow, int points, int lives, JLabel jlPoints, JLabel jlLives) {
        if (xPos >= width) {

            if (data.getText().equals(wordNow)) {
                newPoints = points + 1;
                jlPoints.setText("Points: " + newPoints);
                //ms *= 0.95;  --->  Thread.sleep(ONLY INTEGER)
                System.out.println("correct input - points: " + newPoints);
            } else {
                newLives = lives - 1;
                jlLives.setText("Lives: " + newLives);
                if (newLives < 0) {
                    JOptionPane.showMessageDialog(null, "No lives remaining", "Game over!", JOptionPane.OK_OPTION);
                    new Main().exit();
                } else {
                    System.out.println("false input: " + data.getText() + " - lives remaining: " + newLives);
                }
            }

            try {
                wordNow = wordProvider.declareWord();
            } catch (DataException e) {
                e.printStackTrace();
            }

            data.setText("");
            resetPosition();
        }

        return wordNow;
    }
}


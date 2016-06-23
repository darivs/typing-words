package typewords.ui;// Created by Darius on 22.06.2016.

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    int xPos = -50, yPos = 75, ms = 4;

    public int decrementLive(int remainingLives) {
        if (remainingLives > 0) {
            remainingLives--;
        } else {
            System.out.println("Game over");
        }
        return remainingLives;
    }

    public int addPoints(int actualPoints) {
        System.out.println("Points: " + actualPoints);
        return actualPoints++;
    }

    public void wordCollapsed(){
        resetPosition();
    }

    public void moveWord(){
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
        xPos += 1;
    }

    public int getPositionX(){
        return xPos;
    }

    public int getPositionY(){
        return yPos;
    }

    private void resetPosition(){
        xPos = -50;
        yPos = ThreadLocalRandom.current().nextInt(25, 220);

    }

    public boolean checkIfCollided(int width){
        if (getPositionX() >= width) { return true; } else { return false; }
    }

    //private String getNewWord(String actualWord) throws DataException {
    //    return actualWord = wordProvider.declareWord();
    //}
}

package typewords.ui;// Created by Darius on 22.06.2016.

import typewords.data.DataException;
import typewords.data.WordInterface;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private WordInterface wordProvider;
    int xPos = -50, yPos = 75, ms = 4;

    public int decrementLive(int remainingLives) {
        if (remainingLives > 0) {
            remainingLives--;
        } else {
            System.out.println("Game over");
        }
        return remainingLives;
    }

    public void collapsed(){
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

    public String getNewWord(String currentWord){
        try { currentWord = wordProvider.declareWord(); }
        catch (DataException e) { e.printStackTrace(); }

        return currentWord;
    }

    public void resetPosition(){
        xPos = -50;
        yPos = ThreadLocalRandom.current().nextInt(25, 220);
    }
}

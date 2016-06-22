package typewords.ui;// Created by Darius on 20.06.2016.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener { //no function atm
    String word;
    private Game gameObj;

    public KeyEventListener(Game givenObj) {
        gameObj = givenObj;
    }

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) { }


    @Override
    public void keyReleased(KeyEvent e) {
        getKey(e);
    }


    private void getKey(KeyEvent released) {
        char k = released.getKeyChar();
        System.out.println(released.getKeyChar());
        word = gameObj.getCurrentWord();

        System.out.println(word);

        if(word.charAt(0) == k) {System.out.println("First char released");}
        if(word.charAt(1) == k) {System.out.println("Second char released");}
        // currentWord is static - need better solution
    }
}
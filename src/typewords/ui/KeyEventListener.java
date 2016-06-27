package typewords.ui;// Created by Darius on 20.06.2016.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener { //no function atm
    String word, text;
    private GamePanel gamePanelObj;

    public KeyEventListener(GamePanel givenObj) {
        gamePanelObj = givenObj;
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
        //System.out.println(released.getKeyChar());
        word = gamePanelObj.getCurrentWord();

        /* //check if word get changed and char released
        System.out.println(word);
        if(word.charAt(0) == k) {System.out.println("First char released");}
        if(word.charAt(1) ==k) {System.out.println("Second char released");}
        */

    }
}

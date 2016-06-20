package typewords.ui;// Created by Darius on 20.06.2016.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener {

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

        if(new Game().str.charAt(1) == k) {System.out.println("hi");}
        // str is static - need better solution

    }
}

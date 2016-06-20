package typewords.ui;// Created by Darius on 20.06.2016.

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventManager implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { /*test*/ }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

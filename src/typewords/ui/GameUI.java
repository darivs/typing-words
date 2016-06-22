package typewords.ui;// Created by Darius on 20.06.2016.

import typewords.data.WordInterface;
import typewords.data.WordManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameUI extends JPanel{

    JFrame game = new JFrame("Typing-Words");

    public int points = 0, lives = 10;
    public GameUI thisGameUI;
    private Game thisGame = new Game();

    JPanel subPanel = new JPanel();
    JTextField jf = new JTextField("Hello", 42);
    JLabel jPoints = new JLabel("Points: " + points);
    JLabel jLives = new JLabel("");

    public String currentWord = "boo";

    private WordInterface wordProvider;

    public GameUI() {
        wordProvider = new WordManager();
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setPreferredSize(new Dimension(600,300));
    }

    public void startGame() throws IOException {
        repaintLabel(jLives);

        thisGameUI = new GameUI();
        game.add(thisGameUI);

        jPoints.setBackground(Color.GREEN);
        jLives.setBackground(Color.RED);
        jPoints.setOpaque(true);
        jLives.setOpaque(true);

        subPanel.add(jf, 0);
        subPanel.add(jPoints, 1);
        subPanel.add(jLives, 2);
        subPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        game.getContentPane().add(BorderLayout.PAGE_END, subPanel);

        game.pack();
        game.setVisible(true);

        System.out.println(jf.getText());
        System.out.println(jPoints.getText());

        jf.addKeyListener(new KeyEventListener(thisGameUI));
    }

    private void repaintLabel(JLabel label) {
        label.setText("Lives: " + lives);
        label.repaint();
        System.out.println(label.getText());
    }

    public String getCurrentWord(){
        return currentWord;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Times Roman", Font.PLAIN, 18));

        thisGame.moveWord();

        if (thisGame.getPositionX() >= this.getWidth()) {
            lives = thisGame.decrementLive(lives);
            thisGame.collapsed();
            currentWord = thisGame.getNewWord(currentWord);

            //repaintLabel(jLives);
        }

        g2.drawString(currentWord, thisGame.getPositionX(), thisGame.getPositionY());
        repaint();
    }
}
package typewords.ui;// Created by Darius on 20.06.2016.

import typewords.data.DataException;
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
    private boolean collided = false;

    JPanel subPanel = new JPanel();
    JTextField textBox = new JTextField("test", 42);
    JLabel jPoints = new JLabel("Points: " + points);
    JLabel jLives = new JLabel("Lives: " + lives);

    public String currentWord = "boo";

    private WordInterface wordProvider;

    public GameUI() {
        wordProvider = new WordManager();
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setPreferredSize(new Dimension(600,300));
    }

    public void startGame() throws IOException {
        thisGameUI = new GameUI();
        game.add(thisGameUI);

        jPoints.setBackground(Color.GREEN);
        jLives.setBackground(Color.RED);
        jPoints.setOpaque(true);
        jLives.setOpaque(true);

        subPanel.add(textBox, 0);
        subPanel.add(jPoints, 1);
        subPanel.add(jLives, 2);
        subPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        game.getContentPane().add(BorderLayout.PAGE_END, subPanel);

        game.pack();
        game.setVisible(true);

        System.out.println(textBox.getText());      //always the same (?)
        System.out.println(jPoints.getText());

        textBox.addKeyListener(new KeyEventListener(thisGameUI));
    }

    public String getCurrentWord(){
        return currentWord;
    }
    //public String getTextOfField() { return this.textBox.getText(); }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Times Roman", Font.PLAIN, 18));

        thisGame.moveWord();
        collided = thisGame.checkIfCollided(this.getWidth());

        if (collided) {
            if (textBox.getText().equals(currentWord)) {
                textBox.setText("");
                points = thisGame.addPoints(points);
                System.out.println("Actual points: " + points);
            } else {
                try {
                    currentWord = wordProvider.declareWord();
                    lives = thisGame.decrementLive(lives);
                    System.out.println(this.textBox.getText() + " / Lives remaining: " + lives);
                } catch (DataException e) {
                    e.printStackTrace();
                }
            }
            thisGame.wordCollapsed();
        }

        g2.drawString(currentWord, thisGame.getPositionX(), thisGame.getPositionY());
        repaint();
    }
}
package typewords.ui;// Created by Darius on 20.06.2016.

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameUI extends JPanel {

    JFrame game = new JFrame("Typing-Words");

    public int points, lives;
    private Game thisGame = new Game();

    JPanel subPanel = new JPanel();
    JTextField textBox = new JTextField("", 42);
    JLabel jPoints, jLives;

    public String currentWord = "boo";

    public GameUI() {
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setPreferredSize(new Dimension(600,300));
    }

    public void startGame() throws IOException {
        game.add(this);
        jPoints = new JLabel("Points: 0");
        jLives = new JLabel("Lives: 10");

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

        textBox.addKeyListener(new KeyEventListener(this));
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
        currentWord = thisGame.checkIfCollided(this.getWidth(), textBox, currentWord, points, lives, jPoints, jLives);
        points = thisGame.getNewPoints();
        lives = thisGame.getNewLives();

        g2.drawString(currentWord, thisGame.getPositionX(), thisGame.getPositionY());
        repaint();
    }
}
package typewords.ui;// Created by Darius on 20.06.2016.

import typewords.game.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameUI extends JPanel {

    private static final int TEXTFIELD_WIDTH = 42;
    private JFrame frame = new JFrame("Typing-Words");

    private GameEngine gameEngine = new GameEngine();

    JPanel subPanel = new JPanel();
    JTextField textBox = new JTextField("", TEXTFIELD_WIDTH);
    JLabel jPoints, jLives;

    public String currentWord = "boo";

    public GameUI() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,300));
    }

    public void startGame() throws IOException {
        frame.add(this);
        jPoints = new JLabel();
        jLives = new JLabel();

        updateLabel();

        jPoints.setBackground(Color.GREEN);
        jLives.setBackground(Color.RED);
        jPoints.setOpaque(true);
        jLives.setOpaque(true);

        subPanel.add(textBox, 0);
        subPanel.add(jPoints, 1);
        subPanel.add(jLives, 2);
        subPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(BorderLayout.PAGE_END, subPanel);

        frame.pack();
        frame.setVisible(true);

        System.out.println(textBox.getText());      //always the same (?)
        System.out.println(jPoints.getText());

        textBox.addKeyListener(new KeyEventListener(this));
    }

    public String getCurrentWord(){
        return currentWord;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Times Roman", Font.PLAIN, 18));

        gameEngine.moveWord();
        String newWord = gameEngine.checkIfCollided(this.getWidth(), textBox.getText(), currentWord);
        if(newWord != null) {
            currentWord = newWord;
            textBox.setText("");
        }

        updateLabel();

        g2.drawString(currentWord, gameEngine.getPositionX(), gameEngine.getPositionY());
        repaint();
    }

    public void updateLabel() {
        jPoints.setText("Points: " + gameEngine.getPoints());
        jLives.setText("Lives: " + gameEngine.getLives());
    }
}
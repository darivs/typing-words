package typewords.ui;// Created by Darius on 20.06.2016.

import typewords.data.DataException;
import typewords.data.WordInterface;
import typewords.data.WordManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends JPanel{

    JFrame game = new JFrame("Typing-Words");
    JTextField jf;

    public static String str = "Valar Morghulis";
    private WordInterface wordProvider;
    int xPos = -50, yPos = 75, ms = 4;

    public Game() {
        wordProvider = new WordManager();
    }

    public void startGame() throws IOException {
        jf = new JTextField("Valar Morghulis", 5);
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(Color.CYAN);
        game.setPreferredSize(new Dimension(600,300));
        game.add(new Game());
        game.getContentPane().add(BorderLayout.SOUTH, jf);
        game.pack();

        game.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Times Roman", Font.PLAIN, 18));

        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
        xPos += 1;

        if (xPos >= this.getWidth()) {
            xPos = -100;
            yPos = ThreadLocalRandom.current().nextInt(25, 255);
            try { str = wordProvider.declareWord(); } catch (DataException e) { e.printStackTrace(); }
        }

        g2.drawString(str, xPos, yPos + 5);

        repaint();
    }
}

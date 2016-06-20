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

    public String str = "Valar Morghulis";
    private WordInterface wordProvider;
    int xPos = -50, yPos = 75, ms = 4;

    public Game() {
        wordProvider = new WordManager();
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setPreferredSize(new Dimension(600,300));
    }

    public void startGame() throws IOException {
        game.add(new Game());

        jf = new JTextField("Valar Dohaeris", 1);
        game.getContentPane().add(BorderLayout.SOUTH, jf);

        game.pack();
        game.setVisible(true);

        System.out.println(jf.getText());

        jf.addKeyListener(new KeyEventListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Times Roman", Font.PLAIN, 18));

        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
        xPos += 1;

        if (xPos >= this.getWidth()) {
            xPos = -50;
            yPos = ThreadLocalRandom.current().nextInt(25, 240);
            try {
                str = wordProvider.declareWord();
            } catch (DataException e) {
                e.printStackTrace();
            }
        }

        g2.drawString(str, xPos, yPos);
        repaint();
    }
}


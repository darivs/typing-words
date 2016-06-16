package typewords.ui;

import typewords.data.WordManager;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

// Created by Darius on 06.06.2016.

public class Main extends JPanel {
    JFrame game = new JFrame("Typing-Words");
    public static String str = "Viel Spaß!";

    int xPos = 0, yPos = 75, ms = 5;

    public static void main(String[] args) { new Menue().menue(); }

    public void start() throws IOException {
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.getContentPane().setBackground(Color.BLACK);
        game.setSize(400, 200);
        game.add(new Main());
        game.setVisible(true);
    }

    /*public static void loadList() throws IOException {
        Path p = new typewords.data.FileManager().getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "scorelist.txt");
        List<String> l = Files.readAllLines(p);
    }*/

    public static void exit() {
        System.exit(0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Times Roman", Font.PLAIN, 20));

        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
        xPos += 1;

        if (xPos >= this.getWidth()) {
            xPos = -15;
            yPos = ThreadLocalRandom.current().nextInt(15, 155);
            try { str = new WordManager().declareWord(); } catch (FileNotFoundException e) { e.printStackTrace(); }
        }

        g2.drawString(str, xPos, yPos);

        repaint();
    }
}

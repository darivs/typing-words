import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

// Created by Darius on 06.06.2016.


public class Main extends JFrame {

    int xpos = 0, ypos = 0, xvel = 0, yvel = 0;

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        SwingUtilities .invokeLater(new Runnable() {
            @Override
            public void run() {
                showFrame();
            }
        });

        //new Menue().menue();
    }

    private static void showFrame() {
        Main mainFrame = new Main();
        mainFrame.setVisible(true);
    }

    public Main() {
        super("Typing Words");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createContent();
        setBounds(50,50,400,200);
    }

    private void createContent() {
        JPanel content = new JPanel();

        /*
        Timer t = new Timer().start();

        t.schedule(new TimerTask() {
        @Override
        public void run() {
        */content.add(new JLabel(new TypingWords().declareWord()));/*
        }
        }, 0, 1000);
        */

        setContentPane(content);
    }

    @Override
    public void dispose() {
         super.dispose();
        System.out.println("Valar Morghulis");
    }

    public static String decide() {
        String c = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try { c = br.readLine(); } catch (IOException e) { e.printStackTrace(); }

        return c;
    }

    public static void start() throws IOException {
        clearScreen();
        System.out.println("rnd word: " + new TypingWords().declareWord());
    }

    public static void loadList() throws IOException {
        Path p = new TypingWords().getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "scorelist.txt");
        List<String> l = Files.readAllLines(p);
    }

    public static void exit() {
        System.exit(0);
    }

    public static void clearScreen() {
        for (int i = 0; i < 15; i++) { System.out.print("\n"); }
    }
}

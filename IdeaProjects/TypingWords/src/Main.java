import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;

// Created by Darius on 06.06.2016.

public class Main {

    public static void main(String[] args) {
        //Timer timer = new Timer();

        System.out.println("\n\tMenue\n\t=====\n");
        System.out.println("\t(1) Start\n\t(2) Highscore\n\t(3) Exit\n\t");

        //timer.schedule(new Draw(), 0, 5000);

        decide();

    }

    public static String decide() {
        String c = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch(c) {
            case "1": try {start();} catch (IOException e) {e.printStackTrace();} break;
            case "2": loadList(); break;
            case "3": exit(); break;
            default: System.out.println("false entry!"); break;
        }

        return c;
    }

    public static void start() throws IOException {
        clearScreen();
        System.out.println("your word: " + new TypingWords().declareWord());
    }

    public static void loadList() {
        // highscore
    }

    public static void exit() {
        System.exit(0);
    }

    public static void clearScreen() {
        for (int i = 0; i < 10; i++) { System.out.println(); }
    }
}

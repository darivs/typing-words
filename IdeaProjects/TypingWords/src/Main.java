import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

// Created by Darius on 06.06.2016.

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\tMenue\n\t=====\n\t(1) Start\n\t(2) Highscore\n\t(3) Exit\n\t");

        decide();
    }

    public static String decide() {
        String c = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try { c = br.readLine(); } catch (IOException e) { e.printStackTrace(); }

        switch(c) {
            case "1": try { start(); } catch (IOException e) { e.printStackTrace(); } break;
            case "2": try { loadList(); } catch (IOException e) { e.printStackTrace(); } break;
            case "3": exit(); break;
            default: System.out.println("false entry!"); break;
        }

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

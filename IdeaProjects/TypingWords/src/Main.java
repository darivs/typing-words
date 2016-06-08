import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Created by Darius on 06.06.2016.

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\t= Menue =\n\t=========\n");
        System.out.println("\t(1) Start\n\t(2) Highscore\n\t(3) Exit\n\t");

        String rndWord = new TypingWords().declareWord();
        System.out.println("random word:\t" + rndWord);

        decide();
    }

    public static String decide() {
        String c = "", msg = "false entry!";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            c = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //c = "2";

        switch(c) {
            case "1": msg = "starting...";      break;
            case "2": msg = "loading list...";  break;
            case "3": msg = "closing...";       break;
            default:                            break;
        }

        System.out.println("\n\t" + msg + "\n");

        return c;
    }
}

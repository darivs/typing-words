import java.util.Scanner;

// Created by Darius on 06.06.2016.

public class Main {
    public static void main(String argy[]) {
        System.out.println("\n\t= Menue =\n\t=========\n");
        System.out.println("\t(1) Start\n\t(2) Highscore\n\t(3) Exit\n\t");

        decide();
    }

    public static String decide(){
        Scanner sc = new Scanner(System.in);

        String c = /*sc.nextLine()*/ "1";
        sc.close();

        //System.out.println(c);

        return c;
    }
}

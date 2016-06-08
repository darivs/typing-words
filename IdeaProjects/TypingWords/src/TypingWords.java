import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TypingWords {
    String[] words;

    public String declareWord() {
        String w = new String();

        try {
            BufferedReader br = new BufferedReader(new FileReader("words.txt"));
            String row = br.readLine();

            if (row != null) {
                words = row.split(";");
            }

            int r = ThreadLocalRandom.current().nextInt(0, words.length - 1);
            w = words[r];

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return w;
    }

    public Boolean collidedWord() {
        Boolean col = true;

        if (col) {
            col = true;
        }

        return col;
    }

    /*public String chosenMenu(String chosen) {
        String c = chosen;
        System.out.println(c);
        return c;
    }*/
}


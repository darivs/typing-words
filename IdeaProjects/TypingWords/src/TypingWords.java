import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TypingWords {
    public List<String> words = new ArrayList<>();

    public String declareWord() throws FileNotFoundException {
        words = new DataManaging().declareList();
        String w = words.get(getRandomInteger(words.size()));

        return w;
    }

    public int getRandomInteger(int size) {
        int r = ThreadLocalRandom.current().nextInt(0, size - 1);

        return r;
    }

    public String[] splitString(String row, String c) {
        String[] x = row.split(c);

        return x;
    }

    /*public Boolean collidedWord() {
        Boolean col = true;

        return col;
    }*/
}


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordManager {

    private List<String> words = new ArrayList<>();
    private WordList wl = new WordList();


    public String declareWord() throws FileNotFoundException {
        words = wl.declareList();
        String w = words.get(getRandomInteger(words.size()));

        return w;
    }

    public int getRandomInteger(int size) {
        int r = ThreadLocalRandom.current().nextInt(0, size - 1);

        return r;
    }
}

package typewords.data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordManager implements WordInterface {

    private List<String> words = new ArrayList<>();

    public String declareWord() throws DataException {
        words = new WordList().declareList();
        String w = words.get(getRandomInteger(words.size()));

        return w;
    }

    public int getRandomInteger(int size) {
        int r = ThreadLocalRandom.current().nextInt(0, size - 1);

        return r;
    }
}

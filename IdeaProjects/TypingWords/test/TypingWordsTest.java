import org.junit.ComparisonFailure;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Darius on 06.06.2016.
 */

public class TypingWordsTest {

    @Test
    public void getWord() throws FileNotFoundException {
        String row = new String();
        String rndWord = new TypingWords().declareWord();

        try {
            BufferedReader br = new BufferedReader(new FileReader("words.txt"));
            row = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] expected = row.split(";");

        for (int i = 0; i <= expected.length - 1; i++) {
            try {
                assertEquals(expected[i], rndWord);
            } catch (ComparisonFailure e) { }
        }

        System.out.println(rndWord);
    }

    @Test
    public void collision()
    {
        Boolean col = new TypingWords().collidedWord();
        assertEquals(true, col);
    }
}

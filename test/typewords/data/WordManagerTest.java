package typewords.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordManagerTest {
    public static String testdata;
    public static String[] testArray;
    private static WordManager wM = new WordManager();
    private static WordList wL =  new WordList();
    private static List<String> row;
    private static Path p;

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        testArray = new String[] { };

        p = new FileManager().getPath("C:/workspace/typing-words/", "test/typewords/data/twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }

        testdata = row.get(0);
    }

    @Test
    public void declareWordWhenItsValid() throws FileNotFoundException {
        splitRowAtSimicolon();

        assertThat(Arrays.asList(testArray), hasItem(wM.declareWord()));
    }

    @Test
    public void getRandomValueBetweenArrayLength() {
        int r = wM.getRandomInteger(6);

        assertThat(r <= 5, is(true));
    }

    @Test
    public void splitRowAtSimicolon() {
        testArray = wL.splitString(testdata, ";");

        assertThat(Arrays.asList(testArray), hasItems("Robb", "Sansa", "Bran"));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}

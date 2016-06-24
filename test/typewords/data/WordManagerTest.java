package typewords.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class WordManagerTest {
    public static String testdata;
    public static String[] testArray;
    private static WordManager wM = new WordManager();
    private static WordList wL =  new WordList();
    private static List<String> row;
    private static Path p;

    @BeforeClass
    public static void initValues() throws Exception { /* initialize pub values */
        URL resource = WordManagerTest.class.getClassLoader().getResource("typewords/data/twords.txt");
        row = Files.readAllLines(Paths.get(resource.toURI()));
        testdata = row.get(0);
    }

    @Test
    public void declareWord_when_its_valid() throws Exception {
        splitRowAtSimicolon_when_right_value();

        assertThat(Arrays.asList(testArray), hasItem(wM.declareWord()));
    }

    @Test
    public void get_random_value_between_array_length() {
        int r = wM.getRandomInteger(6);

        assertThat(r <= 5, is(true));
    }

    @Test
    public void splitRowAtSimicolon_when_right_value() {
        testArray = wL.splitString(testdata, ";");

        assertThat(Arrays.asList(testArray), hasItems("Robb", "Sansa", "Bran"));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}

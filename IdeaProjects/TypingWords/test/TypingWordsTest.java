import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

// Created by Darius on 06.06.2016.

public class TypingWordsTest {
    private static Path p;
    private static List<String> row;
    private static String testdata;
    private static String[] testArray;

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new TypingWords().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
        testdata = row.get(0);
        testArray = new String[] { };
    }

    @Test
    public void splitRowAtSimicolon() {
        testArray = new TypingWords().splitString(testdata, ";");

        assertThat(Arrays.asList(testArray), hasItems("Robb", "Sansa", "Bran"));
    }

    @Test
    public void declareWordWhenItsValid() throws FileNotFoundException {
        splitRowAtSimicolon();

        assertThat(Arrays.asList(testArray), hasItem(new TypingWords().declareWord()));
    }

    @Test
    public void declareWordFilesWhenOnlyOneRow() throws FileNotFoundException {
        int f1 = new TypingWords().countLinesInFile("test/twords.txt");
        int f2 = new TypingWords().countLinesInFile("words.txt");

        assertThat(f1, is(equalTo(1)));
        assertThat(f2, is(equalTo(f1)));
    }

    @Test
    public void getRandomValueBetweenArrayLength() {
        int r = new TypingWords().getRandomInteger(6);

        assertThat(r <= 5, is(true));
    }

    /*@Ignore
    @Test
    public void disappearWordIfCollided() {
        Boolean col = new TypingWords().collidedWord();
        assertThat(col, is(true));

        // let the word disappear
    }*/

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}

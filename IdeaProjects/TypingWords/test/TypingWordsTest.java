import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

// Created by Darius on 06.06.2016.

public class TypingWordsTest {

    @Before
    public void initValues() { /* declare and initialize pub values */ }

    @Test
    public void splitRowAtSimicolon() {
        String testdaten = "Robb;Sansa;Bran";
        String[] words = new TypingWords().splitString(testdaten, ";");

        assertThat(Arrays.asList(words), hasItems("Robb", "Sansa", "Bran"));
    }

    @Test
    public void checkDataIfEqual() {
        Path p = new TypingWords().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        List<String> row = new ArrayList<>();
        String testdaten = "Robb;Sansa;Bran;Arya;Rickon;Jon";

        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }

        assertThat(row.get(0), is(equalTo(testdaten)));
    }

    @Test
    public void declareWordlistWhenOnlyOneRow() throws FileNotFoundException {
        int c = new TypingWords().countLinesInFile("test/twords.txt");

        assertThat(c, is(1));
    }

    @Test
    public void getRandomValueBetweenArrayLength() {
        String[] testdaten = new String[5];
        int r = new TypingWords().getRandomInteger(testdaten);

        assertThat(r <= testdaten.length -1, is(true));
    }

    /*@Ignore
    @Test
    public void disappearWordIfCollided() {
        Boolean col = new TypingWords().collidedWord();
        assertThat(col, is(true));

        // let the word disappear
    }*/

    @After
    public void cleanUp() { /* clean the pub values */ }
}

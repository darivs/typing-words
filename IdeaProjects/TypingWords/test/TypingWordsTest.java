import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

// Created by Darius on 06.06.2016.

public class TypingWordsTest {
    private static Path p;
    public static List<String> row;
    public static String[] testArray;
    private static String testdata;

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new DataManaging().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
        testArray = new String[] { };
        testdata = row.get(0);

    }

    @Test
    public void declareWordWhenItsValid() throws FileNotFoundException {
        splitRowAtSimicolon();

        assertThat(Arrays.asList(testArray), hasItem(new TypingWords().declareWord()));
    }

    @Test
    public void splitRowAtSimicolon() {
        //new DataManaging().declareList();
        testArray = new TypingWords().splitString(testdata, ";");

        assertThat(Arrays.asList(testArray), hasItems("Robb", "Sansa", "Bran"));
    }

    @Test
    public void getRandomValueBetweenArrayLength() {
        int r = new TypingWords().getRandomInteger(6);

        assertThat(r <= 5, is(true));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}
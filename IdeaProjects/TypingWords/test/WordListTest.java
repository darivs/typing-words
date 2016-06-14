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

public class WordListTest {
    private static Path p;
    public static List<String> row;
    public static String[] testArray;
    private static String testdata;

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new FileManager().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
        testArray = new String[] { };
        testdata = row.get(0);
    }

    @Test
    public void declareWordWhenItsValid() throws FileNotFoundException {
        splitRowAtSimicolon();

        assertThat(Arrays.asList(testArray), hasItem(new WordList().declareWord()));
    }

    @Test
    public void declareWordFilesWhenOnlyOneRow() throws FileNotFoundException {
        int f1 = new FileManager().countLinesInFile("test/twords.txt");
        int f2 = new FileManager().countLinesInFile("words.txt");

        assertThat(f1, is(equalTo(1)));
        assertThat(f2, is(equalTo(f1)));
    }

    @Test
    public void splitRowAtSimicolon() {
        testArray = new WordList().splitString(testdata, ";");

        assertThat(Arrays.asList(testArray), hasItems("Robb", "Sansa", "Bran"));
    }

    @Test
    public void getRandomValueBetweenArrayLength() {
        int r = new WordList().getRandomInteger(6);

        assertThat(r <= 5, is(true));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}
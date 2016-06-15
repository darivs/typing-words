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
    private WordList wl = new WordList();
    private FileManager fm = new FileManager();

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new FileManager().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
        testArray = new String[] { };
        testdata = row.get(0);
    }

    @Test
    public void sortListWhenFirstEntryGotFewestCapitals() throws FileNotFoundException {
        List<String> tList = wl.declareList();
        wl.sortList(tList);

        assertThat(tList.get(0), is("Jon"));
    }

    @Test
    public void declareWordWhenItsValid() throws FileNotFoundException {
        splitRowAtSimicolon();

        assertThat(Arrays.asList(testArray), hasItem(wl.declareWord()));
    }

    @Test
    public void mapListWhenNotNull() throws FileNotFoundException {
        wl.mapList(wl.sortList(wl.declareList()));

        assertThat(fm.getList(), is(not("")));
    }

    @Test
    public void splitRowAtSimicolon() {
        testArray = wl.splitString(testdata, ";");

        assertThat(Arrays.asList(testArray), hasItems("Robb", "Sansa", "Bran"));
    }

    @Test
    public void getRandomValueBetweenArrayLength() {
        int r = wl.getRandomInteger(6);

        assertThat(r <= 5, is(true));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}
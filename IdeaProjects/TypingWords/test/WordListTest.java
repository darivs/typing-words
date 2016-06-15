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
    private WordList wl = new WordList();
    private FileManager fm = new FileManager();

    @BeforeClass
    public static void initValues() { /* initialize pub values */ }

    @Test
    public void sortListWhenFirstEntryGotFewestCapitals() throws FileNotFoundException {
        List<String> tList = wl.declareList();
        wl.sortList(tList);

        assertThat(tList.get(0), is("Jon"));
    }

    @Test
    public void mapListWhenNotNull() throws FileNotFoundException {
        wl.mapList(wl.sortList(wl.declareList()));

        assertThat(fm.getList(), is(not("")));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}
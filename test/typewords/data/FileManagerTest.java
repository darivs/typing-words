package typewords.data;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

// Created by Darius on 06.06.2016.

public class FileManagerTest {
    private static Path p;
    public static List<String> row;
    private FileManager fm = new FileManager();

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new FileManager().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "typewords/data/twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
    }

    @Test
    public void declareWordFilesWhenOnlyOneRow() throws FileNotFoundException {
        int f1 = fm.countLinesInFile("test/twords.txt");
        int f2 = fm.countLinesInFile("words.txt");

        assertThat(f1, is(equalTo(1)));
        assertThat(f2, is(equalTo(f1)));

        List<String> tList = fm.getList();

        assertThat(tList, is(not("")));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}

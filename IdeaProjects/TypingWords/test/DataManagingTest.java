import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

// Created by Darius on 06.06.2016.

public class DataManagingTest {
    private static Path p;
    public static List<String> row;

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new DataManaging().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
    }

    @Test
    public void declareWordFilesWhenOnlyOneRow() throws FileNotFoundException {
        int f1 = new DataManaging().countLinesInFile("test/twords.txt");
        int f2 = new DataManaging().countLinesInFile("words.txt");

        assertThat(f1, is(equalTo(1)));
        assertThat(f2, is(equalTo(f1)));
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}

import org.junit.BeforeClass;
import org.junit.AfterClass;
import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Files;

// Created by Darius on 06.06.2016.

public class DataManagingTest {
    private static Path p;
    public static List<String> row;

    @BeforeClass
    public static void initValues() { /* initialize pub values */
        p = new FileManager().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        try { row = Files.readAllLines(p); } catch (IOException e) { e.printStackTrace(); }
    }

    @AfterClass
    public static void cleanUp() { /* clean the pub values */ }
}

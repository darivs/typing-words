import org.junit.Test;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

// Created by Darius on 06.06.2016.

public class TypingWordsTest {

    @Test
    public void splitRow() {
        String testdaten = "Arya;Robb;Jon";

        String[] words = new TypingWords().splitString(testdaten);

        assert words[0].equals("Arya") && words[1].equals("Robb") && words[2].equals("Jon");
    }

    @Test
    public void checkData() {
        Path p = Paths.get("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        List<String> row = new ArrayList<>();

        try {
            row = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(row.get(0));
    }

    /*@Test
    public void chooseMenu() {
        String c = Main.decide();
        assert c.equals("1") || c.equals("2") || c.equals("3");
    }

    @Test
    public void collision()
    {
        Boolean col = new TypingWords().collidedWord();
        assertEquals(true, col);
    }*/
}

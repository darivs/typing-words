import org.junit.Assert;
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

    @Test
    public void splitRowAtSimicolon() {
        String testdaten = "Arya;Robb;Jon";
        String[] words = new TypingWords().splitString(testdaten);

        //assertThat(words[0], is(equalTo("Arya")));
        //assertThat(words[1], is(equalTo("Robb")));
        //assertThat(words[2], is(equalTo("Jon")));

        assertThat(Arrays.asList(words), hasItems("Arya", "Robb", "Jon"));

    }

    @Test
    public void checkData() {
        Path p = new TypingWords().getPath("C:/Users/Darius/IdeaProjects/TypingWords/test/", "twords.txt");
        List<String> row = new ArrayList<>();
        String testdaten = "Robb;Sansa;Bran;Arya;Rickon;Jon";

        try {
            row = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(row.get(0), is(equalTo(testdaten)));
    }

    @Test
    public void declareWordlistWhenOnlyOneRow() throws FileNotFoundException {
        int c = new TypingWords().countLinesInFile("test/twords.txt");

        assertThat(c, is(1));
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

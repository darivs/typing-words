import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TypingWords {
    String[] words;


    public String[] splitString(String row) {
        String[] x = row.split(";");

        return x;
    }

    public Path getPath (String path, String name) throws InvalidPathException {
        Path p = Paths.get(path, name);

        return p;
    }


    public String declareWord() {
        String w = new String();

        try {
            Path p = getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "words.txt");
            List<String> l = Files.readAllLines(p);
            String row = "";

            if (countLinesInFile("words.txt") == 1) { row =  l.get(0); }

            if (row != null) {
                words = splitString(row);
            }

            int r = ThreadLocalRandom.current().nextInt(0, words.length - 1);
            w = words[r];
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return w;
    }

    public int countLinesInFile(String f) throws FileNotFoundException {
        int c;

        LineNumberReader lnr = new LineNumberReader(new FileReader(f));
        try { lnr.skip(Long.MAX_VALUE); } catch (IOException e) {e.printStackTrace();}
        c = lnr.getLineNumber() + 1;

        return c;
    }

    /*
    public Boolean collidedWord() {
        Boolean col = true;

        if (col) {
            col = true;
        }

        return col;
    }

    public String chosenMenu(String chosen) {
        String c = chosen;
        System.out.println(c);
        return c;
    }*/
}


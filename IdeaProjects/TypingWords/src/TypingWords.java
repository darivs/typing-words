import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TypingWords { String[] words;

    public String[] splitString(String row, String c) {
        String[] x = row.split("c");

        return x;
    }

    public Path getPath (String path, String name) throws InvalidPathException {
        Path p = Paths.get(path, name);

        return p;
    }

    public String declareWord() {
        String w = new String();

        try { String row = "";
            Path p = getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "words.txt");
            List<String> l = Files.readAllLines(p);

            if (countLinesInFile("words.txt") == 1) { row =  l.get(0); }
            if (row != null) { words = splitString(row, ";"); }

            w = words[getRandomInteger(words)];
        } catch (FileNotFoundException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace(); }

        return w;
    }

    public int countLinesInFile(String f) throws FileNotFoundException {
        int c;

        LineNumberReader lnr = new LineNumberReader(new FileReader(f));
        try { lnr.skip(Long.MAX_VALUE); } catch (IOException e) {e.printStackTrace();}
        c = lnr.getLineNumber() + 1;

        return c;
    }

    public int getRandomInteger(String[] w) {
        int r = ThreadLocalRandom.current().nextInt(0, w.length -1);

        return r;
    }

    public Boolean collidedWord() {
        Boolean col = true;

        return col;
    }
}


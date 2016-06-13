import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TypingWords implements Comparator<String> {

    protected List<String> words = new ArrayList<>();
    //public boolean did;       //value for sorting only once

    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }

    public String[] splitString(String row, String c) {
        String[] x = row.split(c);

        return x;
    }

    public Path getPath (String path, String name) throws InvalidPathException {
        Path p = Paths.get(path, name);

        return p;
    }

    public String declareWord() throws FileNotFoundException {
        declareList();
        String w = words.get(getRandomInteger(words.size()));

        return w;
    }

    public void declareList() {
        try {
            String row = "";
            Path p = getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "words.txt");
            List<String> l = Files.readAllLines(p);

            if (countLinesInFile("words.txt") == 1) { row =  l.get(0); }
            if (row != null) {
                String[] array = splitString(row, ";");

                for (int i = 0; i <= array.length - 1; i++) {
                    words.add(i, array[i]);
                }
            }
            sortList();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void sortList() {
        //System.out.println(words);                    // unsorted
        Collections.sort(words, new TypingWords());
        //System.out.println(words);                    // sorted
    }

    public int countLinesInFile(String f) throws FileNotFoundException {
        int c;

        LineNumberReader lnr = new LineNumberReader(new FileReader(f));
        try { lnr.skip(Long.MAX_VALUE); } catch (IOException e) {e.printStackTrace();}
        c = lnr.getLineNumber() + 1;

        return c;
    }

    public int getRandomInteger(int size) {
        int r = ThreadLocalRandom.current().nextInt(0, size - 1);

        return r;
    }

    /*public Boolean collidedWord() {
        Boolean col = true;

        return col;
    }*/
}


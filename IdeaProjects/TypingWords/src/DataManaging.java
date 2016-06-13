import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataManaging implements Comparator<String> {
    public List<String> words = new ArrayList<>();

    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }

    public List<String> declareList() {
        List<String> k = new ArrayList<>();
        try {
            String row = "";
            Path p = getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "words.txt");
            List<String> l = Files.readAllLines(p);

            if (countLinesInFile("words.txt") == 1) { row =  l.get(0); }
            if (row != null) {
                String[] array = new TypingWords().splitString(row, ";");

                for (int i = 0; i <= array.length - 1; i++) {
                    k.add(i, array[i]);
                }
            }
            sortList();
        } catch (IOException e) { e.printStackTrace(); }

        return k;
    }

    public void sortList() {
        System.out.println(words);                    // unsorted
        Collections.sort(words, new DataManaging());
        System.out.println(words);                    // sorted
    }

    public int countLinesInFile(String f) throws FileNotFoundException {
        int c;

        LineNumberReader lnr = new LineNumberReader(new FileReader(f));
        try { lnr.skip(Long.MAX_VALUE); } catch (IOException e) {e.printStackTrace();}
        c = lnr.getLineNumber() + 1;

        return c;
    }

    public Path getPath (String path, String name) throws InvalidPathException {
        Path p = Paths.get(path, name);

        return p;
    }
}

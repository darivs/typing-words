package typewords.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


    public List<String> getList() throws FileNotFoundException {
        List<String> l = new ArrayList<>();
        try {
            Path p = getPath("C:/Users/Darius/IdeaProjects/TypingWords/", "words.txt");
            l = Files.readAllLines(p);
        } catch (IOException e) { e.printStackTrace(); }

        return l;
    }

    public int countLinesInFile(String f) throws FileNotFoundException {
        int c;

        LineNumberReader lnr = new LineNumberReader(new java.io.FileReader(f));
        try { lnr.skip(Long.MAX_VALUE); } catch (IOException e) {e.printStackTrace();}
        c = lnr.getLineNumber() + 1;

        return c;
    }

    public Path getPath (String path, String name) throws InvalidPathException {
        Path p = Paths.get(path, name);

        return p;
    }
}

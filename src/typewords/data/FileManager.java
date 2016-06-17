package typewords.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    public List<String> getList() throws DataException {
        URL resource = getClass().getClassLoader().getResource("typewords/words.txt");
        try {
            return Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new DataException(e);
        }
    }
}

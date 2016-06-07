import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Darius on 06.06.2016.
 */

public class TypingWordsTest {

    @Test
    public void spawn(){
        String spwn = new TypingWords().spawnWord();
        assertEquals("spawned", spwn);
    }

    @Test
    public void collision(){
        Boolean col = new TypingWords().collidedWord();
        assertEquals(true, col);
    }
}

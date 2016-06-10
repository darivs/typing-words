import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MenueTest {

    @Test
    public void doSthWhenValueIsValid () {
        String c = new Menue().whatToDo("3");

        System.out.println(c);

        assertThat(c, anyOf(is(equalTo("1")), is(equalTo("2")), is(equalTo("3"))));
    }
}

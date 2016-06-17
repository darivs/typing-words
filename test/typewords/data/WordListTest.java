package typewords.data;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

// Created by Darius on 06.06.2016.

public class WordListTest {

    private WordList wl;
    private List<String> testList;

    @Before
    public void setup() {
        wl = new WordList(new FileManagerMock());
    }

    @Test
    public void sortListWhenFirstEntryGotFewestCapitals() throws Exception {
        testList = Arrays.asList("Johnny;Jon;John");

        List<String> tList = wl.declareList();

        assertThat(tList.get(0), is("Jon"));
    }

    @Test
    public void mapListWhenNotNull() throws Exception {
        testList = Arrays.asList("Johnny;Jon;John");

        wl.mapList(wl.declareList());

        assertThat(new FileManagerMock().getList(), is(not("")));
    }

    class FileManagerMock extends FileManager {
        public List<String> getList() {
            return testList;
        }
    }
}
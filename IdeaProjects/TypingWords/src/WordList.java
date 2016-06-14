import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WordList {
    private List<String> words = new ArrayList<>();
    private FileManager fM = new FileManager();

    public List<String> declareList() throws FileNotFoundException {
        List<String> k = new ArrayList<>();
        String row = fM.getList().get(0);

        //if (dM.countLinesInFile("words.txt") == 1)
        if (row != null) {
            String[] array = splitString(row, ";");

            for (int i = 0; i <= array.length - 1; i++) {
                k.add(i, array[i]);
            }
        }

        sortList(k);
        return k;
    }

    public List<String> sortList(List<String> n) {

        //System.out.println(n);                    // unsorted
        Collections.sort(n, fM);
        System.out.println(n);                    // sorted

        mapList(n);
        return n;
    }

    public HashMap mapList(List<String> o) {
        HashMap<Integer, List<String>> m = new HashMap<>();
        ListIterator lt = o.listIterator();

        List<String> lng = new ArrayList<>();

        for (int i = o.get(0).length(); i <= o.get(o.size() - 1).length(); i++) { // i = 3; i <= 10
            lng.clear();
            for (int j = 0; j <= o.size()- 1; j++) {
                if (lt.hasNext()) {
                    //if (lt.next().toString().length() == i) {
                    if (o.get(j).length() == i) {
                        lng.add(o.get(j));
                    } else if (o.get(j).length() >= i) {
                        break;
                    }
                    //}
                }
            }

            System.out.println(lng);
            List<String> w = lng;

            m.put(i, w);

            System.out.println(m);
            System.out.println(i);
        }
        return m;
    }

    public String declareWord() throws FileNotFoundException {
        words = declareList();
        String w = words.get(getRandomInteger(words.size()));

        return w;
    }

    public int getRandomInteger(int size) {
        int r = ThreadLocalRandom.current().nextInt(0, size - 1);

        return r;
    }

    public String[] splitString(String row, String c) {
        String[] x = row.split(c);

        return x;
    }
}


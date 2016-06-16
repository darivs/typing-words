package typewords.data;

import java.io.*;
import java.util.Comparator;
import java.util.*;
import java.util.List;

public class WordList implements Comparator<String> {

    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }

    public List<String> declareList() throws FileNotFoundException {
        List<String> k = new ArrayList<>();
        String row = new FileManager().getList().get(0);

        if (row != null) {
            String[] array = splitString(row, ";");

            for (int i = 0; i <= array.length - 1; i++) {
                k.add(i, array[i]);
            }
        }

        return k;
    }

    public List<String> sortList(List<String> n) {
        //System.out.println(n);                    // unsorted
        Collections.sort(n, new WordList());
        //System.out.println(n);                    // sorted

        return n;
    }

    public HashMap mapList(List<String> o) {
        HashMap<Integer, List<String>> m = new HashMap<>();
        ListIterator lt = o.listIterator();

        List<String> values = new ArrayList<>();

        for (int i = o.get(0).length(); i <= o.get(o.size() - 1).length(); i++) { // i = 3; i <= 10
            values.clear();
            for (int j = 0; j <= o.size()- 1; j++) {
                if (lt.hasNext()) {
                    if (o.get(j).length() == i) {
                        values.add(o.get(j));
                    } else if (o.get(j).length() >= i) break;
                }
            }
            List<String> copy = new ArrayList<>();

            copy.addAll(values);
            m.put(i, copy);
        }

        System.out.println(m);
        return m;
    }

    public String[] splitString(String row, String c) {
        String[] x = row.split(c);

        return x;
    }
}


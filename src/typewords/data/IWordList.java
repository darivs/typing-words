package typewords.data;// Created by Darius on 16.06.2016.

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public interface IWordList {
    String[] splitString(String row, String c);
    List<String> declareList() throws FileNotFoundException;
    List<String> sortList(List<String> n);
    HashMap mapList(List<String> o);
}

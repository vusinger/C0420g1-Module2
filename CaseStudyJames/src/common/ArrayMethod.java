package common;

import models.Word;

import java.util.ArrayList;
import java.util.List;

public class ArrayMethod {

    static FileSolution<Word> file = new FileSolution<>();

    public static List<Word> getArray() {
        return file.getArray();
    }

    public static void setArray(List<Word> array) {
        file.setArray(array);
    }
}

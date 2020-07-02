package controller;

import common.ArrayMethod;
import models.Word;

import java.util.List;

public class Drop {
    public static void dropMethod(String keyword) {
        int index = 0;
        List<Word> wordBank = ArrayMethod.getArray();
        if (!wordBank.isEmpty()) {
            for (Word word : wordBank) {
                if (word.getWord().equals(keyword)) {
                    wordBank.remove(index);
                    break;
                }
                index++;
            }
        }
        ArrayMethod.setArray(wordBank);
    }
}

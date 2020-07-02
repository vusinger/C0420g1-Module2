package controller;

import common.ArrayMethod;
import models.Word;

import java.util.List;

public class Lookup {
    public static void lookupMethod(String keyword) {
        int index = 0;
        boolean check = false;
        List<Word> wordBank = ArrayMethod.getArray();
        if (!wordBank.isEmpty()) {
            for (Word word : wordBank) {
                if (word.getWord().equals(keyword)) {
                    word.showWord();
                    break;
                }
                index++;
            }
        } else {
            System.out.println("Word Bank Empty!!!!Need add word!!");
        }
    }
}

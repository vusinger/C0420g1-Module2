package controller;

import common.ArrayMethod;
import common.GenericMethod;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Define {
    public static void defineMethod(String kindOfWord, String keyword) {
        int index = 0;
        boolean check = false;
        List<Word> wordBank = ArrayMethod.getArray();
        if (!wordBank.isEmpty()) {
            for (Word word : wordBank) {
                if (word.getWord().equals(keyword)) {
                    wordBank.set(index, processDefine(word, kindOfWord));
                    check = true;
                    break;
                }
                index++;
            }
        }
        if (!check) {
            Word word = new Word(keyword);
            wordBank.add(processDefine(word, kindOfWord));
        }
        ArrayMethod.setArray(wordBank);
    }

    private static Word processDefine(Word word, String kindOfWord) {
        if ("--pronoun".equals(kindOfWord) || "-p".equals(kindOfWord)) {
            Pronoun p;
            if (word.getPronoun() == null) {
                p = new Pronoun();
            } else p = word.getPronoun();
            System.out.println("Input pronoun:");
            p.setValue(GenericMethod.inputString());
            word.setPronoun(p);
        } else if ("--noun".equals(kindOfWord) || "-n".equals(kindOfWord)) {
            Noun n;
            if (word.getNoun() == null) {
                n = new Noun();
            } else n = word.getNoun();
            n.setSentence(readSentence(n.getSentence()));
            word.setNoun(n);
        } else if ("--adjective".equals(kindOfWord) || "-a".equals(kindOfWord)) {
            Adjective a;
            if (word.getAdjective() == null) {
                a = new Adjective();
            } else a = word.getAdjective();
            a.setSentence(readSentence(a.getSentence()));
            word.setAdjective(a);
        } else if ("--verb".equals(kindOfWord) || "-v".equals(kindOfWord)) {
            Verb v;
            if (word.getVerb() == null) {
                v = new Verb();
            } else v = word.getVerb();
            v.setSentence(readSentence(v.getSentence()));
            word.setVerb(v);
        } else if ("--synonymous".equals(kindOfWord) || "-s".equals(kindOfWord)) {
            Synonymous s;
            if (word.getSynonymous() == null) {
                s = new Synonymous();
            } else s = word.getSynonymous();
            s.setWord(readWord(s.getWord()));
            word.setSynonymous(s);
        }
        return word;
    }

    private static List<Sentence> readSentence(List<Sentence> sentence) {
        Sentence sentences = new Sentence();
        while (true) {
            sentences = new Sentence();
            System.out.println("Input meaning:");
            sentences.setMeaning(GenericMethod.inputString());
            System.out.println("Input sentence:");
            sentences.setSentence(GenericMethod.inputString());
            System.out.println("Input sentence meaning:");
            sentences.setSentenceMeaning(GenericMethod.inputString());
            sentence.add(sentences);
            if (!GenericMethod.checkContinue()) break;
        }
        return sentence;
    }

    private static List<String> readWord(List<String> mean) {
        while (true) {
            System.out.println("Input meaning:");
            mean.add(GenericMethod.inputString());
            if (!GenericMethod.checkContinue()) break;
        }
        return mean;
    }
}

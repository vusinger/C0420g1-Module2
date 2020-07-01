package models;

import java.util.ArrayList;
import java.util.List;

public class Noun {
    final String nounVN = "Danh từ";
    private List<String> meaning;
    private List<Sentence> sentence;

    public String getNounVN() {
        return nounVN;
    }

    public List<String> getMeaning() {
        return meaning;
    }

    public void setMeaning(List<String> meaning) {
        this.meaning = meaning;
    }

    public List<Sentence> getSentence() {
        return sentence;
    }

    public void setSentence(List<Sentence> sentence) {
        this.sentence = sentence;
    }
}

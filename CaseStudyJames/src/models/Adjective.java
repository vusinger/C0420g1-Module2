package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adjective implements Serializable {

    private static final long serialVersionUID = 1L;
    final String adjectiveVN = "Tính từ";
    private List<Sentence> sentence = new ArrayList<>();

    public String getAdjectiveVN() {
        return adjectiveVN;
    }

    public List<Sentence> getSentence() {
        return sentence;
    }

    public void setSentence(List<Sentence> sentence) {
        this.sentence = sentence;
    }
}

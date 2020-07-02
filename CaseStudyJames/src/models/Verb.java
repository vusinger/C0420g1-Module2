package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Verb implements Serializable {

    private static final long serialVersionUID = 1L;
    final String verbVN = "Động từ";
    private List<Sentence> sentence = new ArrayList<>();

    public String getVerbVN() {
        return verbVN;
    }

    public List<Sentence> getSentence() {
        return sentence;
    }

    public void setSentence(List<Sentence> sentence) {
        this.sentence = sentence;
    }
}

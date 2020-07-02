package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Noun implements Serializable {

    private static final long serialVersionUID = 1L;
    final String nounVN = "Danh từ";
    private List<Sentence> sentence = new ArrayList<>();

    public String getNounVN() {
        return nounVN;
    }

    public List<Sentence> getSentence() {
        return sentence;
    }

    public void setSentence(List<Sentence> sentence) {
        this.sentence = sentence;
    }
}

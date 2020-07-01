package models;

import java.util.ArrayList;
import java.util.List;

public class Synonymous {
    final String synonymousVN = "Tương đồng";
    private List<String> word = new ArrayList<>();

    public String getSynonymousVN() {
        return synonymousVN;
    }

    public List<String> getWord() {
        return word;
    }

    public void setWord(List<String> word) {
        this.word = word;
    }
}

package models;

import java.io.Serializable;

public class Sentence implements Serializable {

    private static final long serialVersionUID = 1L;
    private String meaning;
    private String sentence;
    private String sentenceMeaning;

    public Sentence() {
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentenceMeaning() {
        return sentenceMeaning;
    }

    public void setSentenceMeaning(String sentenceMeaning) {
        this.sentenceMeaning = sentenceMeaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}

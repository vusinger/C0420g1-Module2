package models;

public class Sentence {
    private String sentence;
    private String sentenceMeaning;

    public Sentence(String sentence, String sentenceMeaning) {
        this.sentence = sentence;
        this.sentenceMeaning = sentenceMeaning;
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
}

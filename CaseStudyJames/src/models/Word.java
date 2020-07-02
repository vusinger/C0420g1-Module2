package models;

import java.io.Serializable;

public class Word implements Serializable {

    private static final long serialVersionUID = 1L;
    private String word;
    private Pronoun pronoun;
    private Noun noun;
    private Verb verb;
    private Adjective adjective;
    private Synonymous synonymous;

    public Word(String word) {
        this.word = word;
    }

    public Word(Pronoun pronoun, Noun noun, Verb verb, Adjective adjective, Synonymous synonymous) {
        this.pronoun = pronoun;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.synonymous = synonymous;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public void setPronoun(Pronoun pronoun) {
        this.pronoun = pronoun;
    }

    public Noun getNoun() {
        return noun;
    }

    public void setNoun(Noun noun) {
        this.noun = noun;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public Adjective getAdjective() {
        return adjective;
    }

    public void setAdjective(Adjective adjective) {
        this.adjective = adjective;
    }

    public Synonymous getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(Synonymous synonymous) {
        this.synonymous = synonymous;
    }

    public void showWord() {
        System.out.print("@" + word);
        if (this.pronoun != null) System.out.print(" " + this.pronoun.getValue());
        System.out.println();

        if (adjective != null) {
            System.out.println("*" + adjective.getAdjectiveVN());
            for (String obj : adjective.getMeaning()) {
                System.out.println("-" + obj);
            }
            for (Sentence obj : adjective.getSentence()) {
                System.out.println("=" + obj.getSentence() + "+" + obj.getSentenceMeaning());
            }
        }
        if (noun != null) {
            System.out.println("*" + noun.getNounVN());
            for (String obj : noun.getMeaning()) {
                System.out.println("-" + obj);
            }
            for (Sentence obj : noun.getSentence()) {
                System.out.println("=" + obj.getSentence() + "+" + obj.getSentenceMeaning());
            }
        }
        if (verb != null) {
            System.out.println("*" + verb.getVerbVN());
            for (String obj : verb.getMeaning()) {
                System.out.println("-" + obj);
            }
            for (Sentence obj : verb.getSentence()) {
                System.out.println("=" + obj.getSentence() + "+" + obj.getSentenceMeaning());
            }
        }
        if (synonymous != null) {
            System.out.println("*" + synonymous.getSynonymousVN());
            for (String obj : synonymous.getWord()) {
                System.out.println("-" + obj);
            }
        }
    }
}

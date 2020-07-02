package models;

import java.io.Serializable;
import java.util.List;

public class Word implements Serializable {

    private static final long serialVersionUID = 1L;
    private String word;
    private Pronoun pronoun = new Pronoun();
    private Noun noun = new Noun();
    private Verb verb = new Verb();
    private Adjective adjective = new Adjective();
    private Synonymous synonymous = new Synonymous();

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

//  -----------------------------------------------------------------------------------------
    public void showWord() {
        System.out.print("@" + word);
        if (this.pronoun.getValue() != null) System.out.print(" " + this.pronoun.getValue());
        System.out.println();

        if (adjective != null) {
            System.out.println("---------*" + adjective.getAdjectiveVN()+"---------");
            showSentence(adjective.getSentence());
        }
        if (noun != null) {
            System.out.println("---------*" + noun.getNounVN()+"---------");
            showSentence(noun.getSentence());
        }
        if (verb != null) {
            System.out.println("---------*" + verb.getVerbVN()+"---------");
            showSentence(verb.getSentence());
        }
        if (synonymous != null) {
            System.out.println("---------*" + synonymous.getSynonymousVN()+"---------");
            for (String obj : synonymous.getWord()) {
                System.out.println("-" + obj);
            }
        }
    }

    private void showSentence(List<Sentence> sentence) {
        for (Sentence obj : sentence) {
            if (obj.getMeaning() != null&&!"".equals(obj.getMeaning().trim())) System.out.println("-" + obj.getMeaning());
            if (obj.getSentence() != null&&!"".equals(obj.getSentence().trim())) System.out.print("=" + obj.getSentence());
            if (obj.getSentenceMeaning() != null&&!"".equals(obj.getSentenceMeaning().trim())) System.out.println("+" + obj.getSentenceMeaning());
        }
    }

//    -----------------------------------------------------------------
}

package models;

public class Word {

    private Pronoun pronoun;
    private Noun noun;
    private Verb verb;
    private Adjective adjective;
    private Synonymous synonymous;

    public Word(Pronoun pronoun, Noun noun, Verb verb, Adjective adjective, Synonymous synonymous) {
        this.pronoun = pronoun;
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.synonymous = synonymous;
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
}

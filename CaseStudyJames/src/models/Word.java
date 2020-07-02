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
    public String showWord() {
        String result = "";
        String str = "";

        result = "@" + word;
        if (this.pronoun.getValue() != null) {
            result += " " + this.pronoun.getValue();
        }
        result += "\n";

        if ((str = showSentence(adjective.getSentence())) != null) {
            str = "---------*" + adjective.getAdjectiveVN() + "---------\n" + str;
            result += str;
        }

        if ((str = showSentence(noun.getSentence())) != null) {
            str = "---------*" + noun.getNounVN() + "---------\n" + str;
            result += str;
        }
        if ((str = showSentence(verb.getSentence())) != null) {
            str = "---------*" + verb.getVerbVN() + "---------\n" + str;
            result += str;
        }
        str = "";
        for (String obj : synonymous.getWord()) {
            str += "-" + obj + "\n";
        }
        if (!"".equals(str)) {
            str = "---------*" + synonymous.getSynonymousVN() + "--------- \n" + str;
            result += str;
        }
        return result;
    }

    private String showSentence(List<Sentence> sentence) {
        String str = "";
        for (Sentence obj : sentence) {
            if (obj.getMeaning() != null && !"".equals(obj.getMeaning().trim())) {
                str += "\n-" + obj.getMeaning() + "\n";
            }
            if (obj.getSentence() != null && !"".equals(obj.getSentence().trim())) {
                str += "=" + obj.getSentence();
            }
            if (obj.getSentenceMeaning() != null && !"".equals(obj.getSentenceMeaning().trim())) {
                str += "+" + obj.getSentenceMeaning() + "\n";
            }
        }
        if ("".equals(str)) {
            return null;
        } else return str;
    }

//    -----------------------------------------------------------------
}

package models;

import java.io.Serializable;

public class Pronoun implements Serializable {

    private static final long serialVersionUID = 1L;
    final String pronounVn = "Phát Âm";
    private String value;

    public String getPronounVn() {
        return pronounVn;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package models;

public class Request {
    private String action;
    private String kindOfWord;
    private String keyword;
    private String[] params = new String[3];

    public Request(String action, String keyword) {
        this.action = action;
        this.keyword = keyword;
    }

    public Request(String action, String kindOfWord, String keyword) {
        this.action = action;
        this.kindOfWord = kindOfWord;
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getKindOfWord() {
        return kindOfWord;
    }

    public void setKindOfWord(String kindOfWord) {
        this.kindOfWord = kindOfWord;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

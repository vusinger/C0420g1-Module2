package models;

public class Request {
    private String action;
    private String[] params = new String[3];
    private String keyword;

    public Request() {
    }

    public Request(String action, String keyword) {
        this.action = action;
        this.keyword = keyword;
    }

    public Request(String action, String[] params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

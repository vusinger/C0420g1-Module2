package common;

import models.Request;

public class GenericMethod {

    /*Get Request*/
    public static Request defineRequest(String input) {
        input = input.trim();
        input = input.replaceAll("\\s*","\\s");
        String[] array = input.split(" ");
        return new Request(array[1],array[2]);
    }
}

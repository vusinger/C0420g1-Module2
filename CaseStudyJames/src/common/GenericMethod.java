package common;

import models.Request;

public class GenericMethod {

    /*Get Request*/
    public static Request defineRequest(String input) {
        input = input.trim();
        input = input.replaceAll("\\s+", " ");
        String[] command = input.split(" ");
        if ("define".equals(command[1])) {
            return new Request(command[1], command[2] ,command[3]);
        } else {
            return new Request(command[1], command[2]);
        }
    }
}

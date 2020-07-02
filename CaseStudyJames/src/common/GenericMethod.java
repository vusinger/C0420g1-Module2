package common;

import models.Request;

import java.util.Scanner;

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

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static boolean checkContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue?(True/False)");
        return sc.nextBoolean();
    }
}

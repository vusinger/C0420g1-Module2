package common;

import models.Request;

import java.util.Scanner;
import java.util.regex.Pattern;

public class GenericMethod {

    /*Get Request*/
    public static Request defineRequest(String input) throws Exception {
        input = input.toLowerCase().trim();
        input = input.replaceAll("\\s+", " ");
        String[] command = input.split(" ");
        if (!"action".equals(command[0])) return null;
        if ("define".equals(command[1])) {
            return new Request(command[1], command[2] ,command[3]);
        } else if (Pattern.matches("lookup|drop|export",command[1])) {
            return new Request(command[1], command[2]);
        } else return null;
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static boolean checkContinue() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        System.out.println("Do you want to continue?(yes/no)");
        String input;
        while(true) {
            input = sc.nextLine();
            input = input.toLowerCase().trim();
            if ("no".equals(input)) {
                return false;
            }
            else if ("yes".equals(input)) {
                return true;
            } else System.out.println("Please input right format!!!!!");
        }
    }
}

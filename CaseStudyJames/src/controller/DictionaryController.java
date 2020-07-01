package controller;

import common.GenericMethod;
import models.Request;

import java.util.Scanner;

public class DictionaryController {
    
    public static void main(String[] args) {
        main();
    }

    private static void main() {
        System.out.println("-------------- Dictionary ---------------");
        System.out.println("Action: lookup/define/drop ....");
        System.out.println("Input your command:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if ("exit".equals(input.toLowerCase().trim())) {
            return;
        } else {
            Request request = GenericMethod.defineRequest(input);
            process(request);
        }
        main();
    }

    private static void process(Request request) {
        String action = request.getAction();
        String keyword = request.getKeyword();
        if ("lookup".equals(action)) Lookup.lookupMethod(keyword);
        else if ("define".equals(action)) Define.defineMethod(keyword);
        else if ("drop".equals(action)) Drop.dropMethod(keyword);
    }
}

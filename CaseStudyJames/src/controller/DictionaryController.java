package controller;

import common.ExportFile;
import common.GenericMethod;
import models.Request;

public class DictionaryController {

    public static void main(String[] args) {
        main();
    }

    private static void main() {
        System.out.println("-------------- Dictionary ---------------");
        System.out.println("Action: lookup/define/drop/export ....");
        System.out.println("Input your command:");
        String input = GenericMethod.inputString();
        Request request = null;
        while (!"exit".equals(input)) {
            try {
                request = GenericMethod.defineRequest(input);
                break;
            } catch (Exception e) {
                System.out.println("Please input right format!!!!");
                input = GenericMethod.inputString();
            }
        }
        if (!"exit".equals(input)) {
            process(request);
        } else return;
        main();
    }

    private static void process(Request request) {
        String action = request.getAction();
        String keyword = request.getKeyword();
        if ("lookup".equals(action)) {
            Lookup.lookupMethod(keyword);
        } else if ("define".equals(action)) {
            String kindOfWord = request.getKindOfWord();
            Define.defineMethod(kindOfWord, keyword);
        } else if ("drop".equals(action)) {
            Drop.dropMethod(keyword);
        } else if ("export".equals(action))  {
            ExportFile.export(keyword);
        }
    }
}

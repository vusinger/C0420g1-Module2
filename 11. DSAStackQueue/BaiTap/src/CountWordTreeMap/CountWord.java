package CountWordTreeMap;

import java.util.Scanner;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        System.out.print("Input your Text:");
        Scanner scn = new Scanner(System.in);
        String inputText = scn.nextLine();
        String[] stringArray = inputText.split("[ \n\t\r,.?:(){}]");
        TreeMap<String,Integer> map = new TreeMap<>();
//        -----------------------------------------
        for (int i = 0; i < stringArray.length; i++) {
            String key = stringArray[i].toLowerCase();
            if (key.length()>1) {
                if (map.get(key)==null) {
                    map.put(key,1);
                } else {
                    int value = map.get(key).intValue();
                    value++;
                    map.put(key,value);
                }
            }
        }
//        -------------------------------------------------
        System.out.println(map);
    }
}

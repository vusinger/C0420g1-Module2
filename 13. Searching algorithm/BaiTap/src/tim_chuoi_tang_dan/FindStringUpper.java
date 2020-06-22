package tim_chuoi_tang_dan;

import java.util.Scanner;

public class FindStringUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi:");
        String str = sc.nextLine();
        System.out.println("Max String:"+findMaxString(str));
    }

    private static String findMaxString(String str) {
        String temp = "";
        String max = "";
        int index = 0;
        while (index<str.length()) {
            temp="";
            temp += str.charAt(index);
            for (int i = index+1; i < str.length(); i++) {
                if (str.charAt(i)>temp.charAt(temp.length()-1)) {
                    temp += str.charAt(i);
                }
            }
            if (max.length()<temp.length()) {
                max = temp;
            }
            if (max.length()>=str.length()-index) {
                break;
            }
            index++;
        }
        return max;
    }
}
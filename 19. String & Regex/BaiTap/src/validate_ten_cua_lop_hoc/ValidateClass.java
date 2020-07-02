package validate_ten_cua_lop_hoc;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateClass {
    public static void main(String[] args) {
        System.out.println("Input name of class:");
        Scanner scn = new Scanner(System.in);
        String inputString = scn.nextLine();
        if (Pattern.matches("[ACP]\\d{4}[GHIKLM]",inputString)) {
            System.out.println("Ten Hop Le!!!!");
        } else System.out.println("Ten khong hop le!!!!!");
    }
}

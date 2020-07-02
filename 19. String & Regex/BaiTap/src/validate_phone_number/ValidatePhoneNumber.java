package validate_phone_number;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        System.out.println("Input phone number:");
        Scanner scn = new Scanner(System.in);
        String inputString = scn.nextLine();
        if (Pattern.matches("\\(\\d{2}\\)-\\(0\\d{9}\\)",inputString)) {
            System.out.println("Ten Hop Le!!!!");
        } else System.out.println("Ten khong hop le!!!!!");
    }
}

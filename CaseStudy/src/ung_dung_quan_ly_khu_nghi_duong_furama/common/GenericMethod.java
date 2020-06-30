package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import java.util.Scanner;

public class GenericMethod {
    /**
     * Phuong phap chung
     * @return
     */
    public static String inputString() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public static int inputNumber() {
        Scanner scn = new Scanner(System.in);
        String inputString;
        int number;
        while (true) {
            inputString = scn.nextLine();
            try {
                number = Integer.parseInt(inputString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang!!!!");
            }
        }
        return number;
    }

    public static double inputNumberDouble() {
        Scanner scn = new Scanner(System.in);
        String inputString;
        double number;
        while (true) {
            inputString = scn.nextLine();
            try {
                number = Double.parseDouble(inputString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang!!!!");
            }
        }
        return number;
    }
}

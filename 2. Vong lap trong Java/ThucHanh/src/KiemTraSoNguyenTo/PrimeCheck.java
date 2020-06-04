package KiemTraSoNguyenTo;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number:");
        int number = sc.nextInt();
        boolean check = true;
        if (number<2) {
            System.out.println("Không phải số nguyên tố!!");
        } else {
            for (int i=2;i<=Math.sqrt(number);i++) {
                if (number%i==0) {
                    System.out.println("Đây không phải số nguyên tố!!!");
                    check = false;
                    break;
                }
            }
            if (check) { System.out.println("Đây là số nguyên tố");}
        }
    }
}

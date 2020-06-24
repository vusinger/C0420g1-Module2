package su_dung_lop_number_format_exception;

import java.util.Scanner;

public class TestNumberFormatException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        String input;
        int x=0,y=0;
        try {
            input = scanner.nextLine();
            x = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Nhap integer");
        }
        System.out.println("Hãy nhập y: ");
        try {
            input = scanner.nextLine();
            y = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Nhap integer");
        }
        TestNumberFormatException calc = new TestNumberFormatException();
        calc.calculate(x, y);
    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e) {
            System.err.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}

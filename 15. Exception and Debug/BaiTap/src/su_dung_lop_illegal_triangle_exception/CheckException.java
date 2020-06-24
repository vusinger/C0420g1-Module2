package su_dung_lop_illegal_triangle_exception;

import java.util.Scanner;

public class CheckException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a1, a2, a3;
        while (true) {
            System.out.println("Nhap 3 canh tam giac:");
            a1 = sc.nextLine();
            a2 = sc.nextLine();
            a3 = sc.nextLine();
            try {
                int side1 = Integer.parseInt(a1);
                int side2 = Integer.parseInt(a2);
                int side3 = Integer.parseInt(a3);
                if (checkTriangle(side1, side2, side3)) {
                    break;
                } else {
                    System.out.println("3 canh nay khong phai la 3 canh tam giac");
                }
            } catch (NumberFormatException e) {

                System.out.println("Yeu cau nhap so Integer");

            } catch (IllegalTriangleException e) {

                System.out.println(e.getMessage());
                
            }
        }
        System.out.println("Chuc mung ban da nhap duoc mot tam giac");
    }

    private static boolean checkTriangle(int side1, int side2, int side3) throws IllegalTriangleException {
        if (side1 >= side2 + side3)
            throw new IllegalTriangleException(side1);
        else if (side2 >= side1 + side3)
            throw new IllegalTriangleException(side2);
        else if (side3 >= side2 + side1)
            throw new IllegalTriangleException(side3);
        return true;
    }

//    private static boolean checkTriangle(int side1, int side2, int side3) {
//        if (side1 >= side2 + side3) {
//            return false;
//        } else if (side2 >= side1 + side3) {
//            return false;
//        } else if (side3 >= side2 + side1) {
//            return false;
//        }
//        return true;
//    }
}

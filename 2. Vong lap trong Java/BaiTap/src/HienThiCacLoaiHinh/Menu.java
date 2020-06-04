package HienThiCacLoaiHinh;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhap chieu dai:");
                    int dai = input.nextInt();
                    System.out.println("Nhap chieu rong:");
                    int rong = input.nextInt();
                    System.out.println("Print the rectangle:");
                    for (int i=0;i<rong;i++) {
                        for (int j=0;j<dai;j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Nhap canh tam giac:");
                    int canh1 = input.nextInt();
                    System.out.println("Print the square triangle");
                    for (int i=0;i<canh1;i++) {
                        for (int j=i;j<canh1;j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Nhap canh tam giac:");
                    int canh2 = input.nextInt();
                    System.out.println("Print isosceles triangle");
                    for (int i=0;i<canh2;i++) {
                        for (int j=0;j<canh2-i;j++) {
                            System.out.print(" ");
                        }
                        for (int j=canh2-i;j<canh2;j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}

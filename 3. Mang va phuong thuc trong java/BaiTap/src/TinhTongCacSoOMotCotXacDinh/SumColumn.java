package TinhTongCacSoOMotCotXacDinh;

import java.util.Arrays;
import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap row:");
        int row = sc.nextInt();
        System.out.print("Nhap col:");
        int col = sc.nextInt();
        int[][] array = new int[row][col];
//        -----------------------------
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                float random = (float) (Math.random()*100);
                array[i][j] = Math.round(random);
            }
        }
        System.out.println(Arrays.deepToString(array));
//        -----------------------------
        while(true) {
            System.out.print("Ban muon tinh tong cot nao:");
            int choice = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += array[i][choice];
            }
            System.out.println("Tong Cot "+choice+":"+sum);
            System.out.print("Continue? (True/False): ");
            Boolean choice1 = sc.nextBoolean();
            if (choice1==false) {
                break;
            }
            System.out.println(Arrays.deepToString(array));
        }
//        -------------------------
    }
}

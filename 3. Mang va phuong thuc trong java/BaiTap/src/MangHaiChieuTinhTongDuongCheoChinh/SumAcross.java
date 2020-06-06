package MangHaiChieuTinhTongDuongCheoChinh;

import java.util.Scanner;

public class SumAcross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap size:");
        int size = sc.nextInt();
        int[][] array = new int[size][size];
//        -----------------------
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Nhap phan tu ["+i+","+j+"]:");
                array[i][j] = sc.nextInt();
            }
        }
//      --------------------------------
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
//        ----------------------------

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i][i];
        }
        System.out.println("Tong Duong Cheo:"+sum);
    }
}
package TimGiaTriNhoNhatTrongMang;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
//        --------------------------
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap size mang:");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Nhap gia tri cua mang!!");
        for (int i = 0; i < size ; i++) {
            System.out.print("Phan tu thu "+i+":");
            array[i] = sc.nextInt();
        }
//        -----------------------
        if (size>0) {
            int min = array[0];
            for (int index: array) {
                if (index<min) {
                    min = index;
                }
            }
            System.out.println("Gia tri nho nhat trong mang:"+min);
        }
//        -------------------------
    }
}

package radix_sort;

import java.util.Arrays;
import java.util.Scanner;

public class newRadixSort {
    public static void main(String[] args) {
        System.out.println("Nhap size array:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*1000)+1;
        }
        if (size>0) {
            radixSort(arr,size);
        }
//        print(size, arr);
    }

    private static void print(int size, int[] arr) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    //-----------------------Ham Sort-----------------------------
    private static void radixSort(int[] arr, int size) {
//        -----Tim MAX-------
        int max = arr[0];
        for (int i = 0; i < size ; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
//        -----------------------------
        for (int exp = 1; max/exp >0 ; exp*=10) {
            sortElement(arr,size,exp);
        }
    }

    private static void sortElement(int[] arr, int size, int exp) {
        int[] count = new int[10];
        Arrays.fill(count,0);
        int[] output = new int[size];
        for (int i = 0; i < size; i++) {
            count[(arr[i]/exp)%10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }
//        -------------------------------
        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
            System.out.print(output[i]+" ");
        }
        System.out.println();
    }
//    ----------------Ham sort end-----------------
}

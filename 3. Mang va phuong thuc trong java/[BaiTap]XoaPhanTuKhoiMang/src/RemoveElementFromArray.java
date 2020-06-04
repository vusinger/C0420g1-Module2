import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phan tu mang:");
        int n = sc.nextInt();
        int[] array;
        array = new int[100];
        for (int i=0;i<n;i++) {
            System.out.print("Nhap phan tu thu "+i+":");
            array[i] = sc.nextInt();
        }
        System.out.print("Mang truoc khi xoa:");
        for (int i=0;i<n;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.print("Nhap phan tu mang can xoa:");
        int x = sc.nextInt();
        for (int i = 0; i<n; i++) {
           if (array[i]==x) {
               array[i] = 0;
               for(int j=i;j<n;j++) {
                   array[j] = array[j+1];
               }
               n--;i--;
           }
        }
        System.out.print("Mang sau khi xoa:");
        for (int i=0;i<n;i++) {
            System.out.print(array[i]+" ");
        }
    }
}

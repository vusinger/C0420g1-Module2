import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
//        ------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu mang 1:");
        int size1 = sc.nextInt();
        System.out.print("Nhap so luong phan tu mang 2:");
        int size2 = sc.nextInt();
//        -----------------------------------
        int[] array1 = new int[size1];
        int[] array2 = new int[size2];
        int[] array3 = new int[size1+size2];
        System.out.println("Nhap Mang 1");
        for (int i = 0; i < size1; i++) {
            System.out.print("Nhap phan tu thu "+i+":");
            array1[i] = sc.nextInt();
        }
        System.out.println("Nhap Mang 2");
        for (int i = 0; i < size2; i++) {
            System.out.print("Nhap phan tu thu "+i+":");
            array2[i] = sc.nextInt();
        }
        System.arraycopy(array1,0,array3,0,size1);
        System.arraycopy(array2,0,array3,size1,size2);
//        -----------------------------------------
        System.out.println("Mang sau khi gop:");
        System.out.println(Arrays.toString(array3));
    }
}

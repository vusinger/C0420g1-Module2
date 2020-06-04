package ThemPhanTuVaoMang;
import java.util.Arrays;
import java.util.Scanner;

public class AddValueToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu mang:");
        int size = sc.nextInt();
        System.out.print("Nhap so luong phan tu muon them vao mang:");
        int sizeplus = sc.nextInt();
        int[] array = new int[size+sizeplus];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhap phan tu thu "+i+":");
            array[i] = sc.nextInt();
        }
        System.out.print("Mang truoc khi them vao:");
        System.out.print(Arrays.toString(array));
        System.out.println();
        for (int i = 0; i < sizeplus ; i++) {
            System.out.print("Nhap phan tu muon them vao mang:");
            int x = sc.nextInt();
            System.out.print("Nhap vi tri muon them vao mang:");
            int pos = sc.nextInt();
            array = addArray(array,x,pos,size);
            size++;
        }
        System.out.print("Mang sau khi them vao:");
        System.out.print(Arrays.toString(array));
    }

    public static int[] addArray(int[] array, int x, int pos,int size) {
        for (int i = size; i >pos ; i--) {
            array[i] = array[i-1];
        }
        array[pos] = x;
        return array;
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap row mang:");
        int row  = sc.nextInt();
        System.out.print("Nhap col mang:");
        int col = sc.nextInt();
        int[][] array = new int[row][col];
//        --------------------------------------
        int max = 0;
        int pos1 = 0,pos2 = 0;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.print("Nhap phan tu thu ["+i+","+j+"]:");
                array[i][j] = sc.nextInt();
                if (i==0&&j==0) {
                    max = array[i][j];
                } else if(array[i][j]>max) {
                    max = array[i][j];
                    pos1 = i;pos2 = j;
                }
            }
        }
//        -------------------------------------
        System.out.println("Mang hai chieu:");
        System.out.println(Arrays.deepToString(array));
        System.out.println("Phan tu lon nhat trong mang:"+max+" o vi tri ["+(pos1+1)+","+(pos2+1)+"]");
    }
}

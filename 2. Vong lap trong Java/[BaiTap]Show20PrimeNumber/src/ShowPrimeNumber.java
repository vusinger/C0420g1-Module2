import java.util.Scanner;

public class ShowPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong snt muon hien thi:");
        int numb = sc.nextInt();
        int count = 0, snt = 2;
        boolean check;
        while (count < numb) {
            check = true;
            for(int i = 2;i<=Math.sqrt(snt);i++) {
                if (snt % i == 0) {
                    check = false;
                }
            }
            if (check) {
                System.out.println(snt);
                count++;
            }
            snt++;
        }
    }
}

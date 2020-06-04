package UngDungChuyenDoiTienTe;

import java.util.Scanner;

public class ChangeCurrency {
    public static void main(String[] args) {
        int vnd = 23000;
        int usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền USD vào : ");
        usd = sc.nextInt();
        vnd *= usd;
        System.out.printf("%d USD thì bằng %d VND",usd,vnd);
    }
}

package SoNguyenToNhoHon100;

public class PrimeNumber {
    public static void main(String[] args) {
        int snt = 2;
        boolean check;
        while (true) {
            check = true;
            for(int i = 2;i<=Math.sqrt(snt);i++) {
                if (snt % i == 0) {
                    check = false;
                }
            }
            if (check) {
                System.out.println(snt);
            }
            snt++;
            if (snt >=100) { break; }
        }
    }
}

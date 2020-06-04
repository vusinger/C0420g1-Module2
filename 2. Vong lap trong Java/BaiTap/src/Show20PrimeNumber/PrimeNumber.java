package Show20PrimeNumber;

public class PrimeNumber {
    public static void main(String[] args) {
        int snt = 2;
        boolean check;
        int count = 0;

        while (true) {
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
            if (count == 20) { break; }
        }
    }
}

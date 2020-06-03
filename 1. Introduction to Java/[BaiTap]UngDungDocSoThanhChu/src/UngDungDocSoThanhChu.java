import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so cua ban(0-999):");
        int numb = sc.nextInt();
        boolean check = false;
        boolean check1 = true;
        if (numb>999) { numb = -1;}
//       Doc Hang Tram
        if (numb>=100) {
            int tram = numb/100;
            switch (tram) {
                case 1:
                    System.out.print("Một trăm ");
                    break;
                case 2:
                    System.out.print("Hai trăm ");
                    break;
                case 3:
                    System.out.print("Ba trăm ");
                    break;
                case 4:
                    System.out.print("Bốn trăm ");
                    break;
                case 5:
                    System.out.print("Năm trăm ");
                    break;
                case 6:
                    System.out.print("Sáu trăm ");
                    break;
                case 7:
                    System.out.print("Bảy trăm ");
                    break;
                case 8:
                    System.out.print("Tám trăm ");
                    break;
                case 9:
                    System.out.print("Chín trăm ");
                    break;
                default:
                    break;
            }
            numb = numb - tram*100;
            check = true;
            if ((numb < 10)&&(numb != 0)) { System.out.print("Lẻ "); check = false;}
            if (numb == 0) {numb = -1;}
        }
//        Doc hang Chuc
        if (numb>=10) {
            int chuc = numb/10;
            switch (chuc) {
                case 1:
                    System.out.print("Mười ");
                    check1 = false;
                    break;
                case 2:
                    System.out.print("Hai mươi ");
                    break;
                case 3:
                    System.out.print("Ba mươi ");
                    break;
                case 4:
                    System.out.print("Bốn mươi ");
                    break;
                case 5:
                    System.out.print("Năm mươi ");
                    break;
                case 6:
                    System.out.print("Sáu mươi ");
                    break;
                case 7:
                    System.out.print("Bảy mươi ");
                    break;
                case 8:
                    System.out.print("Tám mươi ");
                    break;
                case 9:
                    System.out.print("Chín mươi ");
                    break;
                default:
                    break;
            }
            numb = numb-chuc*10;
            check = true;
            if (numb == 0) { numb = -1; }
        }
//        Doc hang don vi
        if (numb>=0) {
            int donvi = numb;
            switch (donvi) {
                case 0:
                    System.out.print("Không");
                    break;
                case 1:
                    if (check&&check1) {System.out.print("Mốt");} else {
                        System.out.println("Một");
                    }
                    break;
                case 2:
                    System.out.print("Hai");
                    break;
                case 3:
                    System.out.print("Ba");
                    break;
                case 4:
                    if (!check&&check1) {System.out.print("Tư");} else {
                        System.out.println("Bốn");
                    }
                    break;
                case 5:
                    if (check) {System.out.print("Lăm");} else {
                        System.out.println("Năm");
                    }
                    break;
                case 6:
                    System.out.print("Sáu");
                    break;
                case 7:
                    System.out.print("Bảy");
                    break;
                case 8:
                    System.out.print("Tám");
                    break;
                case 9:
                    System.out.print("Chín");
                    break;
                default:
                    break;
            }
        }
//        ------------------------
    }
}

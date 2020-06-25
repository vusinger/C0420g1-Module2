package tinh_tong_cac_so_trong_file;

import java.io.*;
import java.util.Scanner;

public class SumFile {
    public void readFileText(String filePath) {
        double sum = 0;
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    line = "0";
                } else System.out.println(line);
                sum += Double.parseDouble(line);
            }
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);
        } catch (FileNotFoundException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("File không tồn tại !!");
        } catch (NumberFormatException e){
            e.printStackTrace();
            System.err.println("Nhap so sai dinh dang!!");
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Nội dung có lỗi !!!");
        }
    }
    public static void main(String[] args) {
//        System.out.println("Nhập đường dẫn file: ");
//        Scanner scanner = new Scanner(System.in);
//        String path = scanner.nextLine();
        String path = "src/content/test1.txt";
        SumFile readfileEx = new SumFile();
        readfileEx.readFileText(path);
    }
}

package copy_file_text;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    static final String PATH = "src/content";

    public static void main(String[] args) {
        /**
         * Tao thu muc
         */
        //Tạo đối tượng File trỏ tới đường dẫn
        File dir = new File(PATH);
        //Tạo thư mục nếu đường dẫn không tồn tại
        dir.mkdir();

        /**
         * Tao file test1
         */

        //Tạo đối tượng File trỏ tới đường dẫn
        File file = new File(PATH,"test1.txt");
        try {
            //Tạo file
            if (file.createNewFile()){
                System.out.println("File created..");
            }else {
                System.out.println("File already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Tao File test2
         */

        file = new File(PATH,"test2.txt");
        try {
            //Tạo file
            if (file.createNewFile()){
                System.out.println("File created..");
            }else {
                System.out.println("File already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Liet ke noi dung thu muc
         */

        //Liệt kê nội dung thư mục
        if (dir.isDirectory()){
            String[] dirContent = dir.list();
            for (int i = 0; i < dirContent.length; i++ ){
                System.out.println(dirContent[i]);
            }
        }
    }
}

package copy_file_text;

import java.io.File;

public class Check_File_Information {
    static final String PATH = "src/content";

    public static void main(String[] args) {
        File file = new File(PATH,"test.txt");
        System.out.println(file.exists());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.length() + "bytes");
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}

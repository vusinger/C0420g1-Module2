package ghi_file_continue;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFileTest {
    static final String PATH = "src/content/test.txt";

    public static void main(String[] args) {
        try {
            ghiFile();
            ghiFile1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ghiFile1() throws IOException {
        FileWriter file = new FileWriter(PATH,true);
        BufferedWriter bw = new BufferedWriter(file);
        PrintWriter out = new PrintWriter(bw);
        out.println("Hello myfriend");
        out.println("Bạn đã ăn gì chưa");
        bw.close();
        file.close();
    }

    private static void ghiFile() throws IOException {
        FileWriter file = new FileWriter(PATH,false);
        BufferedWriter bw;
        bw = Files.newBufferedWriter(Paths.get("src/content/test.txt"),
                Charset.forName("UTF8"),
                StandardOpenOption.WRITE,
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE);
        PrintWriter out = new PrintWriter(bw, true);
        out.println("What your Name");
        out.println("Bạn muốn ăn gì");
        bw.close();
        file.close();
    }
}

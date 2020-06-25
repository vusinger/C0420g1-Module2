package copy_file_text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Write_Content_File {
    static final String PATH = "src/content/test.txt";

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PATH);
            fileWriter.write("CodeGymDaNang");
            fileWriter.write(" Lop c0520G1");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

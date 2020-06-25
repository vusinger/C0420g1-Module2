package ham_doc_ghi_du_lieu_file;

import java.io.*;

public class Input_Output_File {
    static final String PATH = "src/content/test.txt";

    public static void main(String[] args) {
        try {
            StringBuffer fileText = new StringBuffer();
            fileText.append("Noi dung them moi");
            ghifile(PATH,fileText);
            copyFile(PATH,"filemoi");
        } catch (IOException e) {
            System.out.println("Khong tim thay file");
        }
    }

    private static void copyFile(String path, String filemoi) throws IOException {
        char[] arr = path.toCharArray();
        int size = path.lastIndexOf("/");
        path = "";
        for (int i = 0; i <= size; i++) {
            path += arr[i];
        }
        path += filemoi;
        StringBuffer fileText = new StringBuffer();
        fileText.append(docfile(PATH)+"\n");

        FileWriter file = new FileWriter(path);
        file.write(String.valueOf(fileText));
        file.close();
    }

    private static void ghifile(String path, StringBuffer str) throws IOException {
        StringBuffer fileText = new StringBuffer();
        fileText.append(docfile(PATH)+"\n");
        fileText.append(str);

        FileWriter file = new FileWriter(PATH);
        file.write(String.valueOf(fileText));
        file.close();
    }

    private static StringBuffer docfile(String path) throws IOException {
        FileReader file = new FileReader(PATH);
        BufferedReader bufferedReader = new BufferedReader(file);
        StringBuffer result = new StringBuffer();
        String line;
        while ( (line = bufferedReader.readLine()) != null){
            result.append(line+"\n");
        }
        bufferedReader.close();
        file.close();
        return result;
    }
}

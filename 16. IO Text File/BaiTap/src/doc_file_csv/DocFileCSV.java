package doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocFileCSV {
    static final String PATH = "src/content/file.csv";

    public static void main(String[] args) {
        StringBuffer str = docTuManHinh();
        try {
            ghiFile(PATH, str);
            List<String> arr = new ArrayList<>();
            arr = docfileCSV(PATH);
//            showResult(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showResult(List<String> arr) {
        int index = 0;
        String[] array;
        for (String str:arr) {
            if ("".equals(str)) break;
            index++;
            str = str.replaceAll("\"","");
            array = str.split(",");
            System.out.println(+index+","+array[array.length-2]+","+array[array.length-1]);
        }
    }

    private static ArrayList<String> docfileCSV(String path) throws IOException {
        List<String> arr = new ArrayList<>();
        FileReader file = new FileReader(path);
        BufferedReader br = new BufferedReader(file);
        String line;
        while((line = br.readLine()) != null) {
            arr.add(line);
        }
        br.close();
        file.close();
        return (ArrayList<String>) arr;
    }

    private static void ghiFile(String path, StringBuffer str) throws IOException {
        FileWriter file = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(file);
        PrintWriter out = new PrintWriter(bw);
        out.println(String.valueOf(str));
        bw.close();
        file.close();
    }

    private static StringBuffer docTuManHinh() {
        Scanner scn = new Scanner(System.in);
        String line = " ";
        StringBuffer str = new StringBuffer();
        while(!"".equals(line)) {
            line = scn.nextLine();
            if ("".equals(line)) {
                line = scn.nextLine();
                if ("".equals(line)) {
                    line = scn.nextLine();
                    if ("".equals(line)) {
                        break;
                    }
                }
            }
            line += "\n";
            str.append(line);
        }
        return str;
    }
}

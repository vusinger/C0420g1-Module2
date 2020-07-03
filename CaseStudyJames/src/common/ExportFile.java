package common;

import models.Word;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportFile {

    /**
     * Export File
     * @param path:URL
     */
    public static void export(String path) {
        /*Delete File*/
        File file = new File(path);
        file.delete();

        String str = "\n ******************************************************************************************** \n\n";
        List<Word> wordBank = ArrayMethod.getArray();
        if (!wordBank.isEmpty()) {
            boolean check = false;
            for (Word word : wordBank) {
                try {
                    exportFile(path,str+word.showWord());
                    check = true;
                } catch (IOException e) {
                    System.out.println("Sai duong dan!!!!");
                }
            }
            if (check) System.out.println("Xuat File Thanh Cong!!!!");
        } else {
            System.out.println("Word Bank Empty!!!!Need add word!!");
        }
    }
//    --------------------------------------------------------------------------
    public static void exportFile(String path, String word) throws IOException {
        String dir = getDir(path);
        String name = getName(path);
        File dirNew = new File(dir);
        dirNew.mkdir();
        File fileNew = new File(dir,name);
        if (!fileNew.exists()) {
            fileNew.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(path,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(word);
        bufferedWriter.close();
        fileWriter.close();
    }

    private static String getName(String path) {
        String[] arr = path.split("/");
        return arr[arr.length-1];
    }

    private static String getDir(String path) {
        String[] arr = path.split("/");
        String dir = path.replaceAll(arr[arr.length-1],"");
        return dir;
    }
//    ------------------------------------------------------------------------------
}

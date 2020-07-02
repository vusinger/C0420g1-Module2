package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSolution<E> {

    final String PATH_DIR = "src/data/";
    final String FILE_NAME = "WordBank.csv";

    private List<E> array = new ArrayList<>();

    public List<E> getArray() {
        this.convertToData();
        return array;
    }

    public void setArray(List<E> array) {
        this.array = array;
        this.convertToFile();
    }

    private void generateFile() {
        File dir = new File(PATH_DIR);
        dir.mkdir();
        File file = new File(PATH_DIR,FILE_NAME);
        if (!file.exists()) {
            convertToFile();
        }
    }

    private void convertToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_DIR+FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.array);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }

    public void convertToData() {
        try {
            generateFile();
            FileInputStream fileInputStream = new FileInputStream(PATH_DIR+FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.array = (List<E>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            this.array.clear();
            convertToFile();
            System.out.println("Loi khoi tao file");
        } catch (ClassNotFoundException e) {
            System.out.println("Loi duong dan file");
        }
    }
}

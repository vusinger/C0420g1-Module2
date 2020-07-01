package common;

import java.io.*;
import java.util.List;

public class FileSolution<E> {

    final String PATH_WORD_BANK = "src/data/WordBank.csv";
    private List<E> array;

    public List<E> getArray() {
        this.convertToData();
        return array;
    }

    public void setArray(List<E> array) {
        this.array = array;
        this.convertToFile();
    }

    private void convertToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_WORD_BANK);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.array);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertToData() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_WORD_BANK);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.array = (List<E>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            this.array.clear();
            convertToFile();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

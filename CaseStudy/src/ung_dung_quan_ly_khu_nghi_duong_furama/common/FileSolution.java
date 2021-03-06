package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import java.io.*;
import java.util.List;

public class FileSolution<E> {

    private String name;
    private String path;
    private List<E> objectArray;
//---------------------------------------------------------------------------------------------

    public FileSolution(String name, String path, List<E> objectArray) {
        this.name = name+".csv";
        this.path = path;
        this.objectArray = objectArray;
    }
//---------------------------------------------------------------------------------------------

    /**
     * Khoi tao file
     * @throws IOException
     */
    public void generateFile() throws IOException {
        File dir = new File("src/ung_dung_quan_ly_khu_nghi_duong_furama/data/");
        dir.mkdir();
        File file = new File("src/ung_dung_quan_ly_khu_nghi_duong_furama/data/", name);
        if (!file.exists()) {
            convertToFile(objectArray);
        }
    }
//---------------------------------------------------------------------------------------------

    /**
     * Get Object array tu file
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<E> convertData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectArray = (List<E>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return objectArray;
    }
//---------------------------------------------------------------------------------------------

    /**
     * Luu objectArray vao file
     */
    public <E>void convertToFile(List<E> arr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectArray);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.Employee;

import java.io.*;
import java.util.Map;
import java.util.Set;

public class FileUltilEmployee {
    private String path;
    private Map<Integer, Employee> objectArray;

    public FileUltilEmployee(String path, Map<Integer,Employee> objectArray) {
        this.path = path;
        this.objectArray = objectArray;
    }

    public Map<Integer,Employee> convertData() throws IOException{
        Employee employee;
        FileReader fileReader = new FileReader(path);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        String[] array;
        while((line = br.readLine()) != null) {
            array = line.split(",");
            employee = new Employee(Integer.parseInt(array[0]),array[1],array[2],array[3]);
            objectArray.put(employee.getId(),employee);
        }
        br.close();
        fileReader.close();
        return objectArray;
    }

    public void convertToFile() {
        try {
            Employee employee;
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            Set<Integer> set = objectArray.keySet();
            for (Integer key : set) {
                employee = objectArray.get(key);
                bw.write(employee.getId()+","+employee.getName()+","+employee.getAge()+","+employee.getAddress()+"\n");
            }
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

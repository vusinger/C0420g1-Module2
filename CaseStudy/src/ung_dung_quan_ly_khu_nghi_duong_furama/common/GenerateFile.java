package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Khai bao va su dung Array
 */
public class GenerateFile {
//  ---------------------------------------------------------------------------

    static List<Services> villaArray = new ArrayList<>();
    static List<Services> houseArray = new ArrayList<>();
    static List<Services> roomArray = new ArrayList<>();
    static List<Customer> customerArray = new ArrayList<>();
    static Map<Integer, Employee> employeeArray = new HashMap<>();

    public GenerateFile() {
        this.getData();
    }

    public static void getData() {
        try {
            GenerateDataFile();
        } catch (IOException e) {
            ResetDataFile();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//  ---------------------------------------------------------------------------

    /**
     * Getter va setter
     * @return ListArray
     */
    public static List<Services> getVillaArray() {
        return villaArray;
    }

    public static List<Services> getHouseArray() {
        return houseArray;
    }

    public static List<Services> getRoomArray() {
        return roomArray;
    }

    public static List<Customer> getCustomerArray() {
        return customerArray;
    }

    public static Map<Integer, Employee> getEmployeeArray() {
        return employeeArray;
    }

    public static void setCustomerArray(List<Customer> customerArray) {
        GenerateFile.customerArray = customerArray;
    }

//  ---------------------------------------------------------------------------

    /**
     * Khoi tao mang doc tu file csv
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void GenerateDataFile() throws IOException, ClassNotFoundException {
        FileSolution<Services> file1 = new FileSolution<>("Villa", GenericMethod.getPath("Villa"), villaArray);
        file1.generateFile();
        villaArray = file1.convertData();
        FileSolution<Services> file2 = new FileSolution<>("House", GenericMethod.getPath("House"), houseArray);
        file2.generateFile();
        houseArray = file2.convertData();
        FileSolution<Services> file3 = new FileSolution<>("Room", GenericMethod.getPath("Room"), roomArray);
        file3.generateFile();
        roomArray = file3.convertData();
        FileSolution<Customer> file4 = new FileSolution<>("Customer", GenericMethod.getPath("Customer"), customerArray);
        file4.generateFile();
        customerArray = file4.convertData();
        FileUltilEmployee file5 = new FileUltilEmployee(GenericMethod.getPath("Employee"), employeeArray);
        employeeArray = file5.convertData();
    }
//  ---------------------------------------------------------------------------

    /**
     * Reset lai file csv tu mang
     */
    public static void ResetDataFile() {
        villaArray.clear();
        houseArray.clear();
        roomArray.clear();
        customerArray.clear();
        employeeArray.clear();
        FileSolution<Services> file1 = new FileSolution<>("Villa", GenericMethod.getPath("Villa"), villaArray);
        file1.convertToFile();
        FileSolution<Services> file2 = new FileSolution<>("House", GenericMethod.getPath("House"), houseArray);
        file2.convertToFile();
        FileSolution<Services> file3 = new FileSolution<>("Room", GenericMethod.getPath("Room"), roomArray);
        file3.convertToFile();
        FileSolution<Customer> file4 = new FileSolution<>("Customer", GenericMethod.getPath("Customer"), customerArray);
        file4.convertToFile();
        FileUltilEmployee file5 = new FileUltilEmployee(GenericMethod.getPath("Employee"), employeeArray);
        file5.convertToFile();
    }


//  ---------------------------------------------------------------------------

    /**
     * Get Array
     * @param name Villa House Room
     * @return List<Service>
     */
    public static List<Services> getArray(String name) {
        if ("Villa".equals(name)) return villaArray;
        else if ("House".equals(name)) return houseArray;
        else if ("Room".equals(name)) return roomArray;
        return null;
    }

    public static void setArray(List<Services> array, String name) {
        if ("Villa".equals(name)) GenerateFile.villaArray = array;
        else if ("House".equals(name)) GenerateFile.houseArray = array;
        else if ("Room".equals(name)) GenerateFile.roomArray = array;
    }
//  ---------------------------------------------------------------------------
}

package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.Customer;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Employee;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Services;

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

    static {
        getData();
    }

    public static void getData() {
        try {
            GenerateDataFile();
        } catch (IOException e) {
            ResetDataFile();
            System.out.println("File bi loi!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay file!!");
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
    public static <E> List<E> getArray(String name) {
        if ("Villa".equals(name)) return (List<E>) villaArray;
        else if ("House".equals(name)) return (List<E>) houseArray;
        else if ("Room".equals(name)) return (List<E>) roomArray;
        else if ("Customer".equals(name)) return (List<E>) customerArray;
        return null;
    }

    public static <E> void setArray(List<E> array, String name) {
        if ("Villa".equals(name)) villaArray = (List<Services>) array;
        else if ("House".equals(name)) houseArray = (List<Services>) array;
        else if ("Room".equals(name)) roomArray = (List<Services>) array;
        else if ("Customer".equals(name)) customerArray = (List<Customer>) array;
    }
//  ---------------------------------------------------------------------------
}

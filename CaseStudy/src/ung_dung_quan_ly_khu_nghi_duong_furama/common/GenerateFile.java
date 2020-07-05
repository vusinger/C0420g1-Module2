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

    public static Map<Integer, Employee> getEmployeeArray() {
        return employeeArray;
    }

    public static void setEmployeeArray(Map<Integer, Employee> employeeArray) {
        GenerateFile.employeeArray = employeeArray;
    }

    //  ---------------------------------------------------------------------------

    /**
     * Khoi tao mang doc tu file csv
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void GenerateDataFile() throws IOException, ClassNotFoundException {
        villaArray = generateData("Villa",villaArray);
        houseArray = generateData("House",houseArray);
        roomArray = generateData("Room",roomArray);
        customerArray = generateData("Customer",customerArray);
        FileUltilEmployee file5 = new FileUltilEmployee(GenericMethod.getPath("Employee"), employeeArray);
        employeeArray = file5.convertData();
    }

    private static <E> List<E> generateData(String name, List<E> arr) throws IOException, ClassNotFoundException {
        FileSolution<E> file = new FileSolution<>(name,GenericMethod.getPath(name),arr);
        file.generateFile();
        arr = file.convertData();
        return arr;
    }

//  ---------------------------------------------------------------------------

    /**
     * Reset lai file csv tu mang
     */
    public static void ResetDataFile() {
        resetFile(villaArray,"Villa");
        resetFile(houseArray,"House");
        resetFile(roomArray,"Room");
        resetFile(customerArray,"Customer");
        employeeArray.clear();
        FileUltilEmployee file5 = new FileUltilEmployee(GenericMethod.getPath("Employee"), employeeArray);
        file5.convertToFile();
    }

    private static <E> void resetFile(List<E> arr,String name) {
        arr.clear();
        FileSolution<E> file = new FileSolution<E>(name, GenericMethod.getPath(name), arr);
        file.convertToFile(arr);
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

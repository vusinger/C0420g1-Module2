package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.FileSolution;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.FileUltilEmployee;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateFile {

    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    private List<Services> villaArray = new ArrayList<>();
    final static String PATHHOUSE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/House.csv";
    private List<Services> houseArray = new ArrayList<>();
    final static String PATHROOM = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Room.csv";
    private List<Services> roomArray = new ArrayList<>();
    final static String PATHCUSTOMER = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Customer.csv";
    private List<Customer> customerArray = new ArrayList<>();
    final static String PATHEMPLOYEE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Employee.csv";
    private Map<Integer, Employee> employeeArray = new HashMap<>();

    public GenerateFile() {
        this.getData();
    }

    public List<Services> getVillaArray() {
        return villaArray;
    }

    public List<Services> getHouseArray() {
        return houseArray;
    }

    public List<Services> getRoomArray() {
        return roomArray;
    }

    public List<Customer> getCustomerArray() {
        return customerArray;
    }

    public Map<Integer, Employee> getEmployeeArray() {
        return employeeArray;
    }

    public void GenerateDataFile() throws IOException, ClassNotFoundException {
        FileSolution<Services> file1 = new FileSolution<>("Villa.csv", PATHVILLA, villaArray);
        file1.generateFile();
        villaArray = file1.convertData();
        FileSolution<Services> file2 = new FileSolution<>("House.csv", PATHHOUSE, houseArray);
        file2.generateFile();
        houseArray = file2.convertData();
        FileSolution<Services> file3 = new FileSolution<>("Room.csv", PATHROOM, roomArray);
        file3.generateFile();
        roomArray = file3.convertData();
        FileSolution<Customer> file4 = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        file4.generateFile();
        customerArray = file4.convertData();
        FileUltilEmployee file5 = new FileUltilEmployee(PATHEMPLOYEE, employeeArray);
        employeeArray = file5.convertData();
    }

    public void ResetDataFile() {
        villaArray.clear();
        houseArray.clear();
        roomArray.clear();
        customerArray.clear();
        employeeArray.clear();
        FileSolution<Services> file1 = new FileSolution<>("Villa.csv", PATHVILLA, villaArray);
        file1.convertToFile();
        FileSolution<Services> file2 = new FileSolution<>("House.csv", PATHHOUSE, houseArray);
        file2.convertToFile();
        FileSolution<Services> file3 = new FileSolution<>("Room.csv", PATHROOM, roomArray);
        file3.convertToFile();
        FileSolution<Customer> file4 = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        file4.convertToFile();
        FileUltilEmployee file5 = new FileUltilEmployee(PATHEMPLOYEE, employeeArray);
        file5.convertToFile();
    }

    public void getData() {
        try {
            this.GenerateDataFile();
        } catch (IOException e) {
            this.ResetDataFile();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

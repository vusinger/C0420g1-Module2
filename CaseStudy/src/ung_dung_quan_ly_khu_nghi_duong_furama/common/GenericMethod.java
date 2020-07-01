package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import ung_dung_quan_ly_khu_nghi_duong_furama.controllers.GenerateFile;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GenericMethod {
    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    final static String PATHHOUSE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/House.csv";
    final static String PATHROOM = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Room.csv";
    final static String PATHCUSTOMER = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Customer.csv";
    final static String PATHEMPLOYEE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Employee.csv";

    /**
     * Phuong phap chung
     *
     * @return
     */
    public static String inputString() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public static int inputNumber() {
        Scanner scn = new Scanner(System.in);
        String inputString;
        int number;
        while (true) {
            inputString = scn.nextLine();
            try {
                number = Integer.parseInt(inputString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang!!!!");
            }
        }
        return number;
    }

    public static double inputNumberDouble() {
        Scanner scn = new Scanner(System.in);
        String inputString;
        double number;
        while (true) {
            inputString = scn.nextLine();
            try {
                number = Double.parseDouble(inputString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang!!!!");
            }
        }
        return number;
    }

    public static int findMaxService(List<Services> array) {
        int maxId;
        if (!array.isEmpty()) {
            maxId = array.get(0).getId();
        } else maxId = 0;
        for (Services obj : array) {
            if (obj.getId() > maxId) maxId = obj.getId();
        }
        return maxId;
    }

    public static int findMaxCustomer(List<Customer> array) {
        int maxId;
        if (!array.isEmpty()) {
            maxId = array.get(0).getId();
        } else maxId = 0;
        for (Customer obj : array) {
            if (obj.getId() > maxId) maxId = obj.getId();
        }
        return maxId;
    }

    public static Services genarateObject(String name) {
        if ("Villa".equals(name)) {
            return new Villa();
        } else if ("House".equals(name)) {
            return new House();
        } else if ("Room".equals(name)) {
            return new Room();
        }
        return null;
    }

    public static String getPath(String name) {
        if ("Villa".equals(name)) return PATHVILLA;
        else if ("House".equals(name)) return PATHHOUSE;
        else if ("Room".equals(name)) return PATHROOM;
        else if ("Customer".equals(name)) return PATHCUSTOMER;
        else if ("Employee".equals(name)) return PATHEMPLOYEE;
        return null;
    }

    public static void convertToFile(String name) {
        if ("Villa".equals(name)) {
            FileSolution<Services> file = new FileSolution<>(name, GenericMethod.getPath(name), GenerateFile.getVillaArray());
            file.convertToFile();
        } else if ("House".equals(name)) {
            FileSolution<Services> file = new FileSolution<>(name, GenericMethod.getPath(name), GenerateFile.getHouseArray());
            file.convertToFile();
        } else if ("Room".equals(name)) {
            FileSolution<Services> file = new FileSolution<>(name, GenericMethod.getPath(name), GenerateFile.getRoomArray());
            file.convertToFile();
        } else if ("Customer".equals(name)) {
            FileSolution<Customer> file = new FileSolution<>(name, GenericMethod.getPath(name), GenerateFile.getCustomerArray());
            file.convertToFile();
        }
    }

    public static void saveToArray(String name, Object obj) {
        if ("Villa".equals(name)) {
            List<Services> array = GenerateFile.getVillaArray();
            array.add((Villa) obj);
            GenerateFile.setVillaArray(array);
        } else if ("House".equals(name)) {
            List<Services> array = GenerateFile.getHouseArray();
            array.add((House) obj);
            GenerateFile.setHouseArray(array);
        } else if ("Room".equals(name)) {
            List<Services> array = GenerateFile.getRoomArray();
            array.add((Room) obj);
            GenerateFile.setRoomArray(array);
        } else if ("Customer".equals(name)) {
            List<Customer> array = GenerateFile.getCustomerArray();
            array.add((Customer) obj);
            GenerateFile.setCustomerArray(array);
        }
    }
}

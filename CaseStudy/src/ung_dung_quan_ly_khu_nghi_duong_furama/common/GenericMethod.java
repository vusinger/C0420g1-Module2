package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.util.List;
import java.util.Scanner;

public class GenericMethod {
    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    final static String PATHHOUSE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/House.csv";
    final static String PATHROOM = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Room.csv";
    final static String PATHCUSTOMER = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Customer.csv";
    final static String PATHEMPLOYEE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Employee.csv";

    /**
     * Input data
     * @return String, integer, double
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
//-------------------------------------------------------

    /**
     * Tim gia tri MaxID trong mang
     *
     * @param name:Villa House Room Customer
     * @return maxid
     */
    public static <E> int findMax(String name, List<E> arr) {
        int maxId = 0;
        if ("Customer".equals(name)) {
            for (Customer obj : (List<Customer>) arr) {
                maxId = Math.max(maxId, obj.getId());
            }
        } else {
            for (Services obj : (List<Services>) arr) {
                maxId = Math.max(maxId, obj.getId());
            }
        }
        return maxId;
    }

//--------------------------------------------------------------------

    /**
     * Tao object new cho Service
     *
     * @param name:Villa House Room
     * @return new object
     */
    public static Services generateObject(String name) {
        if ("Villa".equals(name)) {
            return new Villa();
        } else if ("House".equals(name)) {
            return new House();
        } else if ("Room".equals(name)) {
            return new Room();
        }
        return null;
    }
//-----------------------------------------------------------------------
    /**
     * Lay duong dan URL file csv
     * @param name :Villa House Room Customer Employee
     * @return PATH_URL
     */
    public static String getPath(String name) {
        if ("Villa".equals(name)) return PATHVILLA;
        else if ("House".equals(name)) return PATHHOUSE;
        else if ("Room".equals(name)) return PATHROOM;
        else if ("Customer".equals(name)) return PATHCUSTOMER;
        else if ("Employee".equals(name)) return PATHEMPLOYEE;
        return null;
    }
//-----------------------------------------------------------------------

    /**
     * Ghi vao file csv
     *
     * @param name :Villa House Room Customer
     */
    public static <E> void convertToFile(String name, List<E> arr) {
        FileSolution<E> file = new FileSolution<E>(name, GenericMethod.getPath(name), arr);
        file.convertToFile(arr);
    }
//-----------------------------------------------------------------------

    /**
     * Luu object moi vao mang
     */
    public static <E> void saveToArray(List<E> array,E obj,String name) {
            array.add(obj);
            GenerateFile.setArray(array,name);
    }

//-----------------------------------------------------------------------

}

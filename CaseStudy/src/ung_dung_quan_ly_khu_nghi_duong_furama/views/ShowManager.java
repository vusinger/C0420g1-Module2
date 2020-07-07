package ung_dung_quan_ly_khu_nghi_duong_furama.views;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenerateFile;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.util.*;

public class ShowManager {

    public static int showServices() {
        System.out.println("--------------------- Furama resort ------------------------");
        System.out.print("1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit\n");
        System.out.println("Choose:");
        int choose = GenericMethod.inputNumber();
        switch (choose) {
            case 1:
                showAll(GenerateFile.getArray("Villa"), "Villa");
                break;
            case 2:
                showAll(GenerateFile.getArray("House"), "House");
                break;
            case 3:
                showAll(GenerateFile.getArray("Room"), "Room");
                break;
            case 4:
                showNameNotDuplicate(GenerateFile.getArray("Villa"), "Villa");
                break;
            case 5:
                showNameNotDuplicate(GenerateFile.getArray("House"), "House");
                break;
            case 6:
                showNameNotDuplicate(GenerateFile.getArray("Room"), "Room");
                break;
            case 7:
            case 8:
                break;
        }
        if ((choose == 8) || (choose == 7)) {
        } else choose = showServices();
        return choose;
    }

    public static void showAll(List<Services> objArray, String name) {
        System.out.println("-------------------- Show all " + name + " ---------------------");
        for (Services obj : objArray) {
                obj.showInfo();
        }
    }

    public static void showNameNotDuplicate(List<Services> objArray, String name) {
        System.out.println("-------------------- Show all " + name + " name not duplicate ---------------------");
        Map<String, Services> hashMap = new HashMap<>();
        for (Services obj : objArray) {
            hashMap.put(obj.getServiceName(), obj);
        }
        int index = 0;
        for (String key : hashMap.keySet()) {
            index++;
            System.out.println(index + ". " + key + " " + name + " ");
        }
        System.out.println();
    }

    public static void showInformationEmployee() {
        Set<Integer> set = GenerateFile.getEmployeeArray().keySet();
        for (Integer key : set) {
            System.out.println(GenerateFile.getEmployeeArray().get(key).toString());
        }
    }

    public static void showInformationCustomers() {
        System.out.println("-------------------- Show All Customer ---------------------");
        List<Customer> arr = GenerateFile.getArray("Customer");
        Collections.sort(arr, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if (o1.getName().equals(o2.getName())) {
                    String[] str1 = o1.getBirthDay().split("/");
                    String[] str2 = o2.getBirthDay().split("/");
                    return str1[2].compareTo(str2[2]);
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Customer obj : arr) {
            obj.showInfo();
        }
    }
}

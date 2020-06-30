package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Customer;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.FileSolution;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Services;
import ung_dung_quan_ly_khu_nghi_duong_furama.views.ShowManager;

import java.util.List;

public class Booking {

    final static String PATHCUSTOMER = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Customer.csv";
    static GenerateFile generateFile = new GenerateFile();
    static List<Services> villaArray = generateFile.getVillaArray();
    static List<Services> houseArray = generateFile.getHouseArray();
    static List<Services> roomArray = generateFile.getRoomArray();
    static List<Customer> customerArray = generateFile.getCustomerArray();

    public static int addNewBooking() {
        System.out.println("--------------------- Booking Service ------------------------");
        int idRent = 0, idCustomer = 0;
        System.out.print("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "4. Return Menu\n" +
                "5. Exit\n");
        System.out.println("Choose:");
        int choose = GenericMethod.inputNumber();
        if ((choose == 5) || (choose == 4)) {
        } else {
            ShowManager.showInformationCustomers();
            System.out.println("Chon ID Customer:");
            idCustomer = GenericMethod.inputNumber();
        }
        switch (choose) {
            case 1:
                ShowManager.showAll(villaArray, "Villa");
                System.out.println("Chon ID Villa:");
                idRent = GenericMethod.inputNumber();
                booking("Villa", idCustomer, idRent);
                break;
            case 2:
                ShowManager.showAll(houseArray, "House");
                System.out.println("Chon ID House:");
                idRent = GenericMethod.inputNumber();
                booking("House", idCustomer, idRent);
                break;
            case 3:
                ShowManager.showAll(roomArray, "Room");
                System.out.println("Chon ID Room:");
                idRent = GenericMethod.inputNumber();
                booking("Room", idCustomer, idRent);
                break;
            case 4:
            case 5:
                break;
        }
        if ((choose == 5) || (choose == 4)) {
        } else choose = addNewBooking();
        return choose;
    }

    private static void booking(String name, int idCustomer, int idRent) {
        boolean check1 = false;
        boolean check2 = false;
        int index1 = 0;
        for (Customer customer : customerArray) {
            if (customer.getId() == idCustomer) {
                check1 = true;
                break;
            }
            index1++;
        }
        int index2 = 0;
        if ("Villa".equals(name)) {
            for (Services villa : villaArray) {
                if (villa.getId() == idRent) {
                    check2 = true;
                    break;
                }
                index2++;
            }
            if (check1&&check2) customerArray.get(index1).setUseService(villaArray.get(index2));
        } else if ("House".equals(name)) {
            for (Services house : houseArray) {
                if (house.getId() == idRent) {
                    check2 = true;
                    break;
                }
                index2++;
            }
            if (check1&&check2)  customerArray.get(index1).setUseService(houseArray.get(index2));
        } else if ("Room".equals(name)) {
            for (Services room : roomArray) {
                if (room.getId() == idRent) {
                    check2 = true;
                    break;
                }
                index2++;
            }
            if (check1&&check2)  customerArray.get(index1).setUseService(roomArray.get(index2));
        }
        if (check1&&check2) {
            FileSolution<Customer> fileCustomer = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
            fileCustomer.convertToFile();
        }
    }
}

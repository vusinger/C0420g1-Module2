package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.FileSolution;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenerateFile;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Customer;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Services;
import ung_dung_quan_ly_khu_nghi_duong_furama.views.ShowManager;

import java.util.List;

public class Booking {
    //  ---------------------------------------------------------------------------

    public static int addNewBooking() {
        System.out.println("--------------------- Booking Service ------------------------");
        int idCustomer = 0;
        System.out.print("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "4. Return Menu\n" +
                "5. Exit\n");
        System.out.println("Choose:");
        int choose = GenericMethod.inputNumber();
        switch (choose) {
            case 1:
                newBooking("Villa");
                break;
            case 2:
                newBooking("House");
                break;
            case 3:
                newBooking("Room");
                break;
        }
        if (choose != 4 && choose != 5) choose = addNewBooking();
        return choose;
    }

    private static void newBooking(String name) {
        ShowManager.showInformationCustomers();
        System.out.println("Chon ID Customer:");
        int idCustomer = GenericMethod.inputNumber();
        ShowManager.showAll(GenerateFile.getArray(name), name);
        System.out.println("Chon ID Villa:");
        int idRent = GenericMethod.inputNumber();
        booking(name, idCustomer, idRent);
    }
    //  ---------------------------------------------------------------------------

    /**
     * Booking luu vao customer array
     *
     * @param name       Villa,House,Room
     * @param idCustomer : id customer
     * @param idRent     : id array building
     */
    private static void booking(String name, int idCustomer, int idRent) {
        List<Customer> customerArray = GenerateFile.getArray("Customer");
        List<Services> array = GenerateFile.getArray(name);
        for (Customer customer : customerArray) {
            if (customer.getId() == idCustomer) {
                Services services = isCheck(idRent,array);
                if (services!=null) {
                    customer.setUseService(services);
                    FileSolution<Customer> fileCustomer = new FileSolution<>("Customer", GenericMethod.getPath("Customer"), customerArray);
                    fileCustomer.convertToFile(customerArray);
                }
                break;
            }
        }
    }

    private static Services isCheck(int idRent, List<Services> array) {
        for (Services services:array) {
            if (services.getId()==idRent) return services;
        }
        return null;
    }
    //  ---------------------------------------------------------------------------

}

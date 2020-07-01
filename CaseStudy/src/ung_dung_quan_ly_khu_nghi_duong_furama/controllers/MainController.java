package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.views.ShowManager;

public class MainController {

    public static void main(String[] args) {
        displayMainMenu();
    }

    /**
     * menu display
     * @return
     */
    public static int displayMainMenu() {
        GenerateFile.getData();
        System.out.println("--------------------- Furama resort ------------------------");
        System.out.print("1. Add New Services\n");
        System.out.print("2. Show Services\n");
        System.out.print("3. Add New Customer\n");
        System.out.print("4. Show Information of Customer\n");
        System.out.print("5. Add New Booking\n");
        System.out.print("6. Show Information of Employee\n");
        System.out.print("7. Exit\n");
        System.out.println("Choose:");
        int choose = GenericMethod.inputNumber();
        switch (choose) {
            case 1:
                if (AddNewServices.addNewServices() == 5) choose = 7;
                break;
            case 2:
                if (ShowManager.showServices() == 8) choose = 7;
                break;
            case 3:
                CustomerManager.addNewCustomer();
                break;
            case 4:
                ShowManager.showInformationCustomers();
                break;
            case 5:
                if (Booking.addNewBooking() == 5) choose = 7;
                break;
            case 6:
                ShowManager.showInformationEmployee();
                break;
            case 7:
                break;
        }
        if (choose != 7) choose = displayMainMenu();
        return choose;
    }
}

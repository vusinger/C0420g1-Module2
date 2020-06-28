package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.Services;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    final static List<Services> villaArray = new ArrayList<>();

    public static void main(String[] args) {
        displayMainMenu();
    }

    //  -----------------------------------Generic Method---------------------------------------------

    private static void saveToFile(String pathvilla, List<Services> villaArray) {

    }

    private static String inputString() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    private static int inputNumber() {
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

    private static double inputNumberDouble() {
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

    private static int displayMainMenu() {
        System.out.println("--------------------- Furama resort ------------------------");
        System.out.print("1. Add New Services\n");
        System.out.print("2. Show Services\n");
        System.out.print("3. Add New Customer\n");
        System.out.print("4. Show Information of Customer\n");
        System.out.print("5. Add New Booking\n");
        System.out.print("6. Show Information of Employee\n");
        System.out.print("7. Exit\n");
        System.out.println("Choose:");
        int choose = inputNumber();
        switch (choose) {
            case 1:
                if (addNewServices() == 5) choose = 7;
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showInformationCustomers();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                showInformationEmployee();
                break;
            case 7:
                break;
        }
        if (choose != 7) choose = displayMainMenu();
        return choose;
    }

    //  --------------------------------------------------------------------------------
    private static void showInformationEmployee() {
    }

    //  --------------------------------------------------------------------------------
    private static void addNewBooking() {
    }

    //  --------------------------------------------------------------------------------
    private static void showInformationCustomers() {
    }

    //  --------------------------------------------------------------------------------
    private static void addNewCustomer() {
    }

    //  --------------------------------------------------------------------------------
    private static void showServices() {
    }

    //  --------------------------------------------------------------------------------
    private static int addNewServices() {
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit");
        System.out.println("Choose:");
        int choose = inputNumber();
        switch (choose) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                break;
            case 5:
                break;
        }
        if ((choose == 5) || (choose == 4)) {
        } else choose = addNewServices();
        return choose;
    }

    private static void addNewRoom() {

    }

    private static void addNewHouse() {
    }

    private static void addNewVilla() {
        System.out.println("----------- Add New Villa ----------");
        Services villa = new Villa();
        System.out.print("Villa Id:");
        villa.setId(inputNumber());
        System.out.print("Service Name:");
        villa.setServiceName(inputString());
        System.out.print("Use Area:");
        villa.setUseArea(inputNumberDouble());
        System.out.print("Rental Cost:");
        villa.setRentalCost(inputNumberDouble());
        System.out.print("Maximum Person:");
        villa.setMaximumPerson(inputNumber());
        System.out.print("Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        villa.setInputRentType(inputNumber());

        villaArray.add(villa);
        saveToFile(PATHVILLA,villaArray);
    }

    //  --------------------------------------------------------------------------------
}

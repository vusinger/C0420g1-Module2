package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.House;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Room;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Services;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {

    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    static List<Services> villaArray = new ArrayList<>();
    final static String PATHHOUSE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/House.csv";
    static List<Services> houseArray = new ArrayList<>();
    final static String PATHROOM = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Room.csv";
    static List<Services> roomArray = new ArrayList<>();

    public static void main(String[] args) {
        try {
            generateFile("Villa.csv",PATHVILLA,villaArray);
            villaArray = convertData(PATHVILLA,villaArray);
            generateFile("House.csv",PATHHOUSE,houseArray);
            houseArray = convertData(PATHHOUSE,houseArray);
            generateFile("Room.csv",PATHROOM,roomArray);
            roomArray = convertData(PATHROOM,roomArray);
        } catch (IOException e) {
            villaArray.clear();
            houseArray.clear();
            roomArray.clear();
            convertToFile(PATHVILLA,villaArray);
            convertToFile(PATHHOUSE,houseArray);
            convertToFile(PATHROOM,roomArray);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        displayMainMenu();
    }

    //  -----------------------------------Generic Method---------------------------------------------

    private static void generateFile(String fileName,String path, List<Services> objectArray) throws IOException {
        File dir = new File("src/ung_dung_quan_ly_khu_nghi_duong_furama/data/");
        dir.mkdir();
        File file = new File("src/ung_dung_quan_ly_khu_nghi_duong_furama/data/", fileName);
        if (!file.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectArray);
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    private static List<Services> convertData(String path, List<Services> objectArray) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectArray = (List<Services>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return objectArray;
    }

    private static void convertToFile(String path, List<Services> objectArray) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectArray);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                if (showServices() == 8) choose = 7;
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

    //  -------------------------------- Show Services ---------------------------------
    private static int showServices() {
        System.out.println("--------------------- Furama resort ------------------------");
        System.out.println("1. Show all Villa\n" +
                "2. Show all House\n" +
                "3. Show all Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Room Not Duplicate\n" +
                "7. Back to menu\n" +
                "8. Exit\n");
        System.out.println("Choose:");
        int choose = inputNumber();
        switch (choose) {
            case 1:
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                showAllNameVillaNotDuplicate();
                break;
            case 5:
                showAllNameHouseNotDuplicate();
                break;
            case 6:
                showAllNameRoomNotDuplicate();
                break;
            case 7:
            case 8:
                break;
        }
        if ((choose == 8) || (choose == 7)) {
        } else choose = showServices();
        return choose;
    }

    private static void showAllNameRoomNotDuplicate() {
    }

    private static void showAllNameHouseNotDuplicate() {
    }

    private static void showAllNameVillaNotDuplicate() {
    }

    private static void showAllRoom() {
        System.out.println("--------------------- Show All Room ------------------------");
        for (Services obj:roomArray) {
            Room objnew = (Room)obj;
            objnew.showInfo();
        }
    }

    private static void showAllHouse() {
        System.out.println("--------------------- Show All House ------------------------");
        for (Services obj:houseArray) {
            House objnew = (House)obj;
            objnew.showInfo();
        }
    }

    private static void showAllVilla() {
        System.out.println("--------------------- Show All Villa ------------------------");
        for (Services obj:villaArray) {
            Villa objnew = (Villa)obj;
            objnew.showInfo();
        }
    }

    //  -------------------------------- Add New Service -------------------------------
    private static int addNewServices() {
        System.out.println("--------------------- Furama resort ------------------------");
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
            case 5:
                break;
        }
        if ((choose == 5) || (choose == 4)) {
        } else choose = addNewServices();
        return choose;
    }

    private static void addNewRoom() {
        System.out.println("----------- Add New Room ----------");
        Services room = new Room();
        System.out.print("Room Villa Id:");
        room.setId(inputNumber());
        System.out.print("Room Service Name:");
        room.setServiceName(inputString());
        System.out.print("Room Use Area:");
        room.setUseArea(inputNumberDouble());
        System.out.print("Room Rental Cost:");
        room.setRentalCost(inputNumberDouble());
        System.out.print("Room Maximum Person:");
        room.setMaximumPerson(inputNumber());
        System.out.print("Room Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        room.setInputRentType(inputNumber());

        roomArray.add(room);
        convertToFile(PATHROOM,roomArray);
    }

    private static void addNewHouse() {
        System.out.println("----------- Add New House ----------");
        Services house = new House();
        System.out.print("House Id:");
        house.setId(inputNumber());
        System.out.print("House Service Name:");
        house.setServiceName(inputString());
        System.out.print("House Use Area:");
        house.setUseArea(inputNumberDouble());
        System.out.print("House Rental Cost:");
        house.setRentalCost(inputNumberDouble());
        System.out.print("House Maximum Person:");
        house.setMaximumPerson(inputNumber());
        System.out.print("House Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        house.setInputRentType(inputNumber());

        houseArray.add(house);
        convertToFile(PATHHOUSE,houseArray);
    }

    private static void addNewVilla() {
        System.out.println("----------- Add New Villa ----------");
        Services villa = new Villa();
        System.out.print("Villa Id:");
        villa.setId(inputNumber());
        System.out.print("Villa Service Name:");
        villa.setServiceName(inputString());
        System.out.print("Villa Use Area:");
        villa.setUseArea(inputNumberDouble());
        System.out.print("Villa Rental Cost:");
        villa.setRentalCost(inputNumberDouble());
        System.out.print("Villa Maximum Person:");
        villa.setMaximumPerson(inputNumber());
        System.out.print("Villa Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        villa.setInputRentType(inputNumber());

        villaArray.add(villa);
        convertToFile(PATHVILLA,villaArray);
    }

    //  --------------------------------------------------------------------------------
}

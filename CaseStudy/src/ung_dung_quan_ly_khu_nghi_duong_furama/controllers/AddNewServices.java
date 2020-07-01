package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.Regex;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.util.List;
import java.util.regex.Pattern;

public class AddNewServices {

    public static int addNewServices() {
        System.out.println("--------------------- Furama resort ------------------------");
        System.out.println("1. Add New Villa\n" +
                "2. Add New House\n" +
                "3. Add New Room\n" +
                "4. Back to menu\n" +
                "5. Exit");
        System.out.println("Choose:");
        int choose = GenericMethod.inputNumber();
        switch (choose) {
            case 1:
                addBuilding(GenerateFile.getVillaArray(), "Villa");
                break;
            case 2:
                addBuilding(GenerateFile.getHouseArray(), "House");
                break;
            case 3:
                addBuilding(GenerateFile.getRoomArray(), "Room");
                break;
            case 4:
            case 5:
                break;
        }
        if ((choose == 5) || (choose == 4)) {
        } else choose = addNewServices();
        return choose;
    }

    public static void addBuilding(List<Services> objArray, String name) {
        System.out.println("----------- Add New Service ----------");
        Services building = null;
        /**
         * Khoi Tao Object Villa, House, Room
         */
        building = GenericMethod.genarateObject(name);
        /**
         * Set Id cho Object
         */
        building.setId(GenericMethod.findMaxService(objArray) + 1);

        /**
         * Set Service Code
         */
        System.out.print(name + " Service Code:");
        String codeService;
        while (true) {
            codeService = GenericMethod.inputString();
            if (Regex.checkCodeService(codeService, name)) {
                break;
            } else System.out.println("Yeu cau nhap dung dinh dang " + name + " Service Code!!");
        }
        building.setCodeService(codeService);

        System.out.print(name + " Service Name:");
        String serviceName;
        while (true) {
            serviceName = GenericMethod.inputString();
            if (Regex.checkServiceName(serviceName)) {
                break;
            } else System.out.println("Yeu cau viet hoa chu cai dau tien!!");
        }
        building.setServiceName(serviceName);

        System.out.print(name + " Use Area:");
        double useArea;
        while (true) {
            useArea = GenericMethod.inputNumberDouble();
            if (Regex.checkValue(useArea, 30)) {
                break;
            } else System.out.println("Nhap gia tri lon hon 30!!");
        }
        building.setUseArea(useArea);

        System.out.print(name + " Rental Cost:");
        double rentalCost;
        while (true) {
            rentalCost = GenericMethod.inputNumberDouble();
            if (Regex.checkValue(rentalCost, 0)) {
                break;
            } else System.out.println("Nhap so lon hon 0");
        }
        building.setRentalCost(rentalCost);

        System.out.print(name + " Maximum Person:");
        int maxPerson;
        while (true) {
            maxPerson = GenericMethod.inputNumber();
            if (Regex.checkValueMinMax(maxPerson, 0, 20)) {
                break;
            } else System.out.println("So luong nguoi phai nho hon 20!!!");
        }
        building.setMaximumPerson(maxPerson);

        System.out.print(name + " Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        int inputRentType = GenericMethod.inputNumber();
        building.setInputRentType(inputRentType);

        System.out.print(name + " Accompanied Service:");
        AccompaniedService accompaniedService;
        while (true) {
            accompaniedService = new AccompaniedService(GenericMethod.inputString(), 0, 0);
            if (Regex.checkAccompaniedService(accompaniedService.getName())) {
                break;
            } else System.out.println("Yeu Cau nhap dung dich vu di kem:Massage,Karaoke,Food,Drink,Car");
        }
        building.setAccompaniedService(accompaniedService);

        if ("Villa".equals(name)) {
            addVilla(name, (Villa) building);
        }

        GenericMethod.saveToArray(name,building);
        GenericMethod.convertToFile(name);
    }

    private static void addVilla(String name, Villa building) {
        System.out.print(name + " Pool Area:");
        double villaPoolArea;
        while (true) {
            villaPoolArea = GenericMethod.inputNumberDouble();
            if (Regex.checkValue(villaPoolArea,30)) {
                break;
            } else System.out.println("Nhap gia tri lon hon 30!!");
        }
        building.setPoolArea(villaPoolArea);

        System.out.print(name + " Floors Number:");
        int villaFloorsNumber;
        while (true) {
            villaFloorsNumber =GenericMethod.inputNumber();
            if (Regex.checkValue(villaFloorsNumber,0)) {
                break;
            } else System.out.println("Nhap gia tri lon hon 0!!");
        }
        building.setFloorsNumber(villaFloorsNumber);
    }
}

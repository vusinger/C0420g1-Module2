package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.FileSolution;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.util.List;
import java.util.regex.Pattern;

public class AddNewServices {

    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    final static String PATHHOUSE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/House.csv";
    final static String PATHROOM = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Room.csv";
    static GenerateFile generateFile = new GenerateFile();
    static List<Services> villaArray = generateFile.getVillaArray();
    static List<Services> houseArray = generateFile.getHouseArray();
    static List<Services> roomArray = generateFile.getRoomArray();

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
                addNewServicesArray(villaArray, "Villa");
                break;
            case 2:
                addNewServicesArray(houseArray, "House");
                break;
            case 3:
                addNewServicesArray(roomArray, "Room");
                break;
            case 4:
            case 5:
                break;
        }
        if ((choose == 5) || (choose == 4)) {
        } else choose = addNewServices();
        return choose;
    }

    public static void addNewServicesArray(List<Services> objArray, String name) {
        System.out.println("----------- Add New Service ----------");
        Services obj = null;
        if ("Villa".equals(name)) {
            obj = new Villa();
        } else if ("House".equals(name)) {
            obj = new House();
        } else if ("Room".equals(name)) {
            obj = new Room();
        }

        /**
         * Find Max ID to set ID
         */
        int maxId;
        if (!objArray.isEmpty()) {
            maxId = objArray.get(0).getId();
        } else maxId = 0;
        for (Services objNew : objArray) {
            if (objNew.getId() > maxId) maxId = objNew.getId();
        }
        obj.setId(maxId + 1);

        System.out.print(name + " Service Code:");
        while (true) {
            obj.setCodeService(GenericMethod.inputString());
            if (obj instanceof Villa) {
                if (checkCodeService("SVVL-\\d{4}", obj.getCodeService())) {
                    break;
                } else System.out.println("Yeu Cau Nhap Dung Dinh Dang SVVL-YYYY");
            } else if (obj instanceof House) {
                if (checkCodeService("SVHO-\\d{4}", obj.getCodeService())) {
                    break;
                } else System.out.println("Yeu Cau Nhap Dung Dinh Dang SVHO-YYYY");
            } else if (obj instanceof Room) {
                if (checkCodeService("SVRO-\\d{4}", obj.getCodeService())) {
                    break;
                } else System.out.println("Yeu Cau Nhap Dung Dinh Dang SVRO-YYYY");
            }
        }
        System.out.print(name + " Service Name:");
        while (true) {
            obj.setServiceName(GenericMethod.inputString());
            if (checkCodeService("[A-Z][a-z]+", obj.getServiceName())) {
                break;
            } else System.out.println("Yeu cau viet hoa chu cai dau tien!!");
        }
        System.out.print(name + " Use Area:");
        while (true) {
            obj.setUseArea(GenericMethod.inputNumberDouble());
            if (obj.getUseArea() > 30) {
                break;
            } else System.out.println("Nhap gia tri lon hon 30!!");
        }
        System.out.print(name + " Rental Cost:");
        while (true) {
            obj.setRentalCost(GenericMethod.inputNumberDouble());
            if (obj.getRentalCost() > 0) {
                break;
            } else System.out.println("Nhap so lon hon 0");
        }

        System.out.print(name + " Maximum Person:");
        while (true) {
            obj.setMaximumPerson(GenericMethod.inputNumber());
            if (obj.getMaximumPerson() > 0 && obj.getMaximumPerson() < 20) {
                break;
            } else System.out.println("So luong nguoi phai nho hon 20!!!");
        }

        System.out.print(name + " Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        obj.setInputRentType(GenericMethod.inputNumber());

        System.out.print(name + " Accompanied Service:");
        AccompaniedService objNew;
        while (true) {
            objNew = new AccompaniedService(GenericMethod.inputString(), 0, 0);
            if ("Massage".equals(objNew.getName()) ||
                    "Karaoke".equals(objNew.getName()) ||
                    "Food".equals(objNew.getName()) ||
                    "Drink".equals(objNew.getName()) ||
                    "Car".equals(objNew.getName())) {
                break;
            } else System.out.println("Yeu Cau nhap dung dich vu di kem:Massage,Karaoke,Food,Drink,Car");
        }
        obj.setAccompaniedService(objNew);

        if (obj instanceof Villa) {
            System.out.print(name + " Pool Area:");
            while (true) {
                ((Villa) obj).setPoolArea(GenericMethod.inputNumberDouble());
                if (((Villa) obj).getPoolArea() > 30) {
                    break;
                } else System.out.println("Nhap gia tri lon hon 30!!");
            }

            System.out.print(name + " Floors Number:");
            while (true) {
                ((Villa) obj).setFloorsNumber(GenericMethod.inputNumber());
                if (((Villa) obj).getFloorsNumber() > 0) {
                    break;
                } else System.out.println("Nhap gia tri lon hon 0!!");
            }
            villaArray.add(obj);
            FileSolution<Services> file = new FileSolution<>("Villa.csv", PATHVILLA, villaArray);
            file.convertToFile();
        } else if (obj instanceof House) {
            houseArray.add(obj);
            FileSolution<Services> file = new FileSolution<>("House.csv", PATHHOUSE, houseArray);
            file.convertToFile();
        } else if (obj instanceof Room) {
            roomArray.add(obj);
            FileSolution<Services> file = new FileSolution<>("Room.csv", PATHROOM, roomArray);
            file.convertToFile();
        }
    }

    public static boolean checkCodeService(String regex, String codeService) {
        return Pattern.matches(regex, codeService);
    }
}

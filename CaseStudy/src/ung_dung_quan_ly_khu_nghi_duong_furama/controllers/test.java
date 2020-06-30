package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(Pattern.matches("[a-z0-9_]+@\\w+\\.\\w+",str));
    }
}
//    private static void addNewRoom() {
//        System.out.println("----------- Add New Room ----------");
//        Services room = new Room();
//        System.out.print("Room Villa Id:");
//        room.setId(inputNumber());
//
//        System.out.print("Room Service Code:");
//        while (true) {
//            room.setCodeService(inputString());
//            if (checkCodeService("SVRO-\\d{4}", room.getCodeService())) {
//                break;
//            } else System.out.println("Yeu Cau Nhap Dung Dinh Dang SVRO-YYYY");
//        }
//
//        System.out.print("Room Service Name:");
//        while (true) {
//            room.setServiceName(inputString());
//            if (checkCodeService("[A-Z][a-z]+", room.getServiceName())) {
//                break;
//            } else System.out.println("Yeu cau viet hoa chu cai dau tien!!");
//        }
//
//        System.out.print("Room Use Area:");
//        while (true) {
//            room.setUseArea(inputNumberDouble());
//            if (room.getUseArea() > 30) {
//                break;
//            } else System.out.println("Nhap gia tri lon hon 30!!");
//        }
//
//        System.out.print("Room Rental Cost:");
//        while (true) {
//            room.setRentalCost(inputNumberDouble());
//            if (room.getRentalCost() > 0) {
//                break;
//            } else System.out.println("Nhap so lon hon 0");
//        }
//
//        System.out.print("Room Maximum Person:");
//        while (true) {
//            room.setMaximumPerson(inputNumber());
//            if (room.getMaximumPerson() > 0 && room.getMaximumPerson() < 20) {
//                break;
//            } else System.out.println("So luong nguoi phai nho hon 20!!!");
//        }
//
//        System.out.print("Room Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
//        room.setInputRentType(inputNumber());
//
//        System.out.print("Accompanied Service:");
//        AccompaniedService obj;
//        while (true) {
//            obj = new AccompaniedService(inputString(), 0, 0);
//            if ("Massage".equals(obj.getName()) ||
//                    "Karaoke".equals(obj.getName()) ||
//                    "Food".equals(obj.getName()) ||
//                    "Drink".equals(obj.getName()) ||
//                    "Car".equals(obj.getName())) {
//                break;
//            } else System.out.println("Yeu Cau nhap dung dich vu di kem:Massage,Karaoke,Food,Drink,Car");
//        }
//        room.setAccompaniedService(obj);
//
//
//        roomArray.add(room);
//        convertToFile(PATHROOM, roomArray);
//    }
//
//    private static void addNewHouse() {
//        System.out.println("----------- Add New House ----------");
//        Services house = new House();
//
//        System.out.print("House Id:");
//        house.setId(inputNumber());
//
//        System.out.print("House Service Code:");
//        while (true) {
//            house.setCodeService(inputString());
//            if (checkCodeService("SVHO-\\d{4}", house.getCodeService())) {
//                break;
//            } else System.out.println("Yeu Cau Nhap Dung Dinh Dang SVHO-YYYY");
//        }
//        System.out.print("House Service Name:");
//        while (true) {
//            house.setServiceName(inputString());
//            if (checkCodeService("[A-Z][a-z]+", house.getServiceName())) {
//                break;
//            } else System.out.println("Yeu cau viet hoa chu cai dau tien!!");
//        }
//        System.out.print("House Use Area:");
//        while (true) {
//            house.setUseArea(inputNumberDouble());
//            if (house.getUseArea() > 30) {
//                break;
//            } else System.out.println("Nhap gia tri lon hon 30!!");
//        }
//        System.out.print("House Rental Cost:");
//        while (true) {
//            house.setRentalCost(inputNumberDouble());
//            if (house.getRentalCost() > 0) {
//                break;
//            } else System.out.println("Nhap so lon hon 0");
//        }
//        System.out.print("House Maximum Person:");
//        while (true) {
//            house.setMaximumPerson(inputNumber());
//            if (house.getMaximumPerson() > 0 && house.getMaximumPerson() < 20) {
//                break;
//            } else System.out.println("So luong nguoi phai nho hon 20!!!");
//        }
//        System.out.print("House Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
//        house.setInputRentType(inputNumber());
//
//        System.out.print("Accompanied Service:");
//        AccompaniedService obj;
//        while (true) {
//            obj = new AccompaniedService(inputString(), 0, 0);
//            if ("Massage".equals(obj.getName()) ||
//                    "Karaoke".equals(obj.getName()) ||
//                    "Food".equals(obj.getName()) ||
//                    "Drink".equals(obj.getName()) ||
//                    "Car".equals(obj.getName())) {
//                break;
//            } else System.out.println("Yeu Cau nhap dung dich vu di kem:Massage,Karaoke,Food,Drink,Car");
//        }
//        house.setAccompaniedService(obj);
//
//        houseArray.add(house);
//        convertToFile(PATHHOUSE, houseArray);
//    }
//
//    private static void addNewVilla() {
//        System.out.println("----------- Add New Villa ----------");
//        Services villa = new Villa();
//
//        System.out.print("Villa Id:");
//        villa.setId(inputNumber());
//        System.out.print("Villa Service Code:");
//        while (true) {
//            villa.setCodeService(inputString());
//            if (checkCodeService("SVVL-\\d{4}", villa.getCodeService())) {
//                break;
//            } else System.out.println("Yeu Cau Nhap Dung Dinh Dang SVVL-YYYY");
//        }
//        System.out.print("Villa Service Name:");
//        while (true) {
//            villa.setServiceName(inputString());
//            if (checkCodeService("[A-Z][a-z]+", villa.getServiceName())) {
//                break;
//            } else System.out.println("Yeu cau viet hoa chu cai dau tien!!");
//        }
//        System.out.print("Villa Use Area:");
//        while (true) {
//            villa.setUseArea(inputNumberDouble());
//            if (villa.getUseArea() > 30) {
//                break;
//            } else System.out.println("Nhap gia tri lon hon 30!!");
//        }
//        System.out.print("Villa Rental Cost:");
//        while (true) {
//            villa.setRentalCost(inputNumberDouble());
//            if (villa.getRentalCost() > 0) {
//                break;
//            } else System.out.println("Nhap so lon hon 0");
//        }
//
//        System.out.print("Villa Maximum Person:");
//        while (true) {
//            villa.setMaximumPerson(inputNumber());
//            if (villa.getMaximumPerson() > 0 && villa.getMaximumPerson() < 20) {
//                break;
//            } else System.out.println("So luong nguoi phai nho hon 20!!!");
//        }
//
//        System.out.print("Villa Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
//        villa.setInputRentType(inputNumber());
//
//        System.out.print("Accompanied Service:");
//        AccompaniedService obj;
//        while (true) {
//            obj = new AccompaniedService(inputString(), 0, 0);
//            if ("Massage".equals(obj.getName()) ||
//                    "Karaoke".equals(obj.getName()) ||
//                    "Food".equals(obj.getName()) ||
//                    "Drink".equals(obj.getName()) ||
//                    "Car".equals(obj.getName())) {
//                break;
//            } else System.out.println("Yeu Cau nhap dung dich vu di kem:Massage,Karaoke,Food,Drink,Car");
//        }
//        villa.setAccompaniedService(obj);
//
//        System.out.print("Pool Area:");
//        while (true) {
//            ((Villa) villa).setPoolArea(inputNumberDouble());
//            if (((Villa) villa).getPoolArea() > 30) {
//                break;
//            } else System.out.println("Nhap gia tri lon hon 30!!");
//        }
//
//        System.out.print("Floors Number:");
//        while (true) {
//            ((Villa) villa).setFloorsNumber(inputNumber());
//            if (((Villa) villa).getFloorsNumber() > 0) {
//                break;
//            } else System.out.println("Nhap gia tri lon hon 0!!");
//        }
//
//        villaArray.add(villa);
//        convertToFile(PATHVILLA, villaArray);
//    }

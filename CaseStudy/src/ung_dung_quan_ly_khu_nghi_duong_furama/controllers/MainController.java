package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.models.*;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class MainController {

    final static String PATHVILLA = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Villa.csv";
    static List<Services> villaArray = new ArrayList<>();
    final static String PATHHOUSE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/House.csv";
    static List<Services> houseArray = new ArrayList<>();
    final static String PATHROOM = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Room.csv";
    static List<Services> roomArray = new ArrayList<>();
    final static String PATHCUSTOMER = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Customer.csv";
    static List<Customer> customerArray = new ArrayList<>();
    final static String PATHEMPLOYEE = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Employee.csv";
    static Map<Integer,Employee> employeeArray = new HashMap<>();

    public static void main(String[] args) {
        try {
            GenerateDataFile();
        } catch (IOException e) {
            ResetDataFile();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * Display Menu
         */
        displayMainMenu();
    }

    private static void GenerateDataFile() throws IOException, ClassNotFoundException {
        FileSolution<Services> file1 = new FileSolution<>("Villa.csv", PATHVILLA, villaArray);
        file1.generateFile();
        villaArray = file1.convertData();
        FileSolution<Services> file2 = new FileSolution<>("House.csv", PATHHOUSE, houseArray);
        file2.generateFile();
        houseArray = file2.convertData();
        FileSolution<Services> file3 = new FileSolution<>("Room.csv", PATHROOM, roomArray);
        file3.generateFile();
        roomArray = file3.convertData();
        FileSolution<Customer> file4 = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        file4.generateFile();
        customerArray = file4.convertData();
        FileUltilEmployee file5 = new FileUltilEmployee(PATHEMPLOYEE, employeeArray);
        employeeArray = file5.convertData();
    }

    private static void ResetDataFile() {
        villaArray.clear();
        houseArray.clear();
        roomArray.clear();
        customerArray.clear();
        employeeArray.clear();
        FileSolution<Services> file1 = new FileSolution<>("Villa.csv", PATHVILLA, villaArray);
        file1.convertToFile();
        FileSolution<Services> file2 = new FileSolution<>("House.csv", PATHHOUSE, houseArray);
        file2.convertToFile();
        FileSolution<Services> file3 = new FileSolution<>("Room.csv", PATHROOM, roomArray);
        file3.convertToFile();
        FileSolution<Customer> file4 = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        file4.convertToFile();
        FileUltilEmployee file5 = new FileUltilEmployee( PATHEMPLOYEE, employeeArray);
        file5.convertToFile();
    }

    //  -----------------------------------Generic Method---------------------------------------------

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

    /**
     * Main Method
     *
     * @return
     */

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
                if (addNewBooking() == 5) choose = 7;
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
        Set<Integer> set = employeeArray.keySet();
        for (Integer key : set) {
            System.out.println(employeeArray.get(key).toString());
        }
    }

    //  --------------------------------------------------------------------------------
    private static int addNewBooking() {
        System.out.println("--------------------- Booking Service ------------------------");
        int idRent = 0, idCustomer = 0;
        System.out.print("1. Booking Villa\n" +
                "2. Booking House\n" +
                "3. Booking Room\n" +
                "4. Return Menu\n" +
                "5. Exit\n");
        System.out.println("Choose:");
        int choose = inputNumber();
        if ((choose == 5) || (choose == 4)) {
        } else {
            showInformationCustomers();
            System.out.println("Chon ID Customer:");
            idCustomer = inputNumber();
        }
        switch (choose) {
            case 1:
                showAll(villaArray, "Villa");
                System.out.println("Chon ID Villa:");
                idRent = inputNumber();
                booking("Villa", idCustomer, idRent);
                break;
            case 2:
                showAll(houseArray, "House");
                System.out.println("Chon ID House:");
                idRent = inputNumber();
                booking("House", idCustomer, idRent);
                break;
            case 3:
                showAll(roomArray, "Room");
                System.out.println("Chon ID Room:");
                idRent = inputNumber();
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
        int index1 = 0;
        for (Customer customer : customerArray) {
            if (customer.getId() == idCustomer) break;
            index1++;
        }
        int index2 = 0;
        if ("Villa".equals(name)) {
            for (Services villa : villaArray) {
                if (villa.getId() == idRent) break;
                index2++;
            }
            customerArray.get(index1).setUseService(villaArray.get(index2));
        } else if ("House".equals(name)) {
            for (Services house : houseArray) {
                if (house.getId() == idRent) break;
                index2++;
            }
            customerArray.get(index1).setUseService(houseArray.get(index2));
        } else if ("Room".equals(name)) {
            for (Services room : roomArray) {
                if (room.getId() == idRent) break;
                index2++;
            }
            customerArray.get(index1).setUseService(roomArray.get(index2));
        }

        FileSolution<Customer> fileCustomer = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        fileCustomer.convertToFile();
    }

    //  --------------------------------------------------------------------------------
    private static void showInformationCustomers() {
        System.out.println("-------------------- Show All Customer ---------------------");
        Collections.sort(customerArray, new CustomerComparator());
        for (Customer obj : customerArray) {
            obj.showInfo();
        }
    }

    //  --------------------------------------------------------------------------------
    private static void addNewCustomer() {
        System.out.println("--------------------- Input Customer ------------------------");
        Customer obj = new Customer();
        String str;
        /**
         * Find Max ID to set ID
         */
        int maxId;
        if (!customerArray.isEmpty()) {
            maxId = customerArray.get(0).getId();
        } else maxId = 0;
        for (Customer objNew : customerArray) {
            if (objNew.getId() > maxId) maxId = objNew.getId();
        }
        obj.setId(maxId + 1);

        System.out.println("Input Customer Name:");
        while (true) {
            obj.setName(inputString() + " ");
            if (Pattern.matches("([A-Z][a-z]+\\s+)*", obj.getName())) {
                obj.setName(obj.getName().trim());
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang(VD:Pham Vu)!!!!");
        }

        System.out.println("Input Customer BirthDay:");
        while (true) {
            obj.setBirthDay(inputString());
            if (Pattern.matches("(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19[0-9][0-9]|20[0][012])", obj.getBirthDay())) {
                break;
            } else System.out.println("Nhap Dung Dinh Dang Ngay Sinh dd/mm/yyyy!!");
        }

        System.out.println("Input Customer Gender:");
        while (true) {
            obj.setGender(inputString());
            str = obj.getGender().toLowerCase().trim();
            if ("male".equals(str) || "female".equals(str) ||
                    "unknown".equals(str)) {
                obj.setGender(str.substring(0, 1).toUpperCase() + str.substring(1));
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang(Male/Female/Unknown)!!!!");
        }

        System.out.println("Input Customer IdCard:");
        while (true) {
            obj.setIdCard(inputString());
            if (Pattern.matches("\\d{9}", obj.getIdCard())) {
                break;
            } else System.out.println("CMND phai co 9 chu so!!!");
        }

        System.out.println("Input Customer Phone Number:");
        obj.setPhoneNumber(inputString());

        System.out.println("Input Customer Email:");
        while (true) {
            obj.setEmail(inputString());
            str = obj.getEmail().toLowerCase();
            if (Pattern.matches("[a-z0-9_]+@\\w+\\.\\w+", str)) {
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang EMail(VD:vusinger@gmail.com)!!!!");
        }

        System.out.println("Input Customer Type:");
        obj.setCustomerType(inputString());

        System.out.println("Input Customer Address:");
        obj.setAddress(inputString());

        customerArray.add(obj);
        FileSolution<Customer> fileCustomer = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        fileCustomer.convertToFile();
    }

    /**
     * Show Service method
     *
     * @return
     */

    //  -------------------------------- Show Services ---------------------------------
    private static int showServices() {
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
        int choose = inputNumber();
        switch (choose) {
            case 1:
                showAll(villaArray, "Villa");
                break;
            case 2:
                showAll(houseArray, "House");
                break;
            case 3:
                showAll(roomArray, "Room");
                break;
            case 4:
                showNameNotDuplicate(villaArray, "Villa");
                break;
            case 5:
                showNameNotDuplicate(houseArray, "House");
                break;
            case 6:
                showNameNotDuplicate(roomArray, "Room");
                break;
            case 7:
            case 8:
                break;
        }
        if ((choose == 8) || (choose == 7)) {
        } else choose = showServices();
        return choose;
    }

    //  -------------------------------- Show Name -------------------------------
    private static void showAll(List<Services> objArray, String name) {
        System.out.println("-------------------- Show all " + name + " ---------------------");
        for (Services obj : objArray) {
            if ("Villa".equals(name)) {
                ((Villa) obj).showInfo();
            } else if ("House".equals(name)) {
                ((House) obj).showInfo();
            } else if ("Room".equals(name)) {
                ((Room) obj).showInfo();
            }
        }
    }

    private static void showNameNotDuplicate(List<Services> objArray, String name) {
        System.out.println("-------------------- Show all " + name + " name not duplicate ---------------------");
        Map<String, Services> hashMap = new HashMap<>();
        for (Services obj : objArray) {
            hashMap.put(obj.getServiceName(), obj);
        }
        Set<String> set = hashMap.keySet();
        int index = 0;
        for (String key : set) {
            index++;
            System.out.println(index + ". " + key + " " + name + " ");
        }
        System.out.println();
    }

    /**
     * Add Service Method
     *
     * @return
     */

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

    private static void addNewServicesArray(List<Services> objArray, String name) {
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
            obj.setCodeService(inputString());
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
            obj.setServiceName(inputString());
            if (checkCodeService("[A-Z][a-z]+", obj.getServiceName())) {
                break;
            } else System.out.println("Yeu cau viet hoa chu cai dau tien!!");
        }
        System.out.print(name + " Use Area:");
        while (true) {
            obj.setUseArea(inputNumberDouble());
            if (obj.getUseArea() > 30) {
                break;
            } else System.out.println("Nhap gia tri lon hon 30!!");
        }
        System.out.print(name + " Rental Cost:");
        while (true) {
            obj.setRentalCost(inputNumberDouble());
            if (obj.getRentalCost() > 0) {
                break;
            } else System.out.println("Nhap so lon hon 0");
        }

        System.out.print(name + " Maximum Person:");
        while (true) {
            obj.setMaximumPerson(inputNumber());
            if (obj.getMaximumPerson() > 0 && obj.getMaximumPerson() < 20) {
                break;
            } else System.out.println("So luong nguoi phai nho hon 20!!!");
        }

        System.out.print(name + " Rent Type(1.HourlyRent, 2.DailyRent, 3.MonthlyRent, 4.YearlyRent):");
        obj.setInputRentType(inputNumber());

        System.out.print(name + " Accompanied Service:");
        AccompaniedService objNew;
        while (true) {
            objNew = new AccompaniedService(inputString(), 0, 0);
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
                ((Villa) obj).setPoolArea(inputNumberDouble());
                if (((Villa) obj).getPoolArea() > 30) {
                    break;
                } else System.out.println("Nhap gia tri lon hon 30!!");
            }

            System.out.print(name + " Floors Number:");
            while (true) {
                ((Villa) obj).setFloorsNumber(inputNumber());
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

    //  ------------------------------  Check Regex  ----------------------------------

    private static boolean checkCodeService(String regex, String codeService) {
        return Pattern.matches(regex, codeService);
    }
}

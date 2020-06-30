package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Customer;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.FileSolution;

import java.util.List;
import java.util.regex.Pattern;

public class CustomerManager {

    final static String PATHCUSTOMER = "src/ung_dung_quan_ly_khu_nghi_duong_furama/data/Customer.csv";
    static GenerateFile generateFile = new GenerateFile();
    static List<Customer> customerArray = generateFile.getCustomerArray();

    //  --------------------------------------------------------------------------------
    public static void addNewCustomer() {
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
            obj.setName(GenericMethod.inputString() + " ");
            if (Pattern.matches("([A-Z][a-z]+\\s+)*", obj.getName())) {
                obj.setName(obj.getName().trim());
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang(VD:Pham Vu)!!!!");
        }

        System.out.println("Input Customer BirthDay:");
        while (true) {
            obj.setBirthDay(GenericMethod.inputString());
            if (Pattern.matches("(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19[0-9][0-9]|20[0][012])", obj.getBirthDay())) {
                break;
            } else System.out.println("Nhap Dung Dinh Dang Ngay Sinh dd/mm/yyyy!!");
        }

        System.out.println("Input Customer Gender:");
        while (true) {
            obj.setGender(GenericMethod.inputString());
            str = obj.getGender().toLowerCase().trim();
            if ("male".equals(str) || "female".equals(str) ||
                    "unknown".equals(str)) {
                obj.setGender(str.substring(0, 1).toUpperCase() + str.substring(1));
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang(Male/Female/Unknown)!!!!");
        }

        System.out.println("Input Customer IdCard:");
        while (true) {
            obj.setIdCard(GenericMethod.inputString());
            if (Pattern.matches("\\d{9}", obj.getIdCard())) {
                break;
            } else System.out.println("CMND phai co 9 chu so!!!");
        }

        System.out.println("Input Customer Phone Number:");
        obj.setPhoneNumber(GenericMethod.inputString());

        System.out.println("Input Customer Email:");
        while (true) {
            obj.setEmail(GenericMethod.inputString());
            str = obj.getEmail().toLowerCase().trim();
            if (Pattern.matches("[a-z0-9_]+@\\w+\\.\\w+", str)) {
                obj.setEmail(obj.getEmail().trim());
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang EMail(VD:vusinger@gmail.com)!!!!");
        }

        System.out.println("Input Customer Type:");
        obj.setCustomerType(GenericMethod.inputString());

        System.out.println("Input Customer Address:");
        obj.setAddress(GenericMethod.inputString());

        customerArray.add(obj);
        FileSolution<Customer> fileCustomer = new FileSolution<>("Customer.csv", PATHCUSTOMER, customerArray);
        fileCustomer.convertToFile();
    }
}

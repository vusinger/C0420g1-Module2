package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenerateFile;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.Regex;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Customer;

public class CustomerManager {

    public static void addNewCustomer() {
        System.out.println("--------------------- Input Customer ------------------------");
        Customer customer = new Customer();

        /* Set ID cho Object*/
        customer.setId(GenericMethod.findMax("Customer", GenerateFile.getArray("Customer")) + 1);

        /*Input customer name*/
        /**
         * Check Loop
         */
        System.out.println("Input Customer Name:");
        String customerName = addNewCustomer("CustomerName");
        customer.setName(customerName);

        /*Input customer birthday*/
        /**
         * Check Loop
         */
        System.out.println("Input Customer BirthDay:");
        String customerBirthDay = addNewCustomer("CustomerBirthDay");
        ;
        customer.setBirthDay(customerBirthDay);

        /*Input customer gender*/
        /**
         * Check Loop
         */
        System.out.println("Input Customer Gender:");
        String customerGender = addNewCustomer("CustomerGender");
        customer.setGender(customerGender);

        /*Input customer Id card*/
        /**
         * Check Loop
         */
        System.out.println("Input Customer IdCard:");
        String customerIdCard = addNewCustomer("CustomerIdCard");
        customer.setIdCard(customerIdCard);

        /*Input customer phone number*/
        System.out.println("Input Customer Phone Number:");
        String customerPhoneNumber = GenericMethod.inputString();
        customer.setPhoneNumber(customerPhoneNumber);

        /*Input customer email*/
        /**
         * Check Loop
         */
        System.out.println("Input Customer Email:");
        String customerEmail = addNewCustomer("CustomerEmail");
        customer.setEmail(customerEmail);

        /*Input customer type*/
        System.out.println("Input Customer Type:");
        String customerType = GenericMethod.inputString();
        customer.setCustomerType(customerType);

        /*Input adress*/
        System.out.println("Input Customer Address:");
        String customerAddress = GenericMethod.inputString();
        customer.setAddress(customerAddress);

        /**
         * Save to file and array
         */
        /*Save to file and array*/
        GenericMethod.saveToArray(GenerateFile.getArray("Customer"), customer, "Customer");
        GenericMethod.convertToFile("Customer", GenerateFile.getArray("Customer"));
    }

    private static String addNewCustomer(String name) {
        String input;
        boolean check = false;
        while (true) {
            input = GenericMethod.inputString().trim();
            if ("CustomerName".equals(name)) check = Regex.checkCustomerName(input + " ");
            if ("CustomerBirthDay".equals(name)) check = Regex.checkCustomerBirthDay(input);
            if ("CustomerGender".equals(name)) {
                check = Regex.checkCustomerGender(input.toLowerCase().trim());
                if (check) return input.substring(0, 1).toUpperCase() + input.substring(1);
            }
            if ("CustomerIdCard".equals(name)) check = Regex.checkCustomerIdCard(input);
            if ("CustomerEmail".equals(name)) check = Regex.checkCustomerEmail(input.toLowerCase());
            if (check) break;
        }
        return input.trim();
    }
}

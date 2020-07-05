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
        customer.setId(GenericMethod.findMax("Customer",GenerateFile.getArray("Customer")) + 1);

        /*Input customer name*/
        System.out.println("Input Customer Name:");
        String customerName;
        while (true) {
            customerName = GenericMethod.inputString() + " ";
            if (Regex.checkCustomerName(customerName)) {
                customerName = customerName.trim();
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang(VD:Pham Vu)!!!!");
        }
        customer.setName(customerName);

        /*Input customer birthday*/
        System.out.println("Input Customer BirthDay:");
        String customerBirthDay;
        while (true) {
            customerBirthDay = GenericMethod.inputString();
            if (Regex.checkCustomerBirthDay(customerBirthDay)) {
                break;
            } else System.out.println("Nhap Dung Dinh Dang Ngay Sinh dd/mm/yyyy!!");
        }
        customer.setBirthDay(customerBirthDay);

        /*Input customer gender*/
        System.out.println("Input Customer Gender:");
        String customerGender;
        while (true) {
            customerGender = GenericMethod.inputString().toLowerCase().trim();
            if (Regex.checkCustomerGender(customerGender)) {
                customerGender = customerGender.substring(0, 1).toUpperCase() + customerGender.substring(1);
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang(Male/Female/Unknown)!!!!");
        }
        customer.setGender(customerGender);

        /*Input customer Id card*/
        System.out.println("Input Customer IdCard:");
        String customerIdCard;
        while (true) {
            customerIdCard = GenericMethod.inputString();
            if (Regex.checkCustomerIdCard(customerIdCard)) {
                break;
            } else System.out.println("CMND phai co 9 chu so!!!");
        }
        customer.setIdCard(customerIdCard);

        /*Input customer phone number*/
        System.out.println("Input Customer Phone Number:");
        String customerPhoneNumber = GenericMethod.inputString();
        customer.setPhoneNumber(customerPhoneNumber);

        /*Input customer email*/
        System.out.println("Input Customer Email:");
        String customerEmail;
        while (true) {
            customerEmail = GenericMethod.inputString();
            if (Regex.checkCustomerEmail(customerEmail.toLowerCase().trim())) {
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang EMail(VD:vusinger@gmail.com)!!!!");
        }
        customer.setEmail(customerEmail.trim());

        /*Input customer type*/
        System.out.println("Input Customer Type:");
        String customerType = GenericMethod.inputString();
        customer.setCustomerType(customerType);

        /*Input adress*/
        System.out.println("Input Customer Address:");
        String customerAddress = GenericMethod.inputString();
        customer.setAddress(customerAddress);

        /*Save to file and array*/
        GenericMethod.saveToArray(GenerateFile.getArray("Customer"),customer,"Customer");
        GenericMethod.convertToFile("Customer",GenerateFile.getArray("Customer"));
    }
}

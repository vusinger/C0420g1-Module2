package ung_dung_quan_ly_khu_nghi_duong_furama.controllers;

import ung_dung_quan_ly_khu_nghi_duong_furama.common.GenericMethod;
import ung_dung_quan_ly_khu_nghi_duong_furama.common.Regex;
import ung_dung_quan_ly_khu_nghi_duong_furama.models.Customer;

import java.util.List;

public class CustomerManager {

    public static void addNewCustomer() {
        System.out.println("--------------------- Input Customer ------------------------");
        Customer customer = new Customer();

        /**
         * Set ID cho customer object
         */
        List<Customer> customerArray = GenerateFile.getCustomerArray();
        customer.setId(GenericMethod.findMaxCustomer(customerArray) + 1);

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

        System.out.println("Input Customer BirthDay:");
        String customerBirthDay;
        while (true) {
            customerBirthDay = GenericMethod.inputString();
            if (Regex.checkCustomerBirthDay(customerBirthDay)) {
                break;
            } else System.out.println("Nhap Dung Dinh Dang Ngay Sinh dd/mm/yyyy!!");
        }
        customer.setBirthDay(customerBirthDay);

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

        System.out.println("Input Customer IdCard:");
        String customerIdCard;
        while (true) {
            customerIdCard = GenericMethod.inputString();
            if (Regex.checkCustomerIdCard(customerIdCard)) {
                break;
            } else System.out.println("CMND phai co 9 chu so!!!");
        }
        customer.setIdCard(customerIdCard);

        System.out.println("Input Customer Phone Number:");
        String customerPhoneNumber = GenericMethod.inputString();
        customer.setPhoneNumber(customerPhoneNumber);

        System.out.println("Input Customer Email:");
        String customerEmail;
        while (true) {
            customerEmail = GenericMethod.inputString();
            if (Regex.checkCustomerEmail(customerEmail.toLowerCase().trim())) {
                break;
            } else System.out.println("Can Nhap Dung Dinh Dang EMail(VD:vusinger@gmail.com)!!!!");
        }
        customer.setEmail(customerEmail.trim());

        System.out.println("Input Customer Type:");
        String customerType = GenericMethod.inputString();
        customer.setCustomerType(customerType);

        System.out.println("Input Customer Address:");
        String customerAddress = GenericMethod.inputString();
        customer.setAddress(customerAddress);

        GenericMethod.saveToArray("Customer",customer);
        GenericMethod.convertToFile("Customer");
    }
}

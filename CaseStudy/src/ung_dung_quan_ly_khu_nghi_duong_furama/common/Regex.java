package ung_dung_quan_ly_khu_nghi_duong_furama.common;

import java.util.regex.Pattern;

public class Regex {
    private static final String CODE_SERVICE_VILLA = "SVVL-\\d{4}";
    private static final String CODE_SERVICE_HOUSE = "SVHO-\\d{4}";
    private static final String CODE_SERVICE_ROOM = "SVRO-\\d{4}";
    private static final String SERVICE_NAME = "[A-Z][a-z]+";
    private static final String ACCOMPANIED_SERVICE = "Massage|Karaoke|Food|Drink|Car";
    private static final String CUSTOMER_NAME = "([A-Z][a-z]+\\s+)*";
    private static final String CUSTOMER_GENDER = "male|female|unknown";
    private static final String CUSTOMER_BIRTHDAY = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19[0-9][0-9]|20[0][012])";
    private static final String CUSTOMER_ID_CARD = "\\d{9}";
    private static final String CUSTOMER_EMAIL = "[a-z0-9_]+@\\w+\\.\\w+";

    public static boolean checkCodeService(String inputString, String name) {
        if ("Villa".equals(name)) {
            return Pattern.matches(CODE_SERVICE_VILLA, inputString);
        } else if ("House".equals(name)) {
            return Pattern.matches(CODE_SERVICE_HOUSE, inputString);
        } else if ("Room".equals(name)) {
            return Pattern.matches(CODE_SERVICE_ROOM, inputString);
        }
        return false;
    }

    public static boolean checkServiceName(String inputString) {
        return Pattern.matches(SERVICE_NAME, inputString);
    }

    public static boolean checkValue(double numb, int value) {
        return numb > value;
    }

    public static boolean checkValueMinMax(int numb, int min, int max) {
        return numb > min && numb < max;
    }

    public static boolean checkAccompaniedService(String inputString) {
        return Pattern.matches(ACCOMPANIED_SERVICE, inputString);
    }

    public static boolean checkCustomerName(String inputString) {
        return Pattern.matches(CUSTOMER_NAME, inputString);
    }

    public static boolean checkCustomerGender(String inputString) {
        return Pattern.matches(CUSTOMER_GENDER, inputString);
    }

    public static boolean checkCustomerBirthDay(String inputString) {
        return Pattern.matches(CUSTOMER_BIRTHDAY, inputString);
    }

    public static boolean checkCustomerIdCard(String inputString) {
        return Pattern.matches(CUSTOMER_ID_CARD, inputString);
    }

    public static boolean checkCustomerEmail(String inputString) {
        return Pattern.matches(CUSTOMER_EMAIL, inputString);
    }
}


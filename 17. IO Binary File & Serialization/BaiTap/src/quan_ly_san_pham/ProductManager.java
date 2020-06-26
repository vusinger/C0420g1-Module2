package quan_ly_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    static final String PATH = "src/content/ProductData.csv";
    static List<Product> dataProduct = new ArrayList<>();

    public static void main(String[] args) {
        int choose = 0;
        while (choose != 2) {
            System.out.println();
            System.out.println("-----------------Product Manager Program-----------------");
            System.out.println("1.Menu");
            System.out.println("2.Exit");
            System.out.print("Choose:");
            choose = numberInput();
            if (choose == 1) {
                try {
                    khoiTaoFileData();
                    convertData();
                    if (showMenu() == 6) break;
                } catch (IOException | ClassNotFoundException e) {
                    dataProduct.clear();
                    convertToFile();
                    System.out.println("IOException | ClassNotFoundException");
                    break;
                }
            }
        }
    }

    //--------------------------------------------
    private static int numberInput() {
        Scanner scn = new Scanner(System.in);
        int num = 0;
        while (true) {
            String inputString = scn.nextLine();
            try {
                num = Integer.parseInt(inputString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang so");
            }
        }
        return num;
    }

    private static String stringInput() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    //  ---------------------------------------------------------
    private static void khoiTaoFileData() throws IOException {
        File dir = new File("src/content");
        dir.mkdir();
        File file = new File("src/content", "ProductData.csv");
        if (!file.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dataProduct);
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    //  -------------------------------------------------------------
    private static int showMenu() throws IOException {
        System.out.println();
        System.out.println("-----------------Product Manager Program-----------------");
        System.out.println("1.Add product");
        System.out.println("2.Show product");
        System.out.println("3.Find product");
        System.out.println("4.Remove product");
        System.out.println("5.Return menu");
        System.out.println("6.Exit");
        System.out.print("Choose:");
        int choose = numberInput();
        switch (choose) {
            case 1:
                addProduct();
                choose = showMenu();
                break;
            case 2:
                showProduct();
                choose = showMenu();
                break;
            case 3:
                findProduct();
                choose = showMenu();
                break;
            case 4:
                removeProduct();
                choose = showMenu();
                break;
            default:
                break;
        }
        return choose;
    }

    //  ------------------------------------------------------------
    private static void convertData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        dataProduct = (List<Product>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
    }

    private static void convertToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dataProduct);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  ----------------------------------------------------------
    private static void removeProduct() throws IOException {
        System.out.println("Input Product ID To Remove:");
        int productID = numberInput();
        int index = 0;
        boolean check = false;
        for (Product obj : dataProduct) {
            if (obj.getProductId() == productID) {
                check = true;
                break;
            }
            index++;
        }
        if (check){
            dataProduct.remove(index);
            convertToFile();
        } else {
            System.out.println("San Pham Ban Nhap Khong Co!!!");
        }
    }

    //  ------------------------------------------------------------
    private static void findProduct() {
        System.out.println("Find Name Product:");
        String productName = stringInput();
        int index = 0;
        boolean check = false;
        for (Product obj:dataProduct) {
            if (obj.getProductName().equals(productName)) {
                check = true;
                break;
            }
            index++;
        }
        if (check) {
            System.out.println(dataProduct.get(index));
        } else {
            System.out.println("San pham ban tim khong thay!!!");
        }
    }

    //  --------------------------------------------------------------
    private static void showProduct() {
        System.out.println("----------------List Product----------------");
        for (Product obj : dataProduct) {
            System.out.println(obj.toString());
        }
    }

    //  ------------------------------------------------------------------------
    private static void addProduct() throws IOException {
        FileOutputStream file = new FileOutputStream(PATH);
        ObjectOutputStream osi = new ObjectOutputStream(file);
        String choose = "yes";
        Product obj;
        while (!"no".equals(choose)) {
            obj = new Product();
            System.out.print("Input Product ID:");
            obj.setProductId(numberInput());
            System.out.print("Input Product Name:");
            obj.setProductName(stringInput());
            System.out.print("Input Product Maker:");
            obj.setProductMaker(stringInput());
            System.out.print("Input Product Cost:");
            obj.setProductCost(stringInput());
            dataProduct.add(obj);
            System.out.println("Do you want to continue input product??(yes/no)");
            choose = stringInput();
        }
        osi.writeObject(dataProduct);
        osi.close();
        file.close();
    }
//  ----------------------------------------------------------------------
}

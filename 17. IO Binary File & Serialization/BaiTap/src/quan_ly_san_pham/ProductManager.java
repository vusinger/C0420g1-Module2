package quan_ly_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static final String PATH = "src/content/ProductData.csv";
    static List<Product> dataProduct = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        while (choose != 2) {
            System.out.println();
            System.out.println("-----------------Product Manager Program-----------------");
            System.out.println("1.Menu");
            System.out.println("2.Exit");
            System.out.print("Choose:");
            choose = sc.nextInt();
            if (choose == 1) {
                try {
                    khoiTaoFileData();
                    convertData();
                    if (showMenu() == 6) break;
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void khoiTaoFileData() throws IOException {
        File dir = new File("src/content");
        dir.mkdir();
        File file = new File("src/content","ProductData.csv");
        if (!file.exists()) {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dataProduct);
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    private static int showMenu() throws IOException, ClassNotFoundException {
        System.out.println();
        System.out.println("-----------------Product Manager Program-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add product");
        System.out.println("2.Show product");
        System.out.println("3.Find product");
        System.out.println("4.Remove product");
        System.out.println("5.Return menu");
        System.out.println("6.Exit");
        System.out.print("Choose:");
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                showProduct();
                break;
            case 3:
                findProduct();
                break;
            case 4:
                removeProduct();
                break;
            default:
                break;
        }
        return choose;
    }

    private static void convertData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        dataProduct = (List<Product>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
    }

    private static void convertToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dataProduct);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    private static void removeProduct() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Product ID To Remove:");
        int productID = sc.nextInt();
        int index = 0;
        for (Product obj:dataProduct) {
            if (obj.getProductId()== productID) {
                break;
            }
            index++;
        }
        dataProduct.remove(index);
        convertToFile();
    }

    private static void findProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Find Name Product:");
        String productName = sc.nextLine();
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

    private static void showProduct() throws IOException, ClassNotFoundException {
        System.out.println("----------------List Product----------------");
        for (Product obj : dataProduct) {
            System.out.println(obj.toString());
        }
    }

    private static void addProduct() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        FileOutputStream file = new FileOutputStream(PATH);
        ObjectOutputStream osi = new ObjectOutputStream(file);
        String choose = "yes";
        Product obj = new Product();
        while(!"no".equals(choose)) {
            obj = new Product();
            System.out.print("Input Product ID:");
            obj.setProductId(sc.nextInt());
            sc.nextLine();
            System.out.print("Input Product Name:");
            obj.setProductName(sc.nextLine());
            System.out.print("Input Product Maker:");
            obj.setProductMaker(sc.nextLine());
            System.out.print("Input Product Cost:");
            obj.setProductCost(sc.nextLine());
            dataProduct.add(obj);
            System.out.println("Do you want to continue input product??(yes/no)");
            choose = sc.nextLine();
        }
        osi.writeObject(dataProduct);
        osi.close();
        file.close();
    }
}

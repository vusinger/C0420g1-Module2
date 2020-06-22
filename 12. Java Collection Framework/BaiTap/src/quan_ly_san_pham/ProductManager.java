package quan_ly_san_pham;

import java.util.*;

public class ProductManager {
    static Map<Integer,Product> prdArray = new HashMap<>();
    public static void main(String[] args) {
//        ------------------- Menu ------------------------
        Scanner sc = new Scanner(System.in);
        int input;
        while(true) {
            System.out.println("------------------Menu-------------------");
            System.out.println("1.Them San Pham.");
            System.out.println("2.Chinh Sua San Pham Theo ID.");
            System.out.println("3.Xoa San Pham Theo ID.");
            System.out.println("4.Hien Thi San Pham Theo ID.");
            System.out.println("5.Tim Kiem San Pham Theo Ten.");
            System.out.println("6.Sap Xep San Pham Theo Gia.");
            System.out.println("7.break.");
            System.out.print("Choose :");
//            ----------------------------
            input = sc.nextInt();
            if (input==7) break;
            switch (input) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showProduct();
                    break;
                case 5:
                    findProduct();
                    break;
                case 6:
                    sortProduct();
                    break;
                case 7:
                    break;
            }
//            -------------------------
        }
//        --------------------------Menu End-------------------------------
    }

    private static void showProduct() {
        System.out.println("-----------Show Product-----------------");
        Product obj;
        for (Integer i : prdArray.keySet()) {
            obj = prdArray.get(i);
            System.out.println(obj.id+". Product Name:"+obj.productName+" - Cost:"+obj.cost+"USD");
        }
        System.out.println();
    }

    private static void sortProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sap xep tang hay giam(true/false)");
        boolean check = sc.nextBoolean();
        Product obj;
        List<Product> arrayList = new ArrayList<>();
        for (Integer i : prdArray.keySet()) {
            obj = prdArray.get(i);
            arrayList.add(obj);
        }
        if (check) {
            Collections.sort(arrayList,new SortProduct());
        } else {
            Collections.sort(arrayList,new SortProduct2());
        }
        prdArray.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            obj = arrayList.get(i);
            prdArray.put(i,obj);
        }
    }

    private static void findProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Nhap ten san pham:");
        String productName = sc.nextLine();
        Product obj;
        for (Integer i : prdArray.keySet()) {
            obj = prdArray.get(i);
            if (obj.productName.equals(productName)){
                System.out.println(obj.id+". Product Name:"+obj.productName+" - Cost:"+obj.cost+"USD");
            }
        }
    }

    private static void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Nhap id san pham:");
        int id = sc.nextInt();
        prdArray.remove(id);
    }

    private static void editProduct() {
        Scanner sc = new Scanner(System.in);
        Product prd = new Product();
        boolean check = false;
        System.out.println("---------------------------------");
        System.out.println("Nhap id san pham:");
        if (sc.hasNextInt()) {
            prd.id = sc.nextInt();
            check = true;
        }
        sc.nextLine();
        System.out.println("Nhap name san pham:");
        prd.productName = sc.nextLine();
        System.out.println("Nhap gia san pham:");
        if (sc.hasNextInt()) {
            prd.cost = sc.nextInt();
            check = true;
        }
        if (check) {
            prdArray.put(prd.id,prd);
        }
    }

    private static void addProduct() {
        Scanner sc = new Scanner(System.in);
        Product prd = new Product();
        boolean check = true;
        System.out.println("---------------------------------");
        System.out.println("Nhap id san pham:");
        if (sc.hasNextInt()) {
            prd.id = sc.nextInt();
        } else check = false;
        sc.nextLine();
        System.out.println("Nhap name san pham:");
        prd.productName = sc.nextLine();
        System.out.println("Nhap gia san pham:");
        if (sc.hasNextInt()) {
            prd.cost = sc.nextInt();
        } else check = false;
        if (check) {
            prdArray.put(prd.id,prd);
        }
    }
}

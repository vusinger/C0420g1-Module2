package post_oder_duyet_cay_va_xoa_cay;

public class PostOrderBinaryTree {
    public static void main(String[] args) {
        BinaryTree<String> stringBinaryTree = new BinaryTree<>();
        stringBinaryTree.add("Karik");
        stringBinaryTree.add("Adame");
        stringBinaryTree.add("Eva");
        stringBinaryTree.add("Smith");
        stringBinaryTree.add("Samatha");
        stringBinaryTree.add("Emily");
        stringBinaryTree.add("Linda");
        stringBinaryTree.add("John");
        stringBinaryTree.add("Micheal");
        stringBinaryTree.add("Grey");
        stringBinaryTree.add("Floy");
        stringBinaryTree.add("Kathy");
        stringBinaryTree.showPostOrder();
        System.out.println("---------------------------------------");
        stringBinaryTree.addNew("55");
        stringBinaryTree.addNew("50");
        stringBinaryTree.addNew("60");
        stringBinaryTree.addNew("80");
        stringBinaryTree.addNew("35");
        stringBinaryTree.addNew("25");
        stringBinaryTree.addNew("75");
        stringBinaryTree.addNew("15");
        stringBinaryTree.addNew("40");
        stringBinaryTree.addNew("38");
        stringBinaryTree.addNew("65");
        stringBinaryTree.addNew("43");
        stringBinaryTree.showPostOrder();
        System.out.println("---------------------------------------");
        stringBinaryTree.delete("80");
        stringBinaryTree.showPostOrder();
        System.out.println("So luong phan tu :"+stringBinaryTree.size());
    }
}

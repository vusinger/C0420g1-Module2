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
        stringBinaryTree.deleteNew("Karik");
        stringBinaryTree.deleteNew("Adame");
        stringBinaryTree.deleteNew("Eva");
        stringBinaryTree.deleteNew("Smith");
        stringBinaryTree.deleteNew("Samatha");
        stringBinaryTree.deleteNew("Emily");
        stringBinaryTree.deleteNew("Linda");
        stringBinaryTree.deleteNew("John");
        stringBinaryTree.deleteNew("Micheal");
        stringBinaryTree.deleteNew("Grey");
        stringBinaryTree.deleteNew("Floy");
        stringBinaryTree.deleteNew("Kathy");
        stringBinaryTree.showPostOrder();
        System.out.println("So luong phan tu :"+stringBinaryTree.size());
    }
}

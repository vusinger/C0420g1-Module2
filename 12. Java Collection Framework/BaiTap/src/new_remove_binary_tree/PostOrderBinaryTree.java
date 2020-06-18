package new_remove_binary_tree;

public class PostOrderBinaryTree {
    public static void main(String[] args) {
        BinaryTree<String> stringBinaryTree = new BinaryTree<>();
        stringBinaryTree.add("Adam");
        stringBinaryTree.add("Eve");
        stringBinaryTree.add("Susan");
        stringBinaryTree.add("Karik");
        stringBinaryTree.add("Smith");
        stringBinaryTree.add("Micheal");
        stringBinaryTree.showPostOrder();
        stringBinaryTree.remove("Karik");
    }
}

package remove_node_binary_tree;

import post_oder_duyet_cay.BinaryTree;

public class Test_Remove_Tree {
    public static void main(String[] args) {
        BinaryTree<String> stringBinaryTree = new BinaryRemoveTree<>();
        stringBinaryTree.add("Adam");
        stringBinaryTree.add("Eve");
        stringBinaryTree.add("Susan");
        stringBinaryTree.add("Karik");
        stringBinaryTree.add("Smith");
        stringBinaryTree.add("Micheal");
        ((BinaryRemoveTree)stringBinaryTree).remove("Karik");
        stringBinaryTree.showPostOrder();
    }
}

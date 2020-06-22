package cay_nhi_phan;

public class BinaryTree<E extends Comparable<E>>{
    class Node {
        private E element;
        private Node left;
        private Node right;

        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }
//    ------------------Add---------------------
    public void add(E e) {
        if (e!=null) {
            this.root = add(root,e);
            this.size++;
        }
    }
    private Node add(Node root,E e) {
        if (root==null) {
            return new Node(e);
        }
        if (e.compareTo(root.element)<0) {
            root.left = add(root.left,e);
        } else if (e.compareTo(root.element)>0) {
            root.right = add(root.right,e);
        } else {
//            root.element = e;
            this.size--;
        }
        return root;
    }
//    --------------------Show------------------------
    public void show() {
        show(root);
    }
    public void show(Node root) {
        if (root==null) {
            return;
        }
        if (root.left!=null) {
            show(root.left);
        }
        System.out.println(root.element.toString());
        if (root.right!=null) {
            show(root.right);
        }
    }
//    ------------------ Size ---------------------
    public int size() {
        return this.size;
    }
//    ------------------Searching------------------
    public boolean search(E e) {
        return search(root,e);
    }

    private boolean search(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.element)<0) {
            search(root.left,e);
        }else if (e.compareTo(root.element)>0) {
            search(root.right,e);
        } else{
            return true;
        }
        return false;
    }
}

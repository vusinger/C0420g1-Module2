package cay_nhi_phan;

public class BinaryTreeSearch {
    public static void main(String[] args) {
        Student a1 = new Student(11,"Huy");
        Student a2 = new Student(25,"Minh");
        Student a3 = new Student(12,"Duy");
        Student a4 = new Student(22,"Duy");
        Student a5 = new Student(64,"Hoang");
        Student a6 = new Student(6,"Duy");
        Student a7 = new Student(7,"Duy");
        Student a8 = new Student(8,"Duy");
        Student a9 = new Student(55,"Hoang");
        BinaryTree<Student> studentBinaryTree = new BinaryTree<>();
        studentBinaryTree.add(a2);
        studentBinaryTree.add(a2);
        studentBinaryTree.add(a3);
        studentBinaryTree.add(a4);
        studentBinaryTree.add(a5);
        studentBinaryTree.add(a6);
        studentBinaryTree.add(a7);
        studentBinaryTree.add(a8);
        studentBinaryTree.add(a9);
        studentBinaryTree.show();
        System.out.println(studentBinaryTree.size());
        System.out.println("Phan tu a1 co trong mang:"+studentBinaryTree.search(a1));
    }
}

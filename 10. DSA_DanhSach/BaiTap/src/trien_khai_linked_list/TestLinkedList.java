package trien_khai_linked_list;

public class TestLinkedList {
    static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        MyLinkedList<Student> studentMyLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"Huyn");
        Student student2 = new Student(2,"Khan");
        Student student3 = new Student(3,"John");
        Student student4 = new Student(4,"Pete");
        Student student5 = new Student(5,"Jorn");

        studentMyLinkedList.addFirst(student5);
        studentMyLinkedList.addFirst(student4);
        studentMyLinkedList.addFirst(student3);
        studentMyLinkedList.addFirst(student2);
        studentMyLinkedList.addFirst(student1);
        studentMyLinkedList.remove(3);
        for (int i = 0; i < studentMyLinkedList.size(); i++) {
            Student student = (Student)studentMyLinkedList.get(i);
            System.out.print(student.getId()+" ");
            System.out.println(student.getName());
        }
    }
}

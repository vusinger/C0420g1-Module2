package TrienKhaiPhuongThucArrayList;

import java.util.ArrayList;
import java.util.List;

public class MyListTest {
    public static class Student {
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
        Student a = new Student(1,"John");
        Student b = new Student(2,"Huyn");
        Student c = new Student(3,"Khan");
        Student d = new Student(4,"Lopn");
        Student e = new Student(5,"Forn");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);

//        for (Object student:studentMyArrayList.elements) {
//            if (student instanceof Student) {
//                Student student1 = (Student)student;
//                System.out.println(student1.getId());
//                System.out.println(student1.getName());
//            }
//        }
//        System.out.println(studentMyArrayList.indexOf(c));

        MyArrayList<Student> newArrayList = new MyArrayList<>();
        newArrayList = studentMyArrayList.clone();
        newArrayList.remove(1);
        for (Object student:newArrayList.elements) {
            if (student instanceof Student) {
                Student student1 = (Student)student;
                System.out.println(student1.getId());
                System.out.println(student1.getName());
            }
        }
//        List<Student> test = new ArrayList<>();
//        test.add(a);
//        test.add(b);
//        test.add(c);
//        for (Student student:test) {
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//        }

    }
}

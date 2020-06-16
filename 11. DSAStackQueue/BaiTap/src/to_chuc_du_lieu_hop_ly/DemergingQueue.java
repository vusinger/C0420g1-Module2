package to_chuc_du_lieu_hop_ly;

import java.util.LinkedList;
import java.util.Queue;

public class DemergingQueue {
    public static void main(String[] args) {
        Queue<Student> male = new LinkedList<>();
        Queue<Student> female = new LinkedList<>();
        int size = 5;
        Student[] profile = new Student[size];
//        ----------------------------------------
        profile[0] = new Student("Huy","Male","23/05/1990");
        profile[1] = new Student("Duong","Male","21/02/1990");
        profile[2] = new Student("Nhung","Female","13/04/1990");
        profile[3] = new Student("Minh","Male","25/12/1990");
        profile[4] = new Student("Linh","Female","19/05/1990");
//        ---------------------------------------
        for (int i = 0; i < size; i++) {
            if (profile[i].getGender().equals("Male")) {
                male.add(profile[i]);
            } else if (profile[i].getGender().equals("Female")) {
                female.add(profile[i]);
            }
        }
//        ---------------------------------------
        while(!female.isEmpty()){
            System.out.println(female.remove().toString());
        }
        while(!male.isEmpty()){
            System.out.println(male.remove().toString());
        }
    }
}

package sap_xep_voi_comparable_comparator.SelfLearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortWithComparable {
    public static void main(String[] args) {
        User newUsers1 = new User("Huy","abc");
        User newUsers2 = new User("Huy","xyz");
        User newUsers3 = new User("Huy","cba");
        User newUsers4 = new User("Cong","abc");
        User newUsers5 = new User("Cuong","abc");
        List<User> userList = new ArrayList<>();
        userList.add(newUsers1);
        userList.add(newUsers3);
        userList.add(newUsers4);
        userList.add(newUsers5);
        userList.add(newUsers2);
        Collections.sort(userList,new UserComparator());
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getUserName()+" "+userList.get(i).getPassWord());
        }
    }
}

package sap_xep_voi_comparable_comparator.SelfLearning;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getUserName().equals(o2.getUserName())) {
            return o1.getPassWord().compareTo(o2.getPassWord());
        }
        return o1.getUserName().compareTo(o2.getUserName());
    }
}

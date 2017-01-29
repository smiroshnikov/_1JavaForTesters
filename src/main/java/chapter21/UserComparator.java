package chapter21;

import javafortesters.chapter15.practice.User;

import java.util.Comparator;

public class UserComparator implements Comparator {

    @Override
    public int compare(Object oUser1, Object oUser2) {
        User user1 = (User) oUser1; // casting from object to User !
        User user2 = (User) oUser2;
        int userComparator1 = user1.getPassword().length() +
                user1.getUsername().length();
        int userComparator2 = user1.getPassword().length() +
                user1.getUsername().length();
        int val = userComparator1 - userComparator2;
        if (val == 0) {
            val = user1.getUsername().compareTo(user2.getUsername());
        }

        return val;
    }
}



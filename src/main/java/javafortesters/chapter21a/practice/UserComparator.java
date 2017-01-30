package javafortesters.chapter21a.practice;

import java.util.Comparator;

public class UserComparator implements Comparator {

    @Override
    public int compare(Object oUser1, Object oUser2) {
        javafortesters.chapter21a.practice.User user1 = (javafortesters.chapter21a.practice.User) oUser1; // casting from object to SimpleUser !
        javafortesters.chapter21a.practice.User user2 = (javafortesters.chapter21a.practice.User) oUser2; // casting from object to SimpleUser !
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



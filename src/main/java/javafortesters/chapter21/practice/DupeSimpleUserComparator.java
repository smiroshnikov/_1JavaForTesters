package javafortesters.chapter21.practice;

import java.util.Comparator;

public class DupeSimpleUserComparator implements Comparator {

    @Override
    public int compare(Object userObj1, Object userObj2) {
        SimpleUser u1 = (SimpleUser) userObj1;
        SimpleUser u2 = (SimpleUser) userObj2;
        int user1Comparator = u1.getUsername().length() + u1.getPassword().length();
        int user2Comparator = u2.getUsername().length() + u2.getPassword().length();

        if (u1.getUsername().equals(u2.getUsername())) {
            return 0;
        }
        int val = user1Comparator - user2Comparator;
        if (val == 0) {
            val = ((SimpleUser) userObj1).getUsername().compareTo(((SimpleUser) userObj2).getUsername());
        }
        return val;
    }

}

package javafortesters.chapter21.practice;

import java.util.Comparator;

public class SimpleUserComparator implements Comparator {

    @Override
    public int compare(Object simpleU1, Object simpleU2) {
        SimpleUser u1 = (SimpleUser) simpleU1;
        SimpleUser u2 = (SimpleUser) simpleU2;
        int user1Comparator = u1.getUsername().length() + u1.getPassword().length();
        int user2Comparator = u2.getUsername().length() + u2.getPassword().length();
        int val = user1Comparator - user2Comparator;
        // if this check is commented out and I have users with same name length and same password length
        // the second user is concidered duplicate and sortedSet does not allow duplicates
        // TODO  test with larger collection of Simple Users , pick 2 SimpleUsers with 3 chars in name etc...
        if (val == 0) {
            val = u1.getUsername().compareTo(u2.getUsername());
        }
        System.out.println("Compare " + u1.getUsername() + " with " +
                u2.getUsername() + " = " + val);
        return val;
    }
}

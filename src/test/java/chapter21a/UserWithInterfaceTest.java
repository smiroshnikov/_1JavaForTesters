package chapter21a;

import javafortesters.chapter21a.practice.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;


public class UserWithInterfaceTest {
    @Test
    public void sortedSetWithUserWithoutDup() {
        User bob = new User("bob", "stroitel'");
        User duplbob = new User("bob", "stroitel'");
        User duplbob2 = new User("bob", "stroitel'");
        User kek = new User("kekk", "stroitel'");
        User mrBeer = new User("Stafford", "stroitel'");
        // no warning when compareTo is present in the class
        SortedSet<User> userSet = new TreeSet<>();
        userSet.add(bob);
        userSet.add(duplbob);
        userSet.add(kek);
        userSet.add(mrBeer);
        userSet.add(duplbob2);
        User[] users = new User[userSet.size()];
        userSet.toArray(users);
        for (User u :
                userSet) {
            System.out.println(u.getUsername());
        }
        assertThat(bob.getUsername(), is(users[0].getUsername()));
        assertEquals(bob.getUsername(), users[0].getUsername());


    }

    @Test
    public void sortedMapExample() {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        map.put("key6", "value6");
        map.put("key7", "value7");
        assertThat(map.firstKey(), is("key1"));
        assertThat(map.lastKey(), is("key7"));
        SortedMap<String, String> headmap;
        headmap = map.headMap("sdf");
        for (Map.Entry<String, String> e :
                map.entrySet()) {
            System.out.printf("key -> %s , %s <--value  %n", e.getKey(), e.getValue());
        }


    }

    @Test
    public void userSortedMap() {

        // TODO how to iterate over SortedSet

        User bob = new User("bob", "123456");
        User cob = new User("cob", "123456");
        User dob = new User("vob", "123456");

        SortedMap<User, String> userMap = new TreeMap<>(new javafortesters.chapter21a.practice.UserComparator());

        userMap.put(bob, "Great book of Bob");
        userMap.put(cob, "Mutilating for dummies ");
        userMap.put(dob, "How to become radical fanatic in 24 days");

        for (Map.Entry<User, String> entry :
                userMap.entrySet()) {
            System.out.println("Author -> " + entry.getKey().getUsername().toUpperCase() + " book " + entry.getValue());
        }

        Set<User> userSetFromUserMap = new TreeSet<>(userMap.keySet());

        System.out.println(userSetFromUserMap.size());

        User[] userArray = new User[userSetFromUserMap.size()];

        userSetFromUserMap.toArray(userArray);
        // NullPointerException Why ? Arrays is not empty
        // because I forgot to populate userArray

        for (User u :
                userArray) {
            System.out.println(u.getUsername());
        }
    }
}

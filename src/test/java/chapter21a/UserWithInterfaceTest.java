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
}

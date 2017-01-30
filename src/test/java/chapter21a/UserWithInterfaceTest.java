package chapter21a;

import javafortesters.chapter21a.practice.User;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by Iidwuurliik on 1/30/2017.
 */
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
}

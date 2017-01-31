package javaForTesters.chapter6;

import javafortesters.chapter6.practice.OpenUser;
import javafortesters.chapter6.practice.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class UserTest {
    //TODO MAYBE A BETTER LOOK AT  canConstructANewUser?

    @Test
    public void canConstructANewUser() {
        User user = new User();
        OpenUser openUser = new OpenUser();
        openUser.username = "Bob";

        User admin = new User("admin", "pA55w0rD");
        assertEquals("not default username", "Bob", openUser.username);
        assertEquals("default username is expected", "username", user.getUsername());
        assertEquals("default password is expected", "password", user.getPassword());
        assertEquals("Admin details are incorrect", "admin", admin.getUsername());
        assertEquals("Admin details are incorrect", "pA55w0rD", admin.getPassword());
        user.setPassword("PaZZwor6");
        assertEquals("setter password expected", "PaZZwor6", user.getPassword());
        //assertEquals("New password too short" , user.MINIMAL_PASSWORD_LENGTH , user.getPassword().length());
        //static member accessed via instance reference - line above means it is possible to access MINIMAL_PASSWORD_LENGTH
        //without instantiating a user class , hence it is static and final
        user.setPassword("12345678912453");
        assertFalse("password too short", user.getPassword().length() < User.MINIMAL_PASSWORD_LENGTH);
        assertFalse("password too long", user.getPassword().length() > User.MAXIMUM_PASSWORD_LENGTH);
        // pop message if false
        //assertTrue("password too long", user.getPassword().length() > SimpleUser.MAXIMUM_PASSWORD_LENGTH);
        // pop message if true
    }

    @Test
    public void validateUsersAndPasswords() {
        User[] users;
        // initialize Random once not per test , per class make it final and static as well !
        Random r = new Random();
        int randomSeed = r.nextInt(100000);

        //users = SimpleUser.createUsers(new Random().nextInt(10000));

        users = User.createUsers(randomSeed);

        //System.out.printf("debug message --> created array of [%d] users <--debug message%n ", users.length);

        assertTrue("Invalid array length !", users.length == randomSeed);
        for (int i = 0; i < users.length; i++) {
            assertEquals("Incorrect username !", "username" + (i + 1), users[i].getUsername());
            assertEquals("Incorrect password !", "password" + (i + 1), users[i].getPassword());
        }
    }

    @Test
    public void arrayMethods() {
        String[] workdays = {"SUN", "MON", "TUE"};
        String[] weekdays = Arrays.copyOf(workdays, 29);
        for (String day : weekdays) {
            System.out.printf("%s%n", day);
        }
        assertEquals(null, weekdays[5]);
        int[] minusOne = new int[30];
        Arrays.fill(minusOne, 12, 25, -1);
        int[] justABunchOfNumbers = {1, 21, 2, 33, 46, 12, -9, 323, 5, 6456, 6, 7, 8, 9, 23, 90, 23, 1, -345, -345567, -5, 6, -8};
        Arrays.sort(justABunchOfNumbers);
        for (int number :
                justABunchOfNumbers) {
            System.out.printf("%d%n", number);

        }


    }

    @Test
    public void sortWorkdays() {
        String[] workdays = {"monday", "Tuesday", "Wednesday", "Thursday",
                "Friday"};
        Arrays.sort(workdays);
        assertEquals(workdays[0], "Friday");
        assertEquals(workdays[4], "Wednesday");
        for (String day :
                workdays) {
            System.out.printf(day);
        }
    }
}
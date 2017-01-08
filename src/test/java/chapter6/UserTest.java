package chapter6;

import javafortesters.chapter6.practice.OpenUser;
import javafortesters.chapter6.practice.User;
import org.junit.Test;

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
        //assertTrue("password too long", user.getPassword().length() > User.MAXIMUM_PASSWORD_LENGTH);
        // pop message if true
    }

    @Test
    public void validateUsersAndPasswords() {
        User[] users;
        // initialize Random once not per test , per class make it final and static as well !
        Random r = new Random();
        int randomSeed = r.nextInt(100000);

        //users = User.createUsers(new Random().nextInt(10000));

        users = User.createUsers(randomSeed);

        //System.out.printf("debug message --> created array of [%d] users <--debug message%n ", users.length);

        assertTrue("Invalid array length !", users.length == randomSeed);
        for (int i = 0; i < users.length; i++) {
            assertEquals("Incorrect username !", "username" + (i + 1), users[i].getUsername());
            assertEquals("Incorrect password !", "password" + (i + 1), users[i].getPassword());
        }
    }
}
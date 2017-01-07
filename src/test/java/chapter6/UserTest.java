package chapter6;

import javafortesters.chapter6.practice.OpenUser;
import javafortesters.chapter6.practice.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
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
        assertEquals("New password too short", User.MINIMAL_PASSWORD_LENGTH, user.getPassword().length());
        user.setPassword("123456789");


    }
}
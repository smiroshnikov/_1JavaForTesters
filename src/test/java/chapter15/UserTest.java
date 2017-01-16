package chapter15;

// TODO redo all user assignments
// TODO this is interview candidate

import javafortesters.chapter15.practice.AdminUser;
import javafortesters.chapter15.practice.ReadOnlyUser;
import javafortesters.chapter15.practice.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void createDefaultUser() {
        User u = new User();
        assertEquals("username", u.getUsername());
        assertEquals("password", u.getPassword());
        assertEquals("normal", u.getPermission());
    }

    @Test
    public void createDefaultAdminUser() {
        AdminUser admin = new AdminUser();
        assertEquals("admin", admin.getUsername());
        assertEquals("p4ssw0r6!", admin.getPassword());
        assertEquals("elevated", admin.getPermission());

    }

    @Test
    public void createDefaultROUser() {
        ReadOnlyUser roUser = new ReadOnlyUser();
        assertEquals("username", roUser.getUsername());
        assertEquals("password", roUser.getPassword());
        assertEquals("read only", roUser.getPermission());
    }

    @Test
    // here decide expect ? fail ? handle ?
    public void createCustomUser() {
        User user = new User("Max", "123456");


        assertEquals("Max", user.getUsername());


    }


}

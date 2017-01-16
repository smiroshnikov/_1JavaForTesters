package chapter15;

// TODO redo all user assignments
// TODO this is interview candidate

import javafortesters.chapter15.practice.AdminUser;
import javafortesters.chapter15.practice.IncorrectPasswordException;
import javafortesters.chapter15.practice.ReadOnlyUser;
import javafortesters.chapter15.practice.User;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test(expected = IncorrectPasswordException.class)
    public void createUserWithIncorrectPassword() {

        User user = new User("Max", "123456");
        fail("An exception should have been thrown");
    }

    @Test(expected = IncorrectPasswordException.class)
    public void createAdminWithIncorrectPassword() {
        AdminUser adminUser = new AdminUser("Bob", "123456");
    }

    @Test(expected = IncorrectPasswordException.class)
    public void createReadOnlyWithIncorrectPassword() {
        ReadOnlyUser user = new ReadOnlyUser("Stan", "");
    }

}

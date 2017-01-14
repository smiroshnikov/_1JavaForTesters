package chapter12;


import javafortesters.chapter12.practice.EmptyUser;
import javafortesters.chapter12.practice.ReadOnlyUser;
import javafortesters.chapter6.practice.AdminUser;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Chapter12Tests {
    @Test
    public void emptyUserExampleTest() {
        EmptyUser enu = new EmptyUser();
        assertEquals("username", enu.getUsername());
        assertEquals("password", enu.getPassword());
        assertEquals("https://192.125.54.84:67", enu.getUrl());
    }

    @Test
    public void anAdminUserConstructor() {
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasElevatedPermissions() {
        AdminUser adminUser = new AdminUser("admin", "Passw0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Passw0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());

    }

    @Test
    public void readOnlyUserTest() {
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();
        assertEquals("ReadOnly", readOnlyUser.getPermission());
        assertEquals("username", readOnlyUser.getUsername());
        assertEquals("password", readOnlyUser.getPassword());


    }

}

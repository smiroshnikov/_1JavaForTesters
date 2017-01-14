package chapter12;


import javafortesters.chapter12.practice.EmptyUser;
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
}

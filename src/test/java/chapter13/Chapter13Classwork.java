package chapter13;


import javafortesters.chapter13.practice.InvalidPassword;
import javafortesters.chapter6.practice.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class Chapter13Classwork {
    @Test(expected = InvalidPassword.class)
    public void invalidPasswordExceptionTest() {
        User user = new User();
        assertEquals("password", user.getPassword());
        User user1 = new User("Momo", "123");
        fail("An exception should have been thrown");
    }
}

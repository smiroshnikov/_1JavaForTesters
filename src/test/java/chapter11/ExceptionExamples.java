package chapter11;


import javafortesters.chapter11.practice.User;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ExceptionExamples {

    @Test // If expecting an exception I cannot catch it or test will fail !
//    @Test(expected = NullPointerException.class)
    public void nullPointerExample() {

        Integer age = null;
        String ageAsString;
        try { //code below always runs
            ageAsString = age.toString();
        } catch (NullPointerException e) { // will run only if exception occurs
            age = 18;
            ageAsString = age.toString();
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        String yourAge = "You are " + ageAsString + " years old";
        assertEquals("You are 18 years old", yourAge);
    }

    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void userPasswordTest() {
        User testUser;
        try {
            testUser = new User("Yana", "123456");
        } catch (IllegalArgumentException e) {
            e.getMessage();
            testUser = new User("Yana", "1234567890");
        }
        assertTrue(testUser.getPassword().length() > 6);
    }
}

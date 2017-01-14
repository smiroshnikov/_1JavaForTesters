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

    @Test
    public void tryCatchFinallyNullPointer() {
        Integer age = null;
        String ageAsString;
        String yourAge = "";
        try {
            ageAsString = age.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
            age = 18;
            ageAsString = age.toString();
        } finally {
            yourAge = "You are " + age.toString() + " years old";
        }
        assertEquals("You are 18 years old", yourAge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryCatchFinallyClassExample() {
        Integer age = null;
        try {
            System.out.println("1. generate a null pointer exception");
            System.out.println(age.toString());
        } catch (NullPointerException e) {
            System.out.println("2. handle null pointer exception !");
            throw new IllegalArgumentException("Null pointer became illegal", e);
        } finally {
            System.out.println("3. Run this code after finally ");
            System.out.println("\nThe test will pass because we expect illegal argument exception \nthat we produced while handling " +
                    "null pointer exception ");
        }
    }
}

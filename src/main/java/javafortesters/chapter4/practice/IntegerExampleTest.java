package javafortesters.chapter4.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerExampleTest {
    @Test
    public void integerExploration() {
        Integer four = new Integer(4);
        assertEquals("intValue returns int 5", 4, four.intValue());
        Integer five = new Integer("5");//accepts strings
        assertEquals("Passed in String parameter ! ", 5, five.intValue());
        Integer six = 6; // no need for "new" keyword
        assertEquals("autoboxing assignment for 6 ", 6, six.intValue());

    }
    @Test
    public void toHexExploration(){
        Integer integer = new Integer(11);
        assertEquals("Error ","b",integer.toHexString(integer));

    }
}

package chapter4;

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
    public void toHexExploration() {
        Integer eleven = new Integer(11);
        assertEquals("Error ", "b", eleven.toHexString(eleven));
        Integer ten = new Integer(10);
        Integer three = new Integer("3");
        Integer twentyOne = new Integer(21);
        assertEquals("Error ", "a", ten.toHexString(ten));
        assertEquals("Error ", "3", three.toHexString(three));
        assertEquals("Error ", "15", twentyOne.toHexString(twentyOne));

    }

    @Test
    public void minMaxValueTest() {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        assertEquals("Values are incorrect ", -2147483648, minValue);
        assertEquals("Values are incorrect ", 2147483647, maxValue);
    }
}

package chapter7;

import javafortesters.chapter7.practice.MathAddition;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoNumbersTest {
    @Test
    public void canAddTwoNumbers() {
        assertEquals("invalid value", 5, MathAddition.addTwoNumbers(2, 3));

    }
}

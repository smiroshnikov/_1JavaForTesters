package javaForTesters.chapter7;

import javafortesters.chapter7.practice.MathAddition;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoNumbersTest {
    @Test
    public void canAddTwoNumbers() {
        assertEquals("invalid value", 5, MathAddition.addTwoNumbers(2, 3));
        long a = 1L;
        int hex = 0x34A;
        int bin = 0b111101010111100001;
        int b = 9_000_000;
        float y = 9.000F;
        double x = 92342342342342342.21323123123423423400001D;
        char z = 'a';
        char test = '\u002A';
        System.out.println(test);

    }
}

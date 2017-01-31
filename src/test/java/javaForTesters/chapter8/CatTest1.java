package javaForTesters.chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CatTest1 {
    @Test
    public void confirmCatsAmount() {
        int number = 1;
        assertEquals("1 means only 1 cat ", catOrCats(number), "cat");
    }

    public String catOrCats(int numberOfAnimals) {
        return numberOfAnimals == 1 ? "cat" : "cats";
    }

    @Test
    public void checkTruthy() {
        boolean truthy = false;
        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        } else {
            assertFalse(truthy);
        }

    }

    @Test
    public void nestedHorror() {
        boolean truthy = false;
        boolean falsey = false;
        if (truthy) {
            if (!falsey) {
                if (falsey || truthy) {
                    assertTrue(" t t", truthy);
                    assertFalse("f f", falsey);
                }
            } else {
                assertTrue("fail here ?!", truthy);
                assertFalse(falsey);
            }
        }
        if (!truthy) {
            if (falsey) {
                assertTrue(falsey);
                assertFalse(truthy);
            } else {
                assertFalse(falsey);
                assertFalse(truthy);
            }

        }
    }
}

package chapter8;

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
        boolean truthy = true;
        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        }

    }
}

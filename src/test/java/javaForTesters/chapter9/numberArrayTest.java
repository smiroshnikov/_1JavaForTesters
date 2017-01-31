package javaForTesters.chapter9;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class numberArrayTest {
    @Test
    public void simpleArrayTest() {
        String[] weapons = {"axe", "sword", "spear", "dagger"};
        for (String weapon :
                weapons) {
            System.out.println(weapon);
        }
        assertEquals("axe", weapons[0]);
        assertEquals("dagger", weapons[1]);

    }
}

package javaForTesters.startUsingJava;

import org.junit.Assert;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by miross1 on 1/31/2017.
 */
public class MyFirstTest {
    @Test
    public void checkEverything() {
        Assert.assertTrue("Passed", true);
        SortedSet<String> mySet = new TreeSet<>();
        mySet.add("Alan");
        mySet.add("Bob");
        mySet.add("Claud");
        mySet.add("Donald");

        for (String s : mySet) {
            System.out.println(s);
        }
    }
}

package javaForTesters.chapter6;

import oracledocs.ClassOnly;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassOnlyTest {
    @Test
    public void preventInstantiationTest() {

        System.out.printf(ClassOnly.classMessage);
        assertEquals("Expect a staticQuestions call ", "only the lonely", ClassOnly.classMessage);

    }
}

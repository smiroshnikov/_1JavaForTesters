package chapter5;

import javafortesters.chapter5.practice.TestAppEnv;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAppEnvironmentTest {
    @Test
    public void canGetUrlStatically() {
        String result = "google.com";
        assertEquals("URL does not match",TestAppEnv.getUrl(),result);
        // because its static method it can be used without instantiating TestAppEnv object

    }
}

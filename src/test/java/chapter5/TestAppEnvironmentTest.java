package chapter5;

import javafortesters.chapter5.practice.TestAppEnv;
import org.junit.Test;

public class TestAppEnvironmentTest {
    @Test
    public void canGetUrlStatically() {
        TestAppEnv.getUrl();
        // because its static method it can be used without instantiating TestAppEnv object

    }
}

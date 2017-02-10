package javaForTesters.chapter5;

import org.junit.Assert;
import org.junit.Test;

import static javafortesters.chapter5.practice.TestAppEnv.DOMAIN;
import static javafortesters.chapter5.practice.TestAppEnv.PORT;
import static javafortesters.chapter5.practice.TestAppEnv.getUrl;

//import staticQuestions org.junit.Assert.assertEquals; // staticQuestions import allows usage of assertEquals method without Assert class instantiation


public class TestAppEnvironmentTest {
    @Test
    public void canGetUrlStatically() {
        //    assertEquals("URL does not match", TestAppEnv.getUrl(), "https://192.125.54.84");
//        Assert.assertEquals("URL does not match", TestAppEnv.getUrl(), "https://192.125.54.84");
        Assert.assertEquals("URL does not match", getUrl(), "https://192.125.54.84:67");
        // because its staticQuestions method it can be used without instantiating TestAppEnv object
    }

    @Test
    public void getPortAndDomain() {
        //assertEquals("Domain does not match", "192.125.54.84", TestAppEnv.DOMAIN);
        Assert.assertEquals("Domain does not match", "192.125.54.84", DOMAIN);
        //assertEquals("Port does not match", "67", TestAppEnv.PORT);
        Assert.assertEquals("Port does not match", "67", PORT);

    }
}

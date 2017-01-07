package chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UrlGenerationTest {
    @Test
    public void urlValidity() {
        String url = "google.com";
        url = url.startsWith("https://") ? url : "https://" + url;
        assertTrue(url.startsWith("https://"));
        assertEquals("incorrect url structure", "http://google.com", url);


    }

}

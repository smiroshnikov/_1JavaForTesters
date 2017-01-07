package chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UrlGenerationTest {
    @Test
    public void urlValidity() {
        String url = "google.com";
        url = url.startsWith("https://") ? url : addHttps(url);
        assertTrue(url.startsWith("https://"));
        assertEquals("incorrect url structure", "https://google.com", url);


    }

    private String addHttps(String url) {
        return "https://" + url;
    }

}

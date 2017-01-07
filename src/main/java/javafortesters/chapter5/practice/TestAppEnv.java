package javafortesters.chapter5.practice;

public class TestAppEnv {
    public static final String DOMAIN = "192.125.54.84";
    public static final String PORT = "67";

    public static String getUrl() {
        return "https://" + DOMAIN + ":" + PORT;
    }
}

package com.iidruurliik.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class SirDriver {

    private static ChromeDriver sirDriver = new ChromeDriver();
    // here I try to abstract "long load time of a chrome driver and instantiate it outside of test
    // and provide static method to myself later on

    public static void get(String url) {
        sirDriver.get(url);
    }

    public static void closeAndQuit() {
        sirDriver.close();
        sirDriver.quit();
    }
}

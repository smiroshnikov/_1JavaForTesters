package com.iidruurliik.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class SirDriver {

    private static ChromeDriver sirDriver = new ChromeDriver();


    public static void get(String url) {
        sirDriver.get(url);
    }
}

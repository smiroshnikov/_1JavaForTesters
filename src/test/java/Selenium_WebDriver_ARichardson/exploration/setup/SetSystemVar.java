package Selenium_WebDriver_ARichardson.exploration.setup;

/**
 * This class perform initial setup for my Selenium test runs ,
 * I was repeating those lines of code every fuckimg time and every fucking
 * test. So here is my try to write it once.
 */

public class SetSystemVar {
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";

    public static void webdriverSystemSetup() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.edge.driver") == null) {
            System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
        }

    }

}

package Selenium_WebDriver_ARichardson.exploration.minus4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RememberA {
    public static WebDriver driver;

    private static final String CHROME_DRIVER = "C:\\Webdrivers\\chromedriver.exe";
    private static final String FF_DRIVER = "C:\\Webdrivers\\geckodriver.exe";
    private static final String EDGE_DRIVER = "C:\\Webdrivers\\MicrosoftWebDriver.exe";

    @BeforeClass
    public static void driversSetup() {

        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        }
        if (System.getProperty("webdriver.geckodriver.driver") == null) {
            System.setProperty("webdriver.geckodriver.driver", FF_DRIVER);
        }
        if (System.getProperty("webdriver.edge.driver") == null) {
            System.setProperty("webdriver.edge.driver", EDGE_DRIVER);
        }
    }

    @Test
    public void navigateToGoogle() {
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @AfterClass
    public static void closeDrivers() {
        driver.close();
    }


}

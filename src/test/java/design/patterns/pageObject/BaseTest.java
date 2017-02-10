package design.patterns.pageObject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

/**
 * Separated driver setup and initialization
 */
public class BaseTest {

    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    static WebDriver driver;

    @BeforeClass
    public static void driverSetup() {
        // checks if webdriver is not defined is System.properties sets to webdriver location
        // DB connection should be executed here as well

        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.edge.driver") == null) {
            System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
        }
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    /**
     * Opens provided URL with Selenium driver.get command
     *
     * @param url String
     */
    public void open(String url) {
        driver.get(url);
    }

    public void open(URL url) {
        driver.get(url.toString());
    }

    /**
     * Waits a fixed amount time (e.g 2 secs) and re-tries every 500 ms to locate an element passed with ExpectedCondition
     * replaces assert functionality
     *
     * @param condition boolean - false if element is not found
     */
    public void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(driver, 2)).until(condition);
    }
}

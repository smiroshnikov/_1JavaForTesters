package elemental.login;

/**
 * Cmon make this class creation a live template
 */

import junit.framework.TestResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import junit.framework.TestResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Base test class , includes setup and various helpers not related to MVC page
 * helpers are double click and hovering over an element
 */
public class BaseTest {

    static final String HEROKU_LOGIN_URL = "http://the-internet.herokuapp.com/login";
    static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\geckodriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\MicrosoftWebDriver.exe";
    static WebDriver driver;
    static Actions action;
    static TestResult testResult;

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void driverSetup() {
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
        action = new Actions(driver);
        testResult = new TestResult();
    }

    @AfterClass
    public static void closeDriver() {
        driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void hoverOverAnElement(WebElement targetHotHovering) {
        action.moveToElement(targetHotHovering);
    }

    public void doADoubleClick(WebElement targetForClick) {
        action.doubleClick(targetForClick).perform();
    }

}


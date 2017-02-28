package Selenium_WebDriver_ARichardson.interrogation;

import junit.framework.TestResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class FightingCss {


    //region Variables
    static final String TEST_URL = "http://compendiumdev.co.uk/selenium/find_by_playground.php";
    static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    static WebDriver driver;
    static Actions action;
    static TestResult testResult;
    //endregion

    @Rule
    public TestName testName = new TestName();


    @BeforeClass
    public static void driverSetup() {
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
        action = new Actions(driver);
        testResult = new TestResult();
    }


    @AfterClass
    public static void closeDriver() {
        // driver.close();
    }


    @Test
    public void cssTest() {
//        By pParagraphSelector = By.cssSelector("p[class='normal']");
//        By divSelector = By.cssSelector("div[class='specialDiv']");
//        By partialDivSelector = By.cssSelector("div[class*='Di']");
//        By partialDivSelectorAtTheEnd = By.cssSelector("div[class$='Di']");
//        By partialDivSelectorAtTheMiddle = By.cssSelector("div[class$='Di']");
//        By partialDivSelectorAtTheStart = By.cssSelector("div[class^='spe']");
//        By anywhereClassHasDefinedString = By.cssSelector("div[class~='has']");
//        By classORNameSelector = By.cssSelector("div[class~='has'],div[name*='m']");
        // * match any element
        // #id match id e.g #p4
        //.class match a class e.g "normal"
        // tag - match tag <p>/<p>
        // [attribute] - match attribute name
        driver.get(TEST_URL);
        WebElement element;
        element = driver.findElement(By.id("p8"));
        element = driver.findElement(By.cssSelector("#p8"));


    }

}



package SeleniumWebDriverRefresh.Part3.D.minus1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * ShowCase for interviews
 * mySQL DB contains hatedPeople table with following structure
 * Employee ID  Name       Age  Mobile       email
 * ----------------------------------------------------
 * 001          Sidheswar  25   9938885469   sidheswar@gmail.com
 * 002          Pritish    32   9178542436   prit.ish@yahoo.com
 * etc.
 * Automated sign up , and login , email verification -need provider with java API  (jetmail?)
 * Simulate user validation in mySQL
 */

public class End2EndSimulationTest {

    private static final String TEST_URL = "http://todomvc.com/examples/react/#/";
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver;
    // remove variable declaration away from test logic
    private WebElement searchField = driver.findElement(By.name("q"));


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
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public void searchText() {
        driver.get(TEST_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        searchField.sendKeys("Privet Kroka!", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}

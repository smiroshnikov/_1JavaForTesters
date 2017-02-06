package SeleniumWebDriverRefresh.Part3.D.minus1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by miross1 on 2/6/2017.
 */
public class GoogleTest {

    private static final String TEST_URL = "http://google.com/ncr";
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver;
    // remove variable declaration away from test logic
    // will not work for now because we have not loaded page yet so wait for a better method
    // private WebElement searchField = driver.findElement(By.name("q"));

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
        // stopped @ 36:35
        // https://www.youtube.com/watch?v=zCjNOIp7p3c
    }

}

package SeleniumWebDriverRefresh;

import com.iidruurliik.driver.SirDriver;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class WebNavigationTest {

    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\MicrosoftWebDriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\geckodriver.exe";

    @Before
    public void chromeDriverPathSetup() throws FileNotFoundException {
        // TODO recall how to check if file present in path  !
        // Add unable to proceed , failing test blah-blah
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.edge.driver") == null) {
            System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        }
        //System.out.println(System.getProperty("webdriver.chrome.driver"));
    }


//    @BeforeClass
//    //TODO why BeforeClass and AfterClass are static
//    public static void createDriver() {
//        driver = new ChromeDriver();
//    }

//    @Test
//    public void navigateToURL() {
//        driver.navigate().to("gmail.com");
//        assertTrue("Invalid title", driver.getTitle().contains("Gmail"));
//    }

    @Test
    public void fastStartFirefoxWithStaticMethod() {
        // TODO use my custom static get method
        SirDriver.get("http://google.com");
    }

//    @AfterClass
//    public static void quitDriver() {
//        driver.quit();
//    }
}

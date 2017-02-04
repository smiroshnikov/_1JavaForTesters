package SeleniumWebDriverRefresh.part0.D.minus4;

import com.iidruurliik.driver.SirDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebNavigationTest {

    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\MicrosoftWebDriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\geckodriver.exe";


    @BeforeClass
    public static void chromeDriverPathSetup() {
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
    }

    @Test
    public void fastStartFirefoxWithStaticMethod() {
        // Very inconvenient , just a performance workaround but wont provide anny flexibility for testing
        SirDriver.get("http://google.com");
        SirDriver.get("http://microsoft.com");
    }

    @AfterClass
    public static void quitDriver() {
        // Very inconvenient , just a performance workaround but wont provide anny flexibility for testing
        SirDriver.closeAndQuit();
    }
}

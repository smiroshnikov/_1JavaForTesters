package SeleniumWebDriverRefresh;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

/*
    IMPORTANT NOTES , Webdriver is anm Interface common to ChromeDriver , EdgeDriver , FirefoxDriver and
     HtmlUnitDriver
     use CTRL + SPACE
     to solve javadoc issues just download the fucking sources
     CTRL + N (My classes), finally found you !
 */

public class OpenBrowsersToGoogleTest {

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

    @Test
    public void startChromeWebdriver() {
        WebDriver chomeDriver = new ChromeDriver();
        chomeDriver.navigate().to("http://www.google.com");
        assertTrue("title should start with \"Google\" ", chomeDriver.getTitle().startsWith("Google"));
        chomeDriver.close();
    }

    //    @Ignore
    @Test
    //TODO try with ESA version of firefox @home
    // Currently Firefox crashes or starts twice !
    // consider VM as solution
    public void startFireFoxWebDriver() {
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.navigate().to("https://www.google.com/");
        // Browser version might advance ahead of driver  and various compatibility issue can prevent firefox
        // to close after "close" and quit is required !
        firefoxDriver.close();
        firefoxDriver.quit();
    }

    @Test
    public void startEdgeDriver() {
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.navigate().to("http://linux.org");
        // so far no difference how do I add external documentation to IntelijIdea
        edgeDriver.get("www.microsoft.com"); // get follows redirects

        edgeDriver.close();

    }

    @Test
    public void headleassHTMLTest() {
        WebDriver headless = new HtmlUnitDriver();
        headless.navigate().to("http://google.com");
        headless.navigate().refresh();

        assertTrue("Incorrect title !", headless.getTitle().startsWith("Goo"));

    }
}
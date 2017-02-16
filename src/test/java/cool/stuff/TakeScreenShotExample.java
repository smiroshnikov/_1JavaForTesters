package cool.stuff;

import junit.framework.TestResult;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Selenium Webdriver Practical Guide Safari Online
 */
public class TakeScreenShotExample {

    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    static WebDriver driver;

    @BeforeClass
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
        driver = new ChromeDriver();
    }


    @Test
    public void goFailandTakeScrrenshot() throws IOException {
        driver.get("http://www.google.com/");
        TestResult testResult = new TestResult();
        // TODO outside to MVC
        if (testResult.wasSuccessful()) {
            // TODO PARTIZANEN KOSTILI STYLE !
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            if (new File("c:\\Webdrivers\\screenshots\\error.png").exists()) {
                boolean deletedFlag = new File("c:\\Webdrivers\\screenshots\\error.png").delete();
                if (deletedFlag) {
                    System.out.println("Deleted previous file...");
                }
            }
            FileUtils.copyFile(scrFile, new File("c:\\Webdrivers\\screenshots\\error.png"));
        }
    }
}

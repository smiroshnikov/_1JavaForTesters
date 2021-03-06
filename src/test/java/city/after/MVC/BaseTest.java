package city.after.MVC;


import junit.framework.TestResult;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BaseTest {

    static final String TEST_URL = "http://todomvc.com/examples/react/#/";
    static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    static WebDriver driver;
    static Actions action;
    static TestResult testResult;

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

    public static void open(String url) {
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static int generateRandomValueBetweenMinToMax(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public static String generateRandomWordWith_HEB_ENG_Charsets() {
        String validValues = " ABCDEFGHIJKLMNOPQRSTUVWXYZ " + " ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toLowerCase() +
                " !@#$%^&*()_+ " + "א\u200E ב\u200E ג\u200E ד\u200E ה\u200E ו\u200E ז\u200E ח\u200E ט\u200E י\u200E כ\u200E ך\u200E  ל\u200E מ\u200E" +
                " נ\u200E ס\u200E ע\u200E פ\u200E צ\u200E ק\u200E ר\u200E ש\u200E ת";
        String result = "";
        for (int i = 0; i < generateRandomValueBetweenMinToMax(3, 100); i++) {
            char rChar = validValues.charAt(RANDOM.nextInt(validValues.length()));
            result += rChar;
        }
        return result;
    }

    public void doADoubleClick(WebElement targetForClick) {
        action.doubleClick(targetForClick).perform();
    }

    public void hoverOverAnElement(WebElement targetForHovering) {
        action.moveToElement(targetForHovering);
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

    public void takeScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\Webdrivers\\screenshots\\" + testName.getMethodName() + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




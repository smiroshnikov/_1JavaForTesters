package remake.MVC2;

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

import java.io.File;
import java.io.IOException;
import java.util.Random;


/**
 * Base test class , includes setup and various helpers not related to MVC page
 * helpers are double click and hovering over an element
 */
public class BaseTest {

    static final String REACT_URL = "http://todomvc.com/examples/react/#/";
    static final String HEROKU_URL = "https://todomvc4tasj.herokuapp.com/";
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
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static int randomValueBetweenMinMax(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public static String randomWord_HE_ENG_Charset() {
        String rusABC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String engABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String hebABC = "אבגדהוזחטיכלמנסעפצקרשת";
        String special = "~`!@#$%^&*()_+";
        String numeric = "1234567890";
        String lotsOfSpaces = "                                      ";
        String charPool = engABC + engABC.toLowerCase() + special + hebABC + numeric + rusABC + lotsOfSpaces;
        String randomSequence = "";
        for (int i = 0; i < randomValueBetweenMinMax(3, 100); i++) {
            char randomChar = charPool.charAt(RANDOM.nextInt(charPool.length()));
            randomSequence += randomChar;
        }
        return randomSequence;
    }

    public void hoverOverAnElement(WebElement targetHotHovering) {
        action.moveToElement(targetHotHovering);
    }

    public void doADoubleClick(WebElement targetForClick) {
        action.doubleClick(targetForClick).perform();
    }

    public void takeScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("c:\\Webdrivers\\screenshots\\" + testName.getMethodName() + System.currentTimeMillis() % 10000 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

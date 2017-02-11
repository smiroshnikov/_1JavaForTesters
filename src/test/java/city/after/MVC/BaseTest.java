package city.after.MVC;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class BaseTest {

    static final String TEST_URL = "http://todomvc.com/examples/react/#/";
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    static WebDriver driver; // should be a singletone ? Thread safe ? how about FF and E?

    static final Random RANDOM = new Random(System.currentTimeMillis());
    //static private Actions action = new Actions(driver);


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
        // driver.close();
    }

    public static void open(String url) {
        driver.get(url);
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

//    public void doADoubleClick(WebElement targetForClick) {
//        action.doubleClick(targetForClick).perform();
//    }
}




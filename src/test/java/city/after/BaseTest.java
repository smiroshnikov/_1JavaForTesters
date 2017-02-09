package city.after;


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
    static WebDriver driver; // should be a singletone
    static final Random RANDOM = new Random();


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

    public static int getRandFrom1to20() {
        return RANDOM.nextInt(200) + 35;
    }

    public static String getRandWord() {
        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase() +
                "!@#$%^&*()_+";
        String result = "";
        for (int i = 0; i < getRandFrom1to20(); i++) {
            char rChar = validValues.charAt(RANDOM.nextInt(validValues.length()));
            result += rChar;
        }
        return result;
    }
}




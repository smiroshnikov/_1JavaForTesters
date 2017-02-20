package remake.MVC2;

import junit.framework.TestResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;
import java.util.concurrent.TimeUnit;


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
        driver.close();
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

    public static String randomCharsetMix() {
        String rusABC = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String engABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String hebABC = "אבגדהוזחטיכלמנסעפצקרשת";
        String special = "~`!@#$%^&*()_+";
        String numeric = "1234567890";
        String chiABC = "精选品牌畅销科技发现趋势样式已过期每天几分钟全身都轻松亚马逊最畅销按摩设备选合本条折扣信息发布于天前内容可" +
                "能已失效。给操劳了多年的妈妈放松下疲惫的身体吧～长时间工作学习肢体保持同姿势时间久了肌肉骨都僵浑身酸痛疲乏睡眠也受" +
                "影响按摩可以松驰肌肉放松精神缓解疲劳在家备个按摩器闲暇时边看剧一边按每天都是最佳状态";
        String lotsOfSpaces = "                                      ";
        String charPool = engABC + engABC.toLowerCase() + special + hebABC + numeric + rusABC + lotsOfSpaces + chiABC;

        String randomSequence = "";
        for (int i = 0; i < randomValueBetweenMinMax(10, 100); i++) {
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

    public void executionWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


}

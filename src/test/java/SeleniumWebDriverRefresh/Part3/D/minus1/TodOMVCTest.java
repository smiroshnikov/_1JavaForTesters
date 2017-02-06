package SeleniumWebDriverRefresh.Part3.D.minus1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * todoMVC proof of concept
 */

public class TodOMVCTest {
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\MicrosoftWebDriver.exe";
    private static WebDriver driver;

    @BeforeClass
    public static void setUpDriver() {
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
    public void createTask() throws InterruptedException {
        //Configuration.browser = "chrome";
        //open("http://todomvc.com/examples/troopjs_require/");
        // apparently whaen i was missing "#" in link , my flow was fucked up . Its only 00-05 glad it took only aboout a fucking hour !
        // sendKeys(Keys.Enter) was completely ignored
        driver.get("http://todomvc.com/examples/react/#/");
        driver.manage().window().maximize();
        WebElement newTodo = driver.findElement(By.className("new-todo"));
        newTodo.sendKeys("write a todo list ");
        newTodo.sendKeys(Keys.RETURN);
        newTodo.sendKeys("go to sleep");
        newTodo.sendKeys(Keys.RETURN);
        newTodo.sendKeys("get a job offer :)");
        newTodo.sendKeys(Keys.RETURN);
        newTodo.sendKeys("forget DELL-EMC as my worst fucking nightmare ");
        newTodo.sendKeys(Keys.RETURN);


        Thread.sleep(1000);


    }

    @AfterClass
    public static void closeDriver() {
        //driver.close();
    }

}

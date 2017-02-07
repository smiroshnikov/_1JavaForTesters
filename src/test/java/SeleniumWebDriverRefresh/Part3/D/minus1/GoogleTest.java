package SeleniumWebDriverRefresh.Part3.D.minus1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

    private static final String TEST_URL = "http://google.com/ncr";
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver;
    // remove variable declaration away from test logic
    // will not work for now because we have not loaded page yet so wait for a better method
    // private WebElement searchField = driver.findElement(By.name("q"));

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

    public WebElement searchField() {
        return driver.findElement(By.name("q"));
    }

    @Test
    public void searchText() {
        driver.get(TEST_URL);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        searchField().sendKeys("selenium", Keys.ENTER);
        //checking if elements are present , located with XPATH and waitying 4 seconds until elements displayed
        (new WebDriverWait(driver, 4)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a")));
        // OK finally have validated some results
        (new WebDriverWait(driver, 3)).until(
                ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a"), "Selenium - Web Browser Automation"));
        // third try to validate via css path
        (new WebDriverWait(driver, 3)).until(
                ExpectedConditions.textToBePresentInElement(By.cssSelector(".r>a"), "Selenium - Web Browser Automation"));

        //System.out.println(driver.findElement(By.linkText("Selenium")));
        // stopped @ 36:35
        // https://www.youtube.com/watch?v=zCjNOIp7p3c
    }

}

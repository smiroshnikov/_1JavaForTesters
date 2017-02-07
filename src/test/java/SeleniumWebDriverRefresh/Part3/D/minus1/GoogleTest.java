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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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


    // QA wise I do not really agree with the separation below , I will build the same way as I do in python @work
    // separate instantiation and pages , object , helper classes and DB connections to separate files and
    // leave pure test logic to be easily understood and modified , however for the sake of rapid learning
    // lets have it messy way around

    public WebElement searchField() {
        // stil would like to try this as variable and not finction
        return driver.findElement(By.name("q"));
    }

    public void search(String text) {
        // maybe , maybe helper class , not sure yet , neeed to test on Cloudinary website for really interesting results
        driver.findElement(By.name("q")).sendKeys(text, Keys.ENTER);
    }

    @Test
    public void searchText() {
        driver.get(TEST_URL);
        //driver.manage().window().maximize();
        // implicit wait has disadvantages , a better wait is described below if I really need a loop
        // Thread.sleep(3000); is the worst possible way to wait
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //searchField().sendKeys("selenium", Keys.ENTER);

        search("Selenium");
        //checking if elements are present , located with XPATH and waitying 4 seconds until elements displayed
        (new WebDriverWait(driver, 4)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a")));
        // OK finally have validated some results
        // might replace asserts at this point , I am checking that page elelemts are displayed in order to proceed to
        // further flow, I dont really expect to assert yet .
        (new WebDriverWait(driver, 3)).until(
                ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a"),
                        "Selenium - Web Browser Automation"));
        // third try to validate via css path
        (new WebDriverWait(driver, 3)).until(
                ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".r>a"),
                        "Selenium - Web Browser Automation"));
        assertThat(driver.findElement(By.cssSelector(".r>a")).getText(), is("Selenium - Web Browser Automation"));
        // a mess , but for the sake of learning lets keep it for now
        searchField().sendKeys(" chemical element", Keys.ENTER);

        // used not @Deprecatecdx method
        (new WebDriverWait(driver, 2)).until(
                ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".st>em"), "Selenium"));
        // page factory + page object

    }

}

package SeleniumWebDriverRefresh;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NavigationClassworkTest {

    public static WebDriver driver;
    public static final String CHROME_DRIVER_PATH = "c:\\Webdrivers\\chromedriver.exe";

    @BeforeClass
    public static void setDriver() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        System.out.println("Chrome driver path set to \n" + System.getProperty("webdriver.chromedriver.driver"));
        driver = new ChromeDriver();
    }

    @Test
    public void navigateCompendiumdev() {
        driver.get("http://compendiumdev.co.uk/selenium");
        assertThat(driver.getTitle().contains("Selenium Simplified"), is(true));
        driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
        assertThat(driver.getTitle().equals("Selenium Simplified Search Engine"), is(true));
    }

    @AfterClass
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

}

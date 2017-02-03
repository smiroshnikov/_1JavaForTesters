package SeleniumWebDriverRefresh;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class NavigationClassworkTest {

    public static WebDriver driver;
    public static final String CHROME_DRIVER_PATH = "c:\\Webdrivers\\chromedriver.exe";

    @BeforeClass
    public static void setDriver() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        System.out.println("Chrome driver path set to \n" + System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }

    @Test
    public void navigateCompendiumdev() throws InterruptedException {
        driver.get("http://compendiumdev.co.uk/selenium");
        assertThat(driver.getTitle().contains("Selenium Simplified"), is(true));
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
        assertThat(driver.getTitle().equals("Selenium Simplified Search Engine"), is(true));
        Thread.sleep(2000);

        driver.navigate().back();
        assertThat(driver.getTitle().contains("Selenium Simplified"), is(true));
        Thread.sleep(2000);

        driver.navigate().forward();
        assertThat(driver.getTitle().equals("Selenium Simplified Search Engine"), is(true));
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_html_form.html");
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_web_page.html");
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/refresh.php");
        driver.navigate().refresh();
        assertTrue("Epoch time differs", driver.getTitle().contains("Refreshed Page on " + Long.toString(System.currentTimeMillis()).substring(0, 9)));
        Thread.sleep(2000);

    }

    @Ignore
    @Test
    public void stringCastration() {
        String tooLong = "1486156774642";
        System.out.println(tooLong.substring(0, 9));
    }


    @AfterClass
    public static void closeAndQuit() {
        driver.close();
        driver.quit();
    }

}

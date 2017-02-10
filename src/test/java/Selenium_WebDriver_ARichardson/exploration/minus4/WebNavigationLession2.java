package Selenium_WebDriver_ARichardson.exploration.minus4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class WebNavigationLession2 {

    private static WebDriver driver; // youbaniy pizdetz!

    @BeforeClass
    public static void createDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void navigateWithNAvigateTo() {
        driver.navigate().to("http://linux.org");
        assertThat(driver.getTitle().contains("Linux"), is(true));
    }

    @AfterClass
    // TODO  this is important because of the test fails , the driver would still quit!
    public static void quitSDriver() {
        driver.quit();
    }

}

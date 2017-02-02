package SeleniumWebDriverRefresh;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebNavigationLession2 {

    private static WebDriver driver; // youbaniy pizdetz!

    @BeforeClass
    public static void createDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void navigateWithNAvigateTo() {
        driver.navigate().to("http://linux.org");
    }

}

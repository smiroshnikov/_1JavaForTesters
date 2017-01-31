package web.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


public class MyFirstChromeTest {
    @Test
    public void startChromeWebdriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe"); // this is fucking before method
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver chomeDriver = new ChromeDriver();
        chomeDriver.navigate().to("http://www.google.com");
        assertTrue("title should start with \"Google\" ", chomeDriver.getTitle().startsWith("Google"));
        chomeDriver.close();
    }

    @Test
    public void startFireFoxWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe"); // this is fucking before method
        System.out.println(System.getProperty("webdriver.gecko.driver"));
        WebDriver fDriver = new FirefoxDriver();
        fDriver.navigate().to("https://google.com");
    }
}

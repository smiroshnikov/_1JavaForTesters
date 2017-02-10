package Selenium_WebDriver_ARichardson.exploration.minus3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindByTest {
    private static WebDriver driver;
    private static final String TEST_URL = "http://compendiumdev.co.uk/selenium/find_by_playground.php";

    private static final String CHROME_DRIVER_PATH = "c:\\Webdrivers\\chromedriver.exe";

    @BeforeClass
    public static void driverSetup() {
        // TODO lets do this with a file - looks better
        // TODO 1) write what exactly you want to do
        // TODO 2) see if iit is really relevant to a file ?
        // TODO 3) search for file ? Check for file in path ? check if file in folder ?
        // TODO 4) go over file and property lesson again

        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        driver = new ChromeDriver();
    }

    @Test
    public void findByClasswork() throws MalformedURLException, InterruptedException {
        // just using URL class
        URL testUrl = new URL(TEST_URL);
        driver.navigate().to(testUrl);
        Thread.sleep(2500);
        WebElement requiredElement = driver.findElement(By.id("p1"));
        assertThat("Find by ID test failed", requiredElement.getText(), is("This is a paragraph text"));
        requiredElement = driver.findElement(By.name("pName2"));
        assertTrue("Find by name test failed", requiredElement.getText().contentEquals("This is b paragraph text"));
        requiredElement = driver.findElement(By.linkText("jump to para 12"));
        assertEquals("Find by linkedText test failed", "jump to para 12", requiredElement.getText());
        requiredElement = driver.findElement(By.partialLinkText("para 20"));
        assertThat("Find by partialLink failed ", requiredElement.getText(), is("jump to para 20"));
        requiredElement = driver.findElement(By.className("nestedDiv"));
        // By.classname returns them all !
        assertThat("Find by class failed", requiredElement.getText(), is("nested para text\n" +
                "nested para text\nnested para text\nnested para text\nnested para text\nnested para text\nnested para " +
                "text\nnested para text\nnested para text\nnested para text\nnested para text\nnested para text\nnested " +
                "para text\nnested para text\nnested para text\nnested para text"));

    }

    @AfterClass
    public static void closeAndQuit() {
        driver.close();
    }
}

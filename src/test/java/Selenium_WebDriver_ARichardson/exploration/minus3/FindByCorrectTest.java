package Selenium_WebDriver_ARichardson.exploration.minus3;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindByCorrectTest {
    private static WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "c:\\Webdrivers\\chromedriver.exe";
    private static boolean fireFoxFlag;

    @BeforeClass
    public static void driverSetup() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        driver = new ChromeDriver();
        fireFoxFlag = false;
        // It is a good idea to perform navigation here because all the tests will run on this page
        driver.get("http://compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test(expected = NoSuchElementException.class)
    public void failToFindElement() {
        WebElement fakeParagraph = driver.findElement(By.id("fakeID"));
        assertFalse(fakeParagraph.getText().contains("fake"));
    }

    @Test
    public void findByID() {
        WebElement bParagraph = driver.findElement(By.id("p2"));
        assertThat(bParagraph.getText().contains("This is b paragraph text"), is(true));
        assertTrue(driver.findElement(By.id("p2")).getText().contains("This is b paragraph text"));

    }

    @Test
    public void findByLinkText() {
        WebElement jumptoPara0 = driver.findElement(By.linkText("jump to para 0"));
        assertEquals("ID validation", "a26", jumptoPara0.getAttribute("id"));
    }

    @Test
    public void findByPartialLinkText() {
        // The cool idea here is that we are testing start , middle and end
        // again a more QA way of thinking !
        WebElement jumpTo = driver.findElement(By.partialLinkText("jump to"));
        assertThat("Find by partialLink failed ", jumpTo.getText(), is("jump to para 0"));
        jumpTo = driver.findElement(By.partialLinkText("to"));
        assertThat("Find by partialLink failed ", jumpTo.getText(), is("jump to para 0"));
        jumpTo = driver.findElement(By.partialLinkText("7"));
        assertThat("Find by partialLink failed ", jumpTo.getText(), is("jump to para 7"));
    }

    @Test
    public void findByClass() {
        WebElement aDivName = driver.findElement(By.className("specialDiv"));
        assertThat("Find by class failed", aDivName.getAttribute("testName"), is("mydivname"));
    }

    @Test
    public void findByName() {
        WebElement aParagraph = driver.findElement(By.name("pName11"));
        assertThat(aParagraph.getText().contains("This is k paragraph text"), is(true));
    }


    @AfterClass
    public static void quitAndClose() {
        driver.close();
        if (fireFoxFlag) {
            driver.quit();
        }
    }

}

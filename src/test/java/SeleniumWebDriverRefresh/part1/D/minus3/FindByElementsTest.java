package SeleniumWebDriverRefresh.part1.D.minus3;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FindByElementsTest {
    private static final String CHROME_DRIVER_PATH = "c:\\Webdrivers\\chromedriver.exe";
    private static WebDriver driver;

    @BeforeClass
    public static void driverSetup() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        driver = new ChromeDriver();
        driver.get("http://compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void t() {
        driver.get("http://google.com");
    }

    @Test
    public void returnListOfAllElementsByClassName() {
        List<WebElement> elements;
        elements = driver.findElements(By.className("normal"));
        Set<String> foundTags = new HashSet<>();
        for (WebElement e :
                elements) {
            //debug
            //System.out.println(e.getTagName());
            foundTags.add(e.getTagName());
        }
        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("p"));
        assertTrue("expected li tag", foundTags.contains("p"));
        assertTrue("expected a tag", foundTags.contains("p"));
        assertFalse("did not expect 'div' tag", foundTags.contains("div"));
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

}

package Selenium_WebDriver_ARichardson.exploration.minus3;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

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
//        SortedSet<String> myTags = new TreeSet<>();
        // fails for some reason

        for (WebElement e :
                elements) {
            //debug
            //System.out.println(e.getTagName());
            foundTags.add(e.getTagName());

//            myTags.add(e.getTagName());
            System.out.printf("%s%n", e.getTagName());
        }

        for (String e :
                foundTags) {
            System.out.printf("%s", e);
        }


        assertTrue("expected p tag", foundTags.contains("p"));
        assertTrue("expected ul tag", foundTags.contains("p"));
        assertTrue("expected li tag", foundTags.contains("p"));
        assertTrue("expected a tag", foundTags.contains("p"));
        assertFalse("did not expect 'div' tag", foundTags.contains("div"));
    }

    @Test
    public void countElements() {
        List<WebElement> webElements = driver.findElements(By.tagName("div"));
        System.out.println(webElements.size());
        List<WebElement> aRefList = driver.findElements(By.partialLinkText("jump to"));
        System.out.println(aRefList.size());
    }


    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

}

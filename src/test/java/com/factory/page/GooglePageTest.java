package com.factory.page;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Page Objects and Page Factory sample
 */

public class GooglePageTest {

    private static final String TEST_URL = "http://google.com/ncr";
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver;
    // page objects as kindly mentioned by FE dev from Cloudinary
    GooglePage page = new GooglePage(driver);

    public void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(driver, 3)).until(condition);
    }

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

    @Test
    public void searchText() {
        driver.get(TEST_URL);
        page.searchField.sendKeys("selenium", Keys.ENTER);
        assertThat(textToBePresentInElement(page.firstResult, "Selenium"));
        page.searchField.sendKeys(" chemical element", Keys.ENTER);
        assertThat(textToBePresentInElement(page.firstResult, "Selenium"));
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }


}

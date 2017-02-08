package com.factory.page;

import org.junit.Test;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Page Objects and Page Factory sample
 */

public class GooglePageTest extends BaseTest {


    // page objects as kindly mentioned by FE dev from Cloudinary
    GooglePage page = new GooglePage(driver);

    @Test
    public void searchText() {
        driver.get("http://google.com/ncr");
        page.searchField.sendKeys("selenium", Keys.ENTER);
        assertThat(textToBePresentInElement(page.firstResult, "Selenium"));
        page.searchField.sendKeys(" foods", Keys.ENTER);
        assertThat(textToBePresentInElement(page.foodResult, "Top 10 Foods High in Selenium"));
    }
}
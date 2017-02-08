package com.factory.page;

import org.junit.Ignore;
import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Page Objects and Page Factory sample
 */

public class SearchPagesTest extends BaseTest {

    // googlePage objects as kindly mentioned by FE dev from Cloudinary
    GooglePage googlePage = new GooglePage(driver);
    YahooPage yahooPage = new YahooPage(driver);

    @Test
    public void searchTextWithGoogle() {
        open("http://google.com/ncr");
        googlePage.searchMore("Selenium");

        assertThat(textToBePresentInElement(googlePage.firstResult, "Selenium"));

        // broken , this is not MVC-TODO
//        googlePage.followFirstResult();

        googlePage.searchMore(" food");

        assertThat(textToBePresentInElement(googlePage.foodResult, "Top 10 Foods High in Selenium"));
    }

    @Ignore
    @Test
    public void searchTextWithYahoo() {
        // go over CSS and HTML
        open("http://yahoo.com");
        yahooPage.searchMore("Millenium");
        assertThat(textToBePresentInElement(yahooPage.firstResult, "Cloudinary - Cloud image service, upload, storage & CDN"));
    }
}
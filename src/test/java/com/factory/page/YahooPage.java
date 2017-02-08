package com.factory.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by miross1 on 2/8/2017.
 */
public class YahooPage {
    @FindBy(xpath = ".//*[@id='uh-search-box']")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"c8f0\"]/div/div/div[1]/h3/a/text()")
    WebElement firstResult;

    public YahooPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchMore(String text) {
        searchBox.sendKeys(text, Keys.ENTER);
    }
}

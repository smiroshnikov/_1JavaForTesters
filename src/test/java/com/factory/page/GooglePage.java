package com.factory.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    @FindBy(name = "q")
    WebElement searchField;

    @FindBy(css = ".r>a")
    WebElement firstResult;

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

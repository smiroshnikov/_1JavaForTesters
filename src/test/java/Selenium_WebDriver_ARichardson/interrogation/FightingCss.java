package Selenium_WebDriver_ARichardson.interrogation;

import org.junit.Test;
import org.openqa.selenium.By;

public class FightingCss {
    @Test
    public void cssTest() {
        By pParagraphSelector = By.cssSelector("p[class='normal']");
        By divSelector = By.cssSelector("div[class='specialDiv']");
        By partialDivSelector = By.cssSelector("div[class*='Di']");
        By partialDivSelectorAtTheEnd = By.cssSelector("div[class$='Di']");
        By partialDivSelectorAtTheMiddle = By.cssSelector("div[class$='Di']");
        By partialDivSelectorAtTheStart = By.cssSelector("div[class^='spe']");
        By anywhereClassHasDefinedString = By.cssSelector("div[class~='has']");


    }

}


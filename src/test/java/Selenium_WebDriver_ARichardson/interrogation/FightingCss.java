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
        By classORNameSelector = By.cssSelector("div[class~='has'],div[name*='m']");
        // * match any element
        // #id match id e.g #p4
        //.class match a class e.g "normal"
        // tag - match tag <p>/<p>
        // [attribute] - match attribute name
    }

}


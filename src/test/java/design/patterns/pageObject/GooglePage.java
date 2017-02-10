package design.patterns.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    @FindBy(name = "q")
    WebElement searchField;

    @FindBy(css = ".r>a")
    WebElement firstResult;

    @FindBy(css = "._zXc>b")
    WebElement foodResult;

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchMore(String text) {
        searchField.sendKeys(text, Keys.ENTER);
    }

    public void followFirstResult() {
        firstResult.findElement(By.cssSelector("a[href*='www.seleniumhq.org/']")).click();
    }

}

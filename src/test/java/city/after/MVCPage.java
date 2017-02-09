package city.after;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MVCPage {

    @FindBy(css = ".new-todo")
    WebElement newTodoLine;

    @FindBy(css = ".toggle")
    WebElement toggleComplition;

    @FindBy(css = ".destroy")
    WebElement deleteTask;

    @FindAll({
            @FindBy(css = ".toggle")
    })
    List<WebElement> allTasksToggle;


    public MVCPage(WebDriver driver) {
        // whats happening behing the scenes
        // looks very interesting
        PageFactory.initElements(driver, this);
    }

    public void enterTask(String taskText) {
        newTodoLine.sendKeys(taskText, Keys.ENTER);
    }
}

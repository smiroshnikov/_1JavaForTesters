package city.after.MVC;

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
    WebElement toggleCompletion;

    @FindBy(css = ".destroy")
    WebElement deleteTask;

    @FindBy(css = "body > section > div > section > ul > li > div > label")
    WebElement todoEdit;

    @FindAll({
            @FindBy(css = ".toggle")
    })
    List<WebElement> allTasksToggle;

    @FindBy(css = ".clear-completed")
    WebElement clearCompleted;

    public MVCPage(WebDriver driver) {
        // whats happening behing the scenes
        // looks very interesting
        PageFactory.initElements(driver, this);
    }

    public void enterTask(String taskText) {
        newTodoLine.sendKeys(taskText, Keys.ENTER);
    }

    public void enterTaskText(WebElement task, String text) {
        task.sendKeys(text, Keys.ENTER);
    }

}

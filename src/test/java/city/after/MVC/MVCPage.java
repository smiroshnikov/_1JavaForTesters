package city.after.MVC;


/*
Selenium TOTO MVC  - Sanity Flow
Create task
Update task content
Mark as completed
UnMark completion
Add random amount of tasks with random text
Mark all as complete
Clear completed
Delete Task
TODO ---> fix selectors
TODO ---> counter , Active filter, Completed filter, maybe performance stretch , maybe ....
TODO ---> multi-lined task with universal selector

 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MVCPage {

    @FindBy(css = ".new-todo")
    WebElement newTodoLine;

    @FindBy(css = ".toggle")
    WebElement toggleCompletion;

    @FindBy(xpath = "//div/button")
    WebElement deleteTask;


    //@FindBy(className = "edit")
    @FindBy(css = "body > section > div > section > ul > li > div > label")
    WebElement todoEdit;

    // bad selector above , better selector below not working
    //@FindBy(css = ".edit")
    //@FindBy(className = "edit")
    //@FindBy(css = "//*[contains(@class, 'edit')]")

    // FIXEN PARTIZANEN ! guess it is related to mouse-over above element first
    @FindBys({@FindBy(className = "main"),
            @FindBy(className = "todo-list"),
            @FindBy(css = "li"),
            @FindBy(className = "edit")})
    WebElement todoEditFullPath;


    @FindAll({
            @FindBy(css = ".toggle")
    })
    List<WebElement> allTasksToggle;

    @FindBy(css = ".clear-completed")
    WebElement clearCompleted;

    public MVCPage(WebDriver driver) {
        // whats happening behing the scenes ?
        PageFactory.initElements(driver, this);
    }

    public void enterTask(String taskText) {
        newTodoLine.sendKeys(taskText, Keys.ENTER);
    }

    // this method is useless , either fix or remove
    public void enterTaskText(WebElement task, String text) {
        task.sendKeys(text, Keys.ENTER);
    }

}

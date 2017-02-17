package city.after.MVC;


/*
Selenium TOTO MVC  - Sanity Flow
Create task [DONE]
Update task content [DONE]
Mark as completed [DONE]
UnMark completion [DONE]
Add random amount of tasks with random text [DONE]
Mark all as complete one by one [DONE]
Clear completed [DONE]
Delete Task   [DONE]


TODO ---> fix selectors
TODO ---> separate selectors and clickers to two separate classes : "SelectorHelpers"  and "ClickerHelpers"
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

    @FindBy(xpath = "/html/body/section/div/section/ul/li[1]/div/button")
    //div[label[text()='ewfwet']]/button
    WebElement deleteButton;

    @FindBy(css = ".new-todo")
    WebElement newTodoLine;

    @FindBy(css = ".toggle")
    WebElement toggleCompletion;

    //@FindBy(xpath = "//div/button")
    //@FindBy(css = ".destroy")
    //@FindBy(xpath = "//*[contains(@class,'destroy')]")
    @FindBy(css = "button[class]")
    WebElement deleteTask;

    //@FindBy(className = "edit")
    //@FindBy(xpath = "//*[contains(@class, 'edit')]")
    @FindBy(css = "body > section > div > section > ul > li > div > label")
    WebElement todoEdit;

    // bad selector above , better selector below not working
    //@FindBy(css = ".edit")
    //@FindBy(className = "edit")
    //@FindBy(xpath = "//*[contains(@class, 'edit')]")
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

    @FindAll({
            @FindBy(xpath = "//ul[contains(@class, 'filters')]//a")})
    List<WebElement> filterButtons;
    // FIXEN PARTIZANEN


    @FindBy(css = ".clear-completed")
    WebElement clearCompletedTasks;

    /**
     * Constructor that instantiates page via PageFactory
     *
     * @param driver - current Webdriver instance
     */

    public MVCPage(WebDriver driver) {
        // whats happening behing the scenes ?
        PageFactory.initElements(driver, this);
    }


    /**
     * Creates a new task with provided text
     *
     * @param taskText - text to be entered
     */
    public void enterTask(String taskText) {
        newTodoLine.sendKeys(taskText, Keys.ENTER);
    }


    public void enterTaskText(WebElement task, String text) {
        task.sendKeys(text, Keys.ENTER);
    }

    public void markAllTasksOnScreenAsCompleted() {
        for (WebElement t :
                allTasksToggle) {
            t.click();
        }
    }

    public void clickActiveFilter() {

        WebElement activeFilter = filterButtons.get(1);
        activeFilter.click();
    }


    public void clickAllFilter() {
        WebElement allFilter = filterButtons.get(0);
        allFilter.click();
    }

    public void clickCompletedFilter() {
        WebElement completedFilter = filterButtons.get(2);
        completedFilter.click();
    }

    /**
     * Presses "Clear Coimpleted" button @ the lower left corner of the web-app
     */
    public void clickClearCompletedBulkControl() {
        clearCompletedTasks.click();
    }

    public void toggleSingleTaskCompletion() {
        toggleCompletion.click();
    }

    public void pressDeleteTask() {
        deleteTask.click();
    }

    public void clickOnTask() {
        todoEdit.click();
        //todoEditFullPath.click();

    }

}

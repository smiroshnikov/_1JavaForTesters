package remake.MVC2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * MVC locators and interaction with locators is implementted here
 */
public class MVCPage {
    /*
    TODO review this code in a month and ask yourself the question below.
    Is it really that comfortable and manageble and readable as it feels @02/2017 ?
     if (NOT) {
        REWRITE EVERYTHING ALL OVER AGAIN ! UNTILL ITS PERFECT!
     }
    TODO lets make same E2E on python3 and feel if its really faster dev time
     */

    @FindBy(className = "toggle-all")
    private WebElement toggleAll;

    @FindBy(className = "toggle")
    private WebElement toggleTask;

    @FindBy(className = "todo-count")
    private WebElement todoCount;

    //@FindBy(css = ".new-todo")
    @FindBy(className = "new-todo")
    private WebElement newTodo;

    @FindBy(className = "todo-list")
    private WebElement firstTodo;


    @FindAll({@FindBy(className = "todo-list")})
    private List<WebElement> todoList;

    @FindBy(xpath = "//div[label[text()='delete me']]/button[@class='destroy']")
    private WebElement hardCodedDeleteButton;

    @FindBy(css = "button[class]")
    private WebElement deleteButton;

    @FindAll({
            @FindBy(className = "toggle")
    })
    private List<WebElement> allPossibleToggles;

    @FindBy(css = ".clear-completed")
    private WebElement clearCompleted;

    @FindAll({
            @FindBy(xpath = "//ul[contains(@class,'filters')]//a")
    })
    List<WebElement> taskFilters;

    @FindBy(xpath = "//li/a[contains(text),'Active']")
    WebElement filterActive;

    @FindBy(xpath = "//li/a[contains(text),'Completed']")
    WebElement filterCompleted;

    @FindAll({
            @FindBy(css = ".todo-list>.completed")
    })
    List<WebElement> completedElementsPresent;

    @FindAll({
            @FindBy(css = ".view>label")
    })
    List<WebElement> activeElementsPresent;

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


    public MVCPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewTodo(String text) {
        newTodo.sendKeys(text, Keys.ENTER);
    }

    public void enterTaskText(WebElement task, String text) {
        task.sendKeys(text, Keys.ENTER);
    }

    public WebElement findTodoByText(String text) {
        // the funny part is that this selector is too complex , and messes up assertion
        WebElement result = null;
        for (WebElement todo :
                todoList) {
            result = todo.findElement(By.xpath(String.format("//li/div[@class='view']/label[contains(text(),'%s')]", text)));
        }
        return result;
    }

    public void deleteTask(String task) {
        findTodoByText(task).click();
        deleteButton.click();

    }

    /**
     * extracts string representation of task counter element on a page
     *
     * @return number of tasks omiting other characters besides digits as a String
     * e.g instead of "51 items left" returns "51"
     */
    public String getTodoCounterFromFooter() {
        return (todoCount.getText().replaceAll("\\D+", ""));
    }

    public void toggleTask(String taskText) {
        //findTodoByText(taskText).findElement(By.className("toggle")).click();
        toggleTask.click();
    }

    public void massEnTogglement() {
        for (WebElement t :
                allPossibleToggles) {
            t.click();

        }
    }

    public void clickClearCompleted() {
        clearCompleted.click();
    }

    public void filterAll() {
        taskFilters.get(0).click();
    }

    public void filterActive() {
        taskFilters.get(1).click();
    }

    public void filterCompleted() {
        taskFilters.get(2).click();
    }

    public int countCompletedTodos() {
        return completedElementsPresent.size();
    }

    public int countActiveTasks() {
        return activeElementsPresent.size();
    }

}

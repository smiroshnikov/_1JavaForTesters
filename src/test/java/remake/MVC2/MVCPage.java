package remake.MVC2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * MVC locators and interaction with locators is implementted here
 */
public class MVCPage {
    /*
    Is it really that comfortable and manageble here ?
    TODO lets make it on python and see the difference
     */

    @FindBy(css = ".new-todo")
    private WebElement newTodo;

    @FindBy(className = "todo-list")
    private WebElement firstTodo;

    @FindAll({@FindBy(className = "todo-list")})
    private List<WebElement> todoList;

    @FindBy(xpath = "//div[label[text()='delete me']]/button[@class='destroy']")
    private WebElement hardCodedDeleteButton;
    // yes I hate hardcoded values , so either use cool annotations or
    // write a separate fubction

    @FindBy(css = "button[class]")
    private WebElement deleteButton;


    public MVCPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewTodo(String text) {
        newTodo.sendKeys(text, Keys.ENTER);
    }

    public WebElement getFirstTodo() {
        return firstTodo;
    }

    public WebElement findTodoByText(String text) {
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


}

package remake.MVC2;

import org.openqa.selenium.By;
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

    @FindBy(className = "new-todo")
    WebElement newTodo;
    @FindAll({@FindBy(className = "todo-list")})
    List<WebElement> todoList;

    public MVCPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement findTodo(String text) {
        WebElement result = null;
        for (WebElement todo :
                todoList) {
            result = todo.findElement(By.xpath(String.format("//li/div[@class='view']/label[contains(text(),%s)]", text)));
        }
        return result;
    }


}

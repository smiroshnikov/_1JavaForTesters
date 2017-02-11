package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * "TODO MVC test
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TODOmvcTest extends BaseTest {

    MVCPage mvcPage = new MVCPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(TEST_URL);
        driver.manage().window().maximize();
    }


    @Test
    public void caddMultipleTasks() {
        for (int i = 0; i < getRandFromMinToMax(20, 100); i++) {
            mvcPage.enterTask(getRandWord());
        }
    }

    @Test
    public void dmarkAllAsCompleted() {
        for (WebElement t :
                mvcPage.allTasksToggle) {
            t.click();
        }
    }

    @Test
    public void eclearCompleted() {
        mvcPage.clearCompleted.click();
    }

    @Test
    public void aAddTask() {
        mvcPage.enterTask("Молоко ");
    }

    @Test
    public void bTaskToEdit() {
        Actions action = new Actions(driver);
        action.doubleClick(mvcPage.todoEdit).perform();
        driver.findElement(By.className("edit"))
                .sendKeys(" и банан ", Keys.ENTER);
    }
}

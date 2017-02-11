package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * "TODO MVC test
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Any other way ?
public class TODOmvcTest extends BaseTest {

    MVCPage mvcPage = new MVCPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(TEST_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void e_AddMultipleTasks() {
        for (int i = 0; i < generateRandomValueBetweenMinToMax(20, 100); i++) {
            mvcPage.enterTask(generateRandomWordWith_HEB_ENG_Charsets());
        }
    }

    @Test
    public void f_MarkAllAsCompleted() {
        for (WebElement t :
                mvcPage.allTasksToggle) {
            t.click();
        }
    }

    @Test
    public void g_ClearCompleted() {
        mvcPage.clearCompleted.click();
    }

    @Test
    public void a_AddTask() {
        mvcPage.enterTask("Молоко ");
        // this is over complicating , but a valid selection as well, keep it here
        // I might have a better idea later on
        // mvcPage.enterTaskText(mvcPage.newTodoLine, "Milk");

    }

    @Test
    public void b_UpdateTask() {
        //Actions action = new Actions(driver);
        // does action gooutside ? , to BaseTest?
        action.doubleClick(mvcPage.todoEdit).perform();
        //doADoubleClick(mvcPage.todoEdit);
        // Why do i need to locate this element again ?
        driver.findElement(By.className("edit"))
                .sendKeys(" и банан ", Keys.ENTER);

    }

    @Test
    public void c_CompleteUpdatedTask() {
        mvcPage.toggleCompletion.click();

    }

    @Test
    public void d_UnClearUpdatedTaskAndClearAgain() throws InterruptedException {
        mvcPage.toggleCompletion.click();
        mvcPage.toggleCompletion.click();
    }

    @Test
    public void h_deleteTask() {
        //Actions action = new Actions(driver);
        // had to move , had to click , and had to delete
        action.moveToElement(mvcPage.todoEdit);
        mvcPage.todoEdit.click();
        mvcPage.deleteTask.click();
    }
}

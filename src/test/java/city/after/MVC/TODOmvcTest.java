package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

/**
 * TODO remove ordering
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Any other way ?
public class TODOmvcTest extends BaseTest {

    MVCPage mvcPage = new MVCPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(TEST_URL);
        driver.manage().window().maximize();
    }

//    @Test
//    public void e_AddMultipleTasks() {
//        for (int i = 0; i < generateRandomValueBetweenMinToMax(20, 100); i++) {
//            mvcPage.enterTask(generateRandomWordWith_HEB_ENG_Charsets());
//        }
//    }

//    @Test
//    public void f_MarkAllAsCompleted() {
//        for (WebElement t :
//                mvcPage.allTasksToggle) {
//            t.click();
//        }
//    }
//
//    @Test
//    public void g_ClearCompleted() {
//        mvcPage.clearCompleted.click();
//    }

    @Test
    public void a_AddTask() {
        mvcPage.enterTask("Молоко ");
        // this is over complicating , but a valid selection as well, keep it here
        // I might have a better idea later on
        // mvcPage.enterTaskText(mvcPage.newTodoLine, "Milk");
    }

    @Test
    public void b_UpdateTask() {
        Actions action = new Actions(driver);
        // does action go outside ? , to BaseTest? Separate  clicker selector class class select from drop list

        action.doubleClick(mvcPage.todoEdit).perform();
        //mvcPage.todoEdit.sendKeys("Blah blah", Keys.ENTER);
        //doADoubleClick(mvcPage.todoEdit);
        // Why do i need to locate this element again ?
        driver.findElement(By.className("edit"))
                .sendKeys(" и банан ", Keys.ENTER);
        //action.moveToElement(mvcPage.deleteButton).click();
    }

    @Test
    public void c_AnyaDelete() {
        mvcPage.deleteButton.click();
        // mvcPage.deleteTask;
    }

//    @Test
//    public void c_CompleteUpdatedTask() {
//        mvcPage.toggleCompletion.click();
//
//    }
//
//    @Test
//    public void d_UnClearUpdatedTaskAndClearAgain() throws InterruptedException {
//        mvcPage.toggleCompletion.click();
//        // move to base test , replace with wait(int seconds)
//        Thread.sleep(5000); // no point use this in real test
//        mvcPage.toggleCompletion.click();
//
//
//    }

}

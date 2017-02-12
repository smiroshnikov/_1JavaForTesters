package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

/**
 * "TODO MVC test
 * TODO all tests are independent
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Damn JAVA ! Need to read documentation regarding Java compiler
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

        doADoubleClick(mvcPage.todoEdit);
        mvcPage.enterTaskText(mvcPage.todoEditFullPath, " и банан ");
        // Very interesting bug in here , when line gets bigger like
        // a lot of content, delete button moves and completion of single task
        // and deletion of single task gets fucked up
    }

    @Test
    public void c_CompleteUpdatedTask() {
        mvcPage.toggleCompletion.click();

    }

    @Test
    public void d_UnClearUpdatedTaskAndClearAgain() {
        // I need even numbers here , jumpimg to another test
        mvcPage.toggleCompletion.click();
        mvcPage.toggleCompletion.click();
    }

    @Test
    public void h_deleteActiveTask() {
        // had to move , had to click , and had to delete
        action.moveToElement(mvcPage.todoEdit);
        mvcPage.todoEdit.click();
        mvcPage.deleteTask.click();
    }

    @Test
    public void i_filterActiveTasks() {


    }

}

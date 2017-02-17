package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * TODO ----> all tests flows should be  independent and not based on each other
 * TODO ----> remove moveToElement to mvcPage class
 * TODO ----> reporting , allure might be very good candidate
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// Damn JAVA ! Need to read documentation to understand why JUnit execution is considered not determined
public class TODOmvcTest extends BaseTest {

    MVCPage mvcPage = new MVCPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(TEST_URL);
        maximizeWindow();
    }

    @Test
    public void a_AddTask() {
        mvcPage.enterTask("Task ");
    }

    @Test
    public void b_UpdateTask() {
        mvcPage.enterTask("new task ");
        doADoubleClick(mvcPage.todoEdit);
        mvcPage.enterTaskText(mvcPage.todoEditFullPath, " text is updated ");
        // Very interesting bug in here , when line gets bigger like
        // a lot of content, delete button moves and completion of single task
        // and deletion of single task gets fucked up
    }

    @Test
    public void f_CompleteAndCancelCompletion() {
        mvcPage.enterTask("Complete and UnComplete");
        mvcPage.toggleSingleTaskCompletion();
        mvcPage.toggleSingleTaskCompletion();
    }

    @Test
    public void d_AddMultipleTasksAndCompleteAndClear() {
        for (int i = 0; i < generateRandomValueBetweenMinToMax(40, 100); i++) {
            mvcPage.enterTask(generateRandomWordWith_HEB_ENG_Charsets());
        }
        mvcPage.markAllTasksOnScreenAsCompleted();
        mvcPage.clickClearCompletedBulkControl();
    }

    @Test
    public void c_deleteActiveTask() {
        mvcPage.enterTask("Delete me ! I am active");
        //Thread.sleep(1000);
        hoverOverAnElement(mvcPage.todoEdit);
        mvcPage.clickOnTask();
        mvcPage.pressDeleteTask();
    }

    //    @Test
//    public void d_UnClearUpdatedTaskAndClearAgain() {
//        // I need even numbers here , because I am jumping to another test
//        // need to chech how things work in junit and Selenium
//        mvcPage.toggleCompletion.click();
//        mvcPage.toggleCompletion.click();
//    }
//
//    @Test
//    public void h_deleteActiveTask() {
//        // had to move , had to click , and had to delete
//        // fix this
//        action.moveToElement(mvcPage.todoEdit);
//        mvcPage.todoEdit.click();
//        mvcPage.deleteTask.click();
//    }
//

    @Test
    public void g_filterActiveCompletedAllTasks() {
        mvcPage.enterTask(" task is done - clear me!");
        mvcPage.enterTask(" task is done - clear me!");
        mvcPage.enterTask(" task is done - clear me!");
        mvcPage.enterTask(" task is done - clear me!");
        mvcPage.markAllTasksOnScreenAsCompleted();
        mvcPage.enterTask(" task is active - filter me!");
        mvcPage.enterTask(" task is active - filter me!");
        mvcPage.enterTask(" task is active - filter me!");
        mvcPage.enterTask(" task is active - filter me!");

        mvcPage.clickActiveFilter();
        //assert
        mvcPage.clickCompletedFilter();
        //assert
        mvcPage.clickAllFilter();
        // assert
        mvcPage.clearCompletedTasks.click();

        mvcPage.markAllTasksOnScreenAsCompleted();
        mvcPage.clearCompletedTasks.click();
    }
}

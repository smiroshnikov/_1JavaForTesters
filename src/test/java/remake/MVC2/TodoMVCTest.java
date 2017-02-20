package remake.MVC2;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * E2E test
 * 1. create new task
 * 2. edit taks
 * 3. mark as complete
 * 4. un-mark completion
 * 5. delete active task
 * 6. delete completed task
 * 7. populate list with multiple tasks
 * 8.
 * 9.
 * Base(before) test might include pre-made tasks ? (not sure)
 * After should have all tasks marked as clear ? (not sure)
 */

public class TodoMVCTest extends BaseTest {

    @Rule
    public ScreenshotOnFailed scrFailedRule = new ScreenshotOnFailed(driver, testName);

    MVCPage page = new MVCPage(driver);

    @BeforeClass
    public static void openPage() {
        open(REACT_URL);
        maximizeWindow();
    }

    @Test
    public void createANewTask() {
        System.out.printf("starting test %s", testName);
        String taskText = "First task";
        page.createNewTodo(taskText);
        assertThat("Task text mismatch", page.findTodoByText(taskText).getText(),
                is("Momo"));
    }

    @Test
    public void createAndDeleteTask() {
        String task = "Task to be deleted";
        page.createNewTodo(task);
        hoverOverAnElement(page.findTodoByText(task));
        //if (page.findTodoByText(task).isDisplayed()) {
        if (page.findTodoByText("mumumu").isDisplayed()) {
            page.deleteTask(task);
        }
    }

    @Test
    public void createMultipleTasks() {
        for (int i = 0; i < randomValueBetweenMinMax(50, 100); i++) {
            page.createNewTodo(randomWord_HE_ENG_Charset());
        }
    }


}

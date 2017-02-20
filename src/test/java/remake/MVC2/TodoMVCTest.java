package remake.MVC2;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * E2E test
 * [Sprint 1 - 18/0/2017]
 * 1. create new task [V]
 * 2. edit task [X]
 * 3. mark as complete [X]
 * 4. un-mark completion[X]
 * 5. delete active task[V]
 * 6. delete completed task
 * 7. populate list with multiple tasks and validate task count
 * 8. Execution order solves a lot of interesting issues - so far leave as is , later think
 * [Sprint 2 - 19/0/2017]
 * 8.Add utility class to take screenshot if failed (implement via Junit TestWatcher)
 * 9.
 * [Sprint 3 - 20/0/2017 - 21/2/2017]
 * 10. Reporting
 * [Sprint 3 - 23/0/2017]
 * 11 Report automated sending via SendGrid or JetMail
 * Base(before) test might include pre-made tasks ? (not sure if I want to clear the task board before each run ,
 * and if I do, how it will be implemented ? Using tests delete and clear ? :(  )
 * Consider pre-test steps like existing tasks ?
 */

public class TodoMVCTest extends BaseTest {

    @Rule
    public ScreenshotOnFailed scrFailedRule = new ScreenshotOnFailed(driver, testName);

    public MVCPage page = new MVCPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(REACT_URL);
        maximizeWindow();
    }


    @Test
    public void createANewTask() {
        String taskText = "First task";
        page.createNewTodo(taskText);
        assertThat("Task text mismatch", page.findTodoByText(taskText).getText(),
                is(taskText));
    }

    @Test
    public void createAndDeleteTask() {
        String task = "Task to be deleted, Delete Me !";
        page.createNewTodo(task);
        hoverOverAnElement(page.findTodoByText(task));
        if (page.findTodoByText(task).isDisplayed()) {
            page.deleteTask(task);
        }
    }

    @Test
    /**
     * jhasgdjhagd
     */
    public void completeAndUncompleteTask() {
        String taskText = "toggle me as complete";
        page.createNewTodo(taskText);
        // toggle completed
        page.toggleTask(taskText);
        assertThat("Not expecting to see any tasks ", page.getTodoCounter(), is(String.valueOf(0)));
        // untoggle to active
        page.toggleTask(taskText);
        assertThat("Expecting to see single task active", page.getTodoCounter(), is(String.valueOf(1)));

    }

    @Test
    public void createMultipleTasks() {
        int expectedTasks = randomValueBetweenMinMax(50, 100);
        for (int i = 0; i < expectedTasks; i++) {
            page.createNewTodo(randomCharsetMix());
        }
        assertThat("todo counters mismatch!", page.getTodoCounter(), is(String.valueOf(expectedTasks)));
    }

    @Test
    public void filterActiveCompletedAllTasks() {

    }


}

package remake.MVC2;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
 * TODO separate each test to a class and stop fighting windmill!
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void a_CreateAndDeleteActiveTask() {
        String taskText = "Task to be deleted, Delete Me !";
        page.createNewTodo(taskText);
        hoverOverAnElement(page.findTodoByText(taskText));
        if (page.findTodoByText(taskText).isDisplayed()) {
            page.deleteTask(taskText);
        }
        // point of interest ! How to validate ? DB?
        //assertThat("Not expecting to see any tasks ", page.getTodoCounter(), is(String.valueOf(0)));
    }

    @Test
    public void b_CreateAndDeleteCompleteTask() {
        String taskText = "Task to be completed and deleted!";
        page.createNewTodo(taskText);
        page.toggleTask(taskText);
        hoverOverAnElement(page.findTodoByText(taskText));
        if (page.findTodoByText(taskText).isDisplayed()) {
            page.deleteTask(taskText);
        }
        // point of interest ! How to validate ? DB?
        //assertThat("Not expecting to see any tasks ", page.getTodoCounter(), is(String.valueOf(0)));
    }

    /**
     * Toggles the task twice marking it as complete for the first time
     * and active second time
     */
    @Test
    public void c_CompleteAndUncompleteTask() {
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
    public void d_CreateMultipleTasksAndCompleteOneByOneAndClear() {
        int expectedTasks = randomValueBetweenMinMax(50, 100);
        for (int i = 0; i < expectedTasks; i++) {
            String taskText = randomCharsetMix();
            page.createNewTodo(taskText);
        }
        assertThat("todo counters mismatch!", page.getTodoCounter(), is(String.valueOf(expectedTasks)));
        page.massEnTogglement();
        assertThat("todo counters mismatch!", page.getTodoCounter(), is(String.valueOf(0)));
        page.clickClearCompleted();
    }


    @Test
    public void filterActiveCompletedAllTasks() throws InterruptedException {
        page.createNewTodo("Complete me 1");
        page.createNewTodo("Complete me 2");
        page.createNewTodo("Complete me 3");
        page.massEnTogglement();
        page.createNewTodo("I am still active 1!");
        page.createNewTodo("I am still active 2!");
        page.createNewTodo("I am still active 3!");
        page.createNewTodo("I am still active 4!");
        page.createNewTodo("I am still active 5!");

        // TODO validate
        page.filterCompleted();
        page.filterActive();
        page.filterAll();
    }

}

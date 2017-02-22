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
 * 2. edit task [V]
 * 3. mark as complete [V]
 * 4. un-mark completion[V]
 * 5. delete active task[V]
 * 6. delete completed task [V]
 * 7. populate list with multiple tasks and validate task count [V]
 * 8. Execution order solves a lot of interesting issues - so far leave as is , later think
 * [Sprint 2 - 19/0/2017]
 * 8.Add utility class to take screenshot if failed (implement via Junit TestWatcher) [V]
 * 9.***** intervew - take a break
 * [Sprint 3 - 24/0/2017 - 28/2/2017]
 * 10. Reporting
 * [Sprint 4 - 01/03/2017]
 * 11 Report automated sending via SendGrid or JetMail
 * Base(before) test might include pre-made tasks ? (not sure if I want to clear the task board before each run ,
 * and if I do, how it will be implemented ? Using tests delete and clear ? :(  )
 * Consider pre-test steps like existing tasks ?
 * TODO separate each test to a class execute with maven on remote machine
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
        //assertThat("Not expecting to see any tasks ", page.getTodoCounterFromFooter(), is(String.valueOf(0)));
        // all elements disappear and I have no idea how to validate this ,
        // pretty sure Ronen will ask me what can be improved and will ask me to implement
        // this problematic feature !
    }

    @Test
    public void b_CreateAndDeleteCompletedTask() {
        String taskText = "Task to be completed and deleted!";
        page.createNewTodo(taskText);
        page.toggleTask(taskText);
        hoverOverAnElement(page.findTodoByText(taskText));
        if (page.findTodoByText(taskText).isDisplayed()) {
            page.deleteTask(taskText);
        }
        // point of interest ! How to validate ? DB?
        //assertThat("Not expecting to see any tasks ", page.getTodoCounterFromFooter(), is(String.valueOf(0)));
        // the line above will not work , because every elemnt of page disappears after deletion
        // can be tested in *STUPID* scenario like have 5 task delete 1 expect 4 , but that is boring and
        // not really nessesery because its easy and boring and I have to leave something simple for an interview
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
        assertThat("Not expecting to see any tasks ", page.getTodoCounterFromFooter(), is(String.valueOf(0)));
        // untoggle to active
        page.toggleTask(taskText);
        assertThat("Expecting to see single task active", page.getTodoCounterFromFooter(), is(String.valueOf(1)));
    }

    @Test
    public void d_CreateMultipleTasksAndCompleteOneByOneAndClear() {
        int expectedTasks = randomValueBetweenMinMax(50, 100);
        for (int i = 0; i < expectedTasks; i++) {
            String taskText = randomCharsetMix();
            page.createNewTodo(taskText);
        }
        assertThat("todo counters mismatch!", page.getTodoCounterFromFooter(), is(String.valueOf(expectedTasks)));
        page.massEnTogglement();
        assertThat("todo counters mismatch!", page.getTodoCounterFromFooter(), is(String.valueOf(0)));
        page.clickClearCompleted();
    }


    @Test
    public void e_FilterActiveCompletedAllTasks() {
        page.createNewTodo("Complete and Uncomplete me 1");
        page.createNewTodo("Complete me 2");
        page.createNewTodo("Complete me 3");
        page.massEnTogglement();
        page.createNewTodo("I am still active 1!");
        page.createNewTodo("I am still active 2!");
        page.createNewTodo("I am still active 3!");
        page.createNewTodo("I am still active 4!");
        page.createNewTodo("I am still active 5!");
        page.filterCompleted();
        assertThat(page.countCompletedTodos(), is(3));
        page.filterActive();
        assertThat(page.countActiveTasks(), is(5));
        page.filterAll();
        page.toggleTask("Complete and Uncomplete me 1");
        // todo change assertion - get a better xpath for all elements on page , regardless of active / completed
        assertThat(page.getTodoCounterFromFooter(), is(String.valueOf(6)));
    }

    @Test
    public void editExistingActiveTask() {
        String taskText = "banana";
        String additionalTaskText = " and milk";
        page.createNewTodo(taskText);
        hoverOverAnElement(page.findTodoByText(taskText));
        if (page.findTodoByText(taskText).isDisplayed()) {
            doADoubleClick(page.findTodoByText(taskText));
            page.enterTaskText(page.todoEditFullPath, additionalTaskText);
        }
        // TODO assertion solution , probably XPATH  get on that lecture already
        //assertThat(page.findTodoByText("banana and milk"), is(taskText + additionalTaskText));
    }

    @Test
    public void editExistingCompleteTask() {
        String taskText = "pineapple";
        String additionalTaskText = " pen";
        page.createNewTodo(taskText);
        page.toggleTask(taskText);
        hoverOverAnElement(page.findTodoByText(taskText));
        if (page.findTodoByText(taskText).isDisplayed()) {
            doADoubleClick(page.findTodoByText(taskText));
            page.enterTaskText(page.todoEditFullPath, additionalTaskText);
        }
        //TODO assertion
    }
}

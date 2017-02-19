package remake.MVC2;

import org.junit.BeforeClass;
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

    MVCPage page = new MVCPage(driver);

    @BeforeClass
    public static void openPage() {
        open(REACT_URL);
        maximizeWindow();
    }

    @Test
    public void createANewTask() {
        String taksText = randomWord_HE_ENG_Charset();
        page.createNewTodo(taksText);
        assertThat(page.findTodo(taksText).getText(), is(taksText));
        takeScreenshot();
    }


}

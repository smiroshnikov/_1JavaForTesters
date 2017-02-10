package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

/**
 * "TODO MVC test
 */
public class TODOmvcTest extends BaseTest {

    MVCPage mvcPage = new MVCPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(TEST_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void addTask() {
        mvcPage.enterTask("Commit Code ! ");
    }

    @Test
    public void addMultipleTasks() {
        for (int i = 0; i < getRandFromMinToMax(20, 40); i++) {
            mvcPage.enterTask(getRandWord());
        }
    }

    @Test
    public void markAllAsCompleted() {
        for (WebElement t :
                mvcPage.allTasksToggle) {
            t.click();
        }

    }


}

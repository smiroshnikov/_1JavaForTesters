package city.after;

import org.junit.BeforeClass;
import org.junit.Test;

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
        for (int i = 0; i < getRandFrom1to20(); i++) {
            mvcPage.enterTask(getRandWord());
        }

    }


}

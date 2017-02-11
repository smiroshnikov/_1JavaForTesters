package city.after.MVC;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    public void editTask() {
        // TODO solve this ! keep solving
        Actions action = new Actions(driver);
        WebElement todoView = driver.findElement(By.cssSelector("body > section > div > section > ul > li > div > label"));

        action.doubleClick(todoView).perform();
        driver.findElement(By.className("edit"))
                .sendKeys(" blah blah ", Keys.ENTER);
    }

//    @Test
//    public void addMultipleTasks() {
//        for (int i = 0; i < getRandFromMinToMax(20, 100); i++) {
//            mvcPage.enterTask(getRandWord());
//        }
//    }
//
//    @Test
//    public void markAllAsCompleted() {
//        for (WebElement t :
//                mvcPage.allTasksToggle) {
//            t.click();
//        }
//    }
//
//    @Test
//    public void clearCompleted() {
//        mvcPage.clearCompleted.click();
//    }


}

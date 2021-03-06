package Selenium_WebDriver_ARichardson.exploration.minus1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * todoMVC proof of concept, don't have time for Object Page and Page Factory beauty
 * This is a simple sanity test plan that I am writing @22:32 night before interview
 * Every test will inclde result validation , for now with assertions ,
 * Test 1 - Create a task
 * Test 2 - Create Multiple tasks (with Random Strings just for the fun ) , check "items left counter"
 * Test 3 - Mark task as complete
 * Test 4 - Mark all tasks as comlete
 * Test 5 - Mark completed task as uncomplete
 * Test 6 - Delete Task
 * Test 7 - Delete all
 * Test 8 - Switch to Active count
 * Test 9 - Switch to Completed
 * TODO migrate to Page Objects and Page Factory Later on ...
 */

public class TodOMVCTest {
    private static final String CHROME_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static final String EDGE_DRIVER_PATH = "C:\\webdrivers\\MicrosoftWebDriver.exe";
    private static WebDriver driver;

    @BeforeClass
    public static void setUpDriver() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        }
        if (System.getProperty("webdriver.edge.driver") == null) {
            System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
        }
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void closeDriver() {
        //driver.close();
    }

    @Test
    public void createTasks() {
        //Configuration.browser = "chrome";
        //open("http://todomvc.com/examples/troopjs_require/");
        // apparently when i was missing "#" in link , my flow was fucked up . Its only 00-05 glad it took only aboout an hour !
        // sendKeys(Keys.Enter) was completely ignored
        driver.get("http://todomvc.com/examples/react/#/");
        driver.manage().window().maximize();
        // different slector , just test my css skills :)
        //WebElement newTodo = driver.findElement(By.className("new-todo"));
        WebElement newTodo = driver.findElement(By.cssSelector(".new-todo"));
        newTodo.sendKeys("Write a todo list - delete me later ");
        newTodo.sendKeys(Keys.RETURN);
        newTodo.sendKeys("Go to sleep, and sleep 6 hours at least");
        newTodo.sendKeys(Keys.RETURN);
        newTodo.sendKeys("get a Java job offer :)");
        newTodo.sendKeys(Keys.RETURN);
        newTodo.sendKeys("Improve my Java and Selenium skills");
        newTodo.sendKeys(Keys.RETURN);

        List<WebElement> tasks = driver.findElements(By.cssSelector(".todo-list li label"));
//        // finally
//        for (WebElement task :
//                tasks) {
//            System.out.printf("task text : %s %n", task.getText());
//        }
//        Thread.sleep(1000); // replace with WebDriverWait and until this is too ugly and not needed
        assertThat("Expecting a first task text ", tasks.get(0).getText(), is("Write a todo list - delete me later"));
        assertThat("expecting total of 4 tasks", tasks.size(), is(4));
//        WebElement deleteButton = driver.findElement(By.cssSelector(".toggle"));
//        deleteButton.click();

        List<WebElement> completeButtons = driver.findElements(By.cssSelector(".toggle"));
        // works
        //deleteButtons.get(2).click();
        for (WebElement taskComletion :
                completeButtons) {
            taskComletion.click();
        }
    }

//    @Test
//    public void deleteTaskSingleElement() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("/html/body/section/div/section/ul/li[1]/div/label")));
//        WebElement deleteButton = driver.findElement(By.cssSelector(".destroy"));
//        deleteButton.click();
//    }


//    @Test
//    public void completeTasksFromWebElementList() {
//        List<WebElement> deleteButtons = driver.findElements(By.className(".toggle"));
//        deleteButtons.get(2).click();
//        deleteButtons.get(2).clear();
//    }


//    @Test
//    public void deleteTask() {
//    }

    @Test
    public void editExistingTask() {
        // too hard
        List<WebElement> tasks = driver.findElements(By.cssSelector(".todo-list li label"));
        //tasks.get(1).click();
        Actions action = new Actions(driver);
        action.doubleClick(tasks.get(1));
        action.perform();
        tasks.get(1).sendKeys(" more text ");
    }

}

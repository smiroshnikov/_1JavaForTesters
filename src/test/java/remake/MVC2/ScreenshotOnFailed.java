package remake.MVC2;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Utility class , that is required to force JUnit take screenshots on failure
 */
public class ScreenshotOnFailed extends TestWatcher {


    private WebDriver driver;
    private TestName testName;

    public ScreenshotOnFailed(WebDriver driver, TestName testName) {
        this.driver = driver;
        this.testName = testName;

    }

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("Execute screenshot here!");
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("c:\\Webdrivers\\screenshots\\" +
                    testName.getMethodName() + "_" + System.currentTimeMillis() + ".png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

}

package elemental.login;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogInTest extends BaseTest {

    public LoginPage lPage = new LoginPage(driver);

    @BeforeClass
    public static void setupURL() {
        open(HEROKU_LOGIN_URL);
        maximizeWindow();
    }

    @Test
    public void t() {
        while (true) {
            String user = "tomsmith";
            String password = "SuperSecretPassword!";
            WebElement uName = driver.findElement(By.id("username"));
            uName.click();
            uName.sendKeys(user);
            WebElement login = driver.findElement(By.id("password"));
            login.click();
            login.sendKeys(password);
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
            loginButton.click();
            // TODO assert login successful!
            WebElement notification = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
            //assertThat (notification.getText(),is("You logged into a secure area!\\n×"));
            assertTrue(notification.getText().startsWith("You logged into a secure area!"));
            WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
            logoutButton.click();
        }
    }


}

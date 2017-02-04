package SeleniumWebDriverRefresh.part0.D.minus4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class NavigationClassworkTest {

    private static WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "c:\\Webdrivers\\chromedriver.exe";
    private static final String PROTOCOL = "http";
    private static final String DOMAIN = "compendiumdev.co.uk";
    private static final String ROOT_URL = PROTOCOL + "://" + DOMAIN;


    @BeforeClass
    public static void setDriver() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        System.out.println("Chrome driver path set to \n" + System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }

    @Test
    public void navigateWithGet() {
        driver.get(ROOT_URL + "/selenium");
        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));
    }

    @Test
    public void navigateWithNAvigateTo() {
        driver.navigate().to(ROOT_URL + "/selenium/search.php");
        assertTrue(driver.getTitle().startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void navigateBackAndForward() {
        driver.navigate().to(ROOT_URL + "/selenium/basic_html_form.html");
        assertTrue(driver.getTitle().startsWith("HTML Form Elements"));

        driver.navigate().to(ROOT_URL + "/selenium/basic_web_page.html");
        assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));

        driver.navigate().back();
        assertTrue(driver.getTitle().startsWith("HTML Form Elements"));

        driver.navigate().forward();
        assertTrue(driver.getTitle().startsWith("Basic Web Page Title"));
    }

    @Test
    public void navigateWithRefresh() {
        driver.navigate().to(ROOT_URL + "/selenium/refresh.php");
        final String refreshTitleConstant = "Refreshed Page on ";
        assertTrue(driver.getTitle().startsWith(refreshTitleConstant));

        // separating epoch timestamp from the title
        long startTime = Long.parseLong(driver.getTitle().replaceFirst(refreshTitleConstant, ""));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {/*ignore interrupt*/}
        driver.navigate().refresh();
        assertTrue(driver.getTitle().startsWith(refreshTitleConstant));

        long endTime = Long.parseLong(driver.getTitle().replaceFirst(refreshTitleConstant, ""));
        // very fucking nice ! actually testing that title advances with time ! very nice true QA thinking !
        assertTrue("expected" + endTime + ">" + startTime, endTime > startTime);
        System.out.println("expected " + endTime + " > " + startTime);
    }


    @Ignore
    @Test
    public void navigateCompendiumdev() throws InterruptedException {
        driver.get("http://compendiumdev.co.uk/selenium");
        assertThat(driver.getTitle().contains("Selenium Simplified"), is(true));
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
        assertThat(driver.getTitle().equals("Selenium Simplified Search Engine"), is(true));
        Thread.sleep(2000);

        driver.navigate().back();
        assertThat(driver.getTitle().contains("Selenium Simplified"), is(true));
        Thread.sleep(2000);

        driver.navigate().forward();
        assertThat(driver.getTitle().equals("Selenium Simplified Search Engine"), is(true));
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_html_form.html");
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_web_page.html");
        Thread.sleep(2000);

        driver.navigate().to("http://compendiumdev.co.uk/selenium/refresh.php");
        driver.navigate().refresh();
        assertTrue("Epoch time differs", driver.getTitle().contains("Refreshed Page on " + Long.toString(System.currentTimeMillis()).substring(0, 8)));


        Thread.sleep(2000);
    }

    @Ignore
    @Test
    public void stringCastration() {
        String tooLong = "1486156774642";
        System.out.println(tooLong.substring(0, 9));
    }

    @Test
    public void interrogationPractice1() {
        driver.get("http://compendiumdev.co.uk/selenium/basic_web_page.html");
        assertThat(driver.getTitle().contains("Basic Web Page Title"), is(true));
        assertThat(driver.getCurrentUrl(), is("http://compendiumdev.co.uk/selenium/basic_web_page.html"));
        assertThat(driver.getPageSource().contains("A paragraph of text"), is(true));
        // Locating a web element
        WebElement para1 = driver.findElement(By.id("para1"));
        assertEquals(para1.getText(), "A paragraph of text");


    }


    @AfterClass
    public static void closeAndQuit() {
        driver.close();
        driver.quit();
    }

}

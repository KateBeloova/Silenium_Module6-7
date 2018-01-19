package Homework.Module7;

import Homework.Module7.pages.TrelloCreateBoard;
import Homework.Module7.pages.TrelloLoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverTest {

    private static final String DROPPABLE_TEST_URL = "https://trello.com/";
    private static final String LOGIN = "kateatmbelova@gmail.com";
    private static final String PASSWORD = "Testatm2017";
    private static final String TEST_URL = "https://getbootstrap.com/docs/4.0/components/navbar/";

    private static WebDriver driver;
    private static WebElement profile;

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    @BeforeClass(description = "Start browser")
    public void setDriver1() {
        System.setProperty("webdriver.chrome.driver", "D:\\ATM\\Homework\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        //driver.get(APIDOCS_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeClass(enabled = false)
    private static void setDriver() {

        //For Chrome
        System.setProperty("webdriver.chrome.driver","D:\\ATM\\Homework\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);

        // For IE
        //System.setProperty("webdriver.ie.driver","D:\\ATM\\Homework\\IEDriverServer.exe");
        //DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        //capabilities.setPlatform(Platform.WINDOWS);

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver = getDriver();
        driver.get(DROPPABLE_TEST_URL);
    }

    @Test(description = "Login to Trello account")
    public void loginToTrello() {

        new TrelloLoginPage(driver).openSignInPage().loginToTrello(LOGIN, PASSWORD);

        Assert.assertTrue(new TrelloCreateBoard(driver).openBoard().loginIsCorrect(), "Login failed");
        System.out.println("Login successfully.");
    }

    @Test(description = "Drag and drop(element-to-element)", dependsOnMethods = "loginToTrello", enabled = true)
    public void dragAndDrop() throws InterruptedException {

        WebElement draggable = driver.findElement(By.xpath("//span[@class ='list-card-title js-card-name'][contains(text(),'First')]"));
        WebElement droppable = driver.findElement(By.xpath("(//a[@class ='open-card-composer js-open-card-composer'])[2]"));

        new Actions(driver).dragAndDrop(draggable, droppable).perform();
    }

    @Test(description = "Drag element by XY-ofset coordinates", dependsOnMethods = "dragAndDrop", enabled = true)
    public void dragElement() throws InterruptedException {

        WebElement draggable = driver.findElement(By.xpath("//span[@class ='list-card-title js-card-name'][contains(text(),'Second')]"));

        new Actions(driver).dragAndDropBy(draggable, 240, -18).build().perform();
    }

    @Test(description = "Click on hidden element",dependsOnMethods = "loginToTrello", enabled = false)
    public void hiddenElement() throws InterruptedException {

        driver.get(TEST_URL);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('dropdown-item')[0].click()");
    }
}


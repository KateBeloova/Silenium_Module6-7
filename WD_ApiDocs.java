package Homework;


import Homework.pagefactory.ApiDocsLoginPage;
import Homework.pagefactory.ApiDocsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WD_ApiDocs {

        private static final String APIDOCS_URL = "https://amers1.apps.cp.reutest.com/Apps/APIDocs/1.726.1/#/";
        private static final String DOCSAPI = "//a[@class='category-api-item ng-binding'][contains(text(),'/definitions')]";
        private static final String SYMBAPI = "//a[@class='category-api-item ng-binding'][contains(text(),'/convert')]";
        private static final String TRYITBTN = "//span[@id='coral-button_label']/b[contains(text(),'Try it!')]";
        private static final String RETURN = "//div[@class='ng-scope']//a[@href='./']";
        private static final String SIGNINBTN = "//div[@class='button_img button_75 button_75_enabled'][contains(text(),'Sign In')]";
        private static final String LOGIN = "emqa16@thomsonreuters.com";
        private static final String PASSWORD = "Secret123";
        private static final String NEWS_LINK = "//a[@class='category-api-item ng-binding'][contains(text(),'/news-subscriptions')]";


        private WebDriver driver;

        @BeforeClass(description = "Start browser")
        public void startBrowser() {
            System.setProperty("webdriver.chrome.driver", "D:\\ATM\\Homework\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");

            driver = new ChromeDriver(options);

            driver.get(APIDOCS_URL);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test(description = "Start browser", priority = 1)
        public void LogintoApiDocs() throws InterruptedException {
            boolean isResultDisplayed = new ApiDocsLoginPage(driver).EnterCredentials(LOGIN,PASSWORD).isSearchItemDisplayed();
            Assert.assertTrue(isResultDisplayed, "No required search result element on the page!");
            System.out.println("WebDriver java binding is available in maven central repository.");

        }

        @Test(description = "Sent request to Docs API", priority = 2)
        public void DocsReq() throws InterruptedException {
            boolean isApiDisplayed = new ApiDocsMainPage(driver).DocsRequest(DOCSAPI).isButtonDisplayed();
            Assert.assertTrue(isApiDisplayed, "No required search result element on the page!");
            System.out.println("WebDriver java binding is available in maven central repository.");
        }

        @AfterClass(description = "Stop Browser", enabled = false)
        public void stopBrowser() {
		driver.quit();
		System.out.println("Browser was successfully quited.");
	}
}

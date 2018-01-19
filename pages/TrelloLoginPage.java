package Homework.Module7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TrelloLoginPage {

    private WebDriver driver;

    private static final String SIGNIN_BTN = "//a[@class='global-header-section-button']";
    private WebElement signInBtn;

    public TrelloLoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public TrelloMainPage openSignInPage() {

        signInBtn = driver.findElement(By.xpath(SIGNIN_BTN));
        signInBtn.click();
        System.out.println("Navigating to signin page...");

        return new TrelloMainPage(driver);
    }

}

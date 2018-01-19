package Homework.Module7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrelloMainPage {


    private static final String LOGIN_INPUT = "user";
    private static final String PWD_INPUT = "//input[@id='password']";
    private static final String SIGNIN_BTN = "login";
    private WebElement loginInput;
    private WebElement pwdInput;
    private WebElement signInBtn;
    private WebDriver driver;

    public TrelloMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public TrelloCreateBoard loginToTrello(String login, String password) {
        System.out.println("User login: " + login);
        loginInput = driver.findElement(By.id(LOGIN_INPUT));
        loginInput.clear();
        loginInput.sendKeys(login);

        System.out.println("User password: " + password);
        pwdInput = driver.findElement(By.xpath(PWD_INPUT));
        pwdInput.clear();
        pwdInput.sendKeys(password);

        signInBtn = driver.findElement(By.id(SIGNIN_BTN));

        signInBtn.click();

        return new TrelloCreateBoard(driver);

    }
}

package Homework.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiDocsLoginPage extends ApiDocsAbstractPage {
  
    @FindBy(name = "IDToken1")
    private WebElement username;

    @FindBy(name = "IDToken2")
    private WebElement password;

    @FindBy(xpath = "//div[@class='button_img button_75 button_75_enabled'][contains(text(),'Sign In')]")
    private WebElement tryBtn;

    public ApiDocsLoginPage(WebDriver driver) {
        super(driver);
    }

    public void EnterCredentials(String Login, String Password) throws InterruptedException {

        this.username.clear();
        this.username.sendKeys(Login);

        this.password.clear();
        this.password.sendKeys(Password);
   }

    public ApiDocsMainPage submit (){
        tryBtn.click();
        tryBtn.click();

        return new ApiDocsMainPage(driver);
    }
}

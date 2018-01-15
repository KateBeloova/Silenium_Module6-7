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
   // private WebElement apiList;

    @FindBy(name = "IDToken1")
    private List<WebElement> username;

    @FindBy(name = "IDToken2")
    private List<WebElement> password;

    @FindBy(xpath = "//div[@class='button_img button_75 button_75_enabled'][contains(text(),'Sign In')]")
    private WebElement tryBtn;

    public ApiDocsLoginPage(WebDriver driver) {
        super(driver);
    }

    public ApiDocsMainPage EnterCredentials(String Login, String Password) throws InterruptedException {

        highlightElement(username.get(0));
        username.get(0).clear();
        username.get(0).sendKeys(Login);
        highlightElement(password.get(0));
        password.get(0).clear();
        password.get(0).sendKeys(Password);
        tryBtn.click();
        tryBtn.click();

        return new ApiDocsMainPage(driver);
    }
}

package Homework.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RequestDocsPage extends ApiDocsAbstractPage {

    private WebElement btn;

    private static final String TRYITBTN = "//span[@id='coral-button_label']/b[contains(text(),'Try it!')]";

    public RequestDocsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isButtonDisplayed(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TRYITBTN)));
        btn = driver.findElement(By.xpath(TRYITBTN));
        return btn.isDisplayed();
    }
}

package Homework.pagefactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ApiDocsMainPage extends ApiDocsAbstractPage{

    private static final String API_LINK = "//a[@class='category-api-item ng-binding'][contains(text(),'/news-subscriptions')]";

    @FindBy(xpath = API_LINK)
    private WebElement apiLink;

    @FindBy(xpath = "//a[@class='category-api-item ng-binding'][contains(text(),'/definitions')]")
    private WebElement apiList;

    public ApiDocsMainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchItemDisplayed() {
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(apiLink));
        return apiLink.isDisplayed();
    }

    public void DocsRequest(String apiName){

        highlightElement(apiList);
        this.apiList.click();
    }
}

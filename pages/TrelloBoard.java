package Homework.Module7.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrelloBoard {

    private WebDriver driver;

    private static final String LOGO = "//span[@class ='member-initials']";
    private WebElement yourRepositoriesLabel;

    public TrelloBoard(WebDriver driver) {
        this.driver=driver;
    }

    public boolean loginIsCorrect() {
        yourRepositoriesLabel = driver.findElement(By.xpath(LOGO));
        return yourRepositoriesLabel.isDisplayed();
    }
}

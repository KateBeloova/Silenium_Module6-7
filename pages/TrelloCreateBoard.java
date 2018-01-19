package Homework.Module7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrelloCreateBoard {

    private static final String BOARD = "//span[@class ='board-tile-details-name']";
    private WebElement boardLink;

    private WebDriver driver;

    public TrelloCreateBoard(WebDriver driver) {
        this.driver = driver;
    }

    public TrelloBoard openBoard() {

        boardLink = driver.findElement(By.xpath(BOARD));
        boardLink.click();

        return new TrelloBoard(driver);
    }


}

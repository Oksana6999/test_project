package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResult extends Base_Page{
    public SearchResult(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='art-item__name']")
    List<WebElement> resultsOfSearch;

    public BookPage chooseBook(String name) {
        resultsOfSearch.stream().filter(f -> f.getText().contains(name)).findAny().get().click();
        return new BookPage(driver);
    }
}

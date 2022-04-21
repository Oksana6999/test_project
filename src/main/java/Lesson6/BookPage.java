package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends Base_Page{
    public BookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Отложить']")
    public WebElement favoriteBook;

    public void addInFavoriteBook() {
        favoriteBook.click();
    }

}

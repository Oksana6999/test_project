package Lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BookPage {

    private SelenideElement favoriteBook = $(By.xpath("//button[.='Отложить']"));


    @Step("Нажать на кнопку Отложить")
    public BookPage addInFavoriteBook() {
        favoriteBook.click();
        return page(BookPage.class);

    }

    @Step("Проверить то, что книга в отложенных")
    public void checkBookInFavorite() {
        favoriteBook.shouldHave(Condition.text("ОТЛОЖЕНО"));
    }

}

package Lesson8;

import Lesson6.BookPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SearchResult {

    private ElementsCollection resultsOfSearch = $$(By.xpath("//div[@class='art-item__name']"));



    @Step("Выбрать книгу по названию")

    public BookPage chooseBook(String name) {
        resultsOfSearch.findBy(Condition.text(name)).click();
        return page(BookPage.class);
    }
}

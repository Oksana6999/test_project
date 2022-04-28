package Lesson8;

import Lesson6.SearchResult;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private SelenideElement loginButton = $(By.xpath("//div[@class='Login-module__wrapper']"));

    private SelenideElement mailButton = $(By.xpath("//div[.='Электронная почта']"));

    private SelenideElement inputEmail = $(By.name("email"));

    private SelenideElement submitButton = $(By.xpath("//button[.='Продолжить']"));

    private SelenideElement password = $(By.xpath("//input[@class='AuthorizationPopup-module__input']"));
    private SelenideElement enter = $(By.xpath("//button[.='Войти']"));
    private SelenideElement cookieYes = $(By.xpath("//button[@class='cookie-agreement__button btn']"));
    private SelenideElement agreeAge = $(By.xpath("//button[.='Да']"));
    private SelenideElement buttonOK = $(By.xpath("//div[@class='adult-content-agreement__btns']//button[.='Ок']"));
    private SelenideElement lKEnter = $(By.xpath("//span[@class='Header-module__loginPopupParent']"));
    private SelenideElement exitFromLK = $(By.xpath("//a[.='Выход']"));
    private SelenideElement searchBook = $(By.xpath("//input[@class='Search-module__input']"));
    private SelenideElement searchButton = $(By.xpath("//button[@class='Search-module__button']"));


    @Step("Нажать на кнопку Вход")
    public MainPage clickLoginButton() {
        loginButton.click();
        return page(MainPage.class);
    }

    @Step("Выбрать вход по емайл")
    public MainPage chooseEnterOnEmail() {
        mailButton.click();
        return page(MainPage.class);
    }

    @Step("Ввести емайл")
    public MainPage sendEmail(String email) {
        inputEmail.sendKeys(email);
        return page(MainPage.class);
    }

    @Step("Нажать кнопку Продолжить")
    public MainPage clickSubmit() {
        submitButton.click();
        return page(MainPage.class);
    }

    @Step("Ввести пароль")
    public MainPage sendPassword(String pass) {
        password.sendKeys(pass);
        return page(MainPage.class);
    }

    @Step("Нажать Отправить")
    public MainPage clickEnter() {
        enter.click();
        return page(MainPage.class);
    }

    @Step("Нажать на логин для входа в личный кабинет")
    public MainPage clickLK() {
        lKEnter.click();
        return page(MainPage.class);
    }

    @Step("Нажать на кнопку Выход из личного кабинета")
    public MainPage cliсkExitFromLK() {
        exitFromLK.click();
        return page(MainPage.class);
    }


    @Step("Согласиться с куками и просмотром книг для лиц старше 18 лет")
    public MainPage agreeCookies() {
        cookieYes.click();
        agreeAge.click();
        buttonOK.click();
        return page(MainPage.class);
    }

    @Step("Ввести фамилию автора в строку поиска")
    public SearchResult searchOfBook(String author) {
        searchBook.sendKeys(author);
        searchButton.click();
        return page(SearchResult.class);
    }
    @Step("Проверить наличие на главной странице кнопки Вход")
    public void checkButtonEnter() {
        loginButton.shouldBe(Condition.text("Войти"));
    }








}

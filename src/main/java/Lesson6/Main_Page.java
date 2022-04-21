package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Main_Page extends Base_Page {

    public Main_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='Login-module__wrapper']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='Электронная почта']")
    public WebElement mailButton;

    @FindBy(name = "email")
    public WebElement inputEmail;

    @FindBy(xpath = "//button[.='Продолжить']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@class='AuthorizationPopup-module__input']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Войти']")
    public WebElement enter;

    @FindBy(xpath = "//button[@class='cookie-agreement__button btn']")
    public WebElement cookieYes;

    @FindBy(xpath = "//button[.='Да']")
    public WebElement agreeAge;

    @FindBy(xpath = "//div[@class='adult-content-agreement__btns']//button[.='Ок']")
    public WebElement buttonOK;

    @FindBy(xpath = "//span[@class='Header-module__loginPopupParent']")
    public WebElement lKEnter;

    @FindBy(xpath = "//a[@class='user_menu__exit']")
    public WebElement exitFromLK;

    @FindBy(xpath = "//input[@class='Search-module__input']")
    public WebElement searchBook;

    @FindBy(xpath = "//button[@class='Search-module__button']")
    public WebElement searchButton;

    public void login(String email, String pass) {
        loginButton.click();
        mailButton.click();
        inputEmail.sendKeys(email);
        submitButton.click();
        password.sendKeys(pass);
        enter.click();
        lKEnter.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='user_menu__exit']")));
        exitFromLK.click();
    }

    public Main_Page agreeCookies() {
        cookieYes.click();
        agreeAge.click();
        buttonOK.click();
        return new Main_Page(driver);
    }

    public SearchResult searchOfBook(String author) {
        searchBook.sendKeys(author);
        searchButton.click();

        return new SearchResult(driver);
    }
}

import Lesson8.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {

    @Given("Открыта главная страница")
    public void openMainPage() {
        open("https://litres.ru");
        new MainPage().agreeCookies();
    }

    @When("Кликнуть на кнопку Вход")
    public void clickOnButtonSignIn() {
        new MainPage().clickLoginButton();
    }

    @And("Выбрать вход по электронной почте")
    public void chooseEnterOnEmail() {
        new MainPage().chooseEnterOnEmail();
    }

    @And("Ввести емайл")
    public void inputEmail() {
        new MainPage().sendEmail("ksusha3699@mail.ru");
    }

    @And("Кликнуть на кнопку продолжить")
    public void clickOnButtonSubmit() {
        new MainPage().clickSubmit();
    }

    @And("Ввести пароль")
    public void inputPassword() {
        new MainPage().sendPassword("hnkwx7bn");
    }

    @And("Кликнуть на кнопку Войти")
    public void clickOnSubmit() {
        new MainPage().clickEnter();
    }

    @And("Кликнуть на Логин для входа в личный кабинет")
    public void clickOnButtonLK() {
        new MainPage().clickLK();
    }

    @And("Нажать на кнопку Выход")
    public void clickOnButtonExit() {
        new MainPage().cliсkExitFromLK();
    }

    @Then("Проверить, что выход из кабинета был произведен успешно")
    public void checkThatExitIsSuccesses() {
        new MainPage().checkButtonEnter();
    }

}

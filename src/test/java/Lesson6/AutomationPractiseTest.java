package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPractiseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }


    @Test
    void loginInLitres() {
        driver.get("https://litres.ru");
        new Main_Page(driver).agreeCookies().
                login("ksusha3699@mail.ru", "hnkwx7bn");

    }

    @Test
    void searchOfBookTest() {
        driver.get("https://litres.ru");
        new Main_Page(driver).agreeCookies().
                searchOfBook("Устинова").
                chooseBook("Земное притяжение").
                addInFavoriteBook();
        Assertions.assertEquals(driver.findElement(By.xpath("//button[.='Отложено']")).getText(), "ОТЛОЖЕНО");

    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }
}

package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LitresTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String Litres_Base_URL = "https://litres.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(Litres_Base_URL);
    }

    @Test
    @DisplayName("Добавление книги в избранное")
    void testLitres() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='cookie-agreement__button btn']"))));
        driver.findElement(By.xpath("//button[@class='cookie-agreement__button btn']")).click();
        driver.findElement(By.xpath("//button[.='Да']")).click();
        driver.findElement(By.xpath("//div[@class='adult-content-agreement__btns']//button[.='Ок']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='Search-module__input']"))));
        driver.findElement(By.xpath("//input[@class='Search-module__input']")).sendKeys("Устинова");
        driver.findElement(By.xpath("//button[@class='Search-module__button']")).click();
        driver.findElement(By.xpath("//a[.='Призрак Канта']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[.='Отложить']"))));
        driver.findElement(By.xpath("//button[.='Отложить']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Отложено']")));

        Assertions.assertEquals(driver.findElement(By.xpath("//button[.='Отложено']")).getText(), "ОТЛОЖЕНО");


    }


    @Test
    @DisplayName("Переход на страницу покупки книги из раздела Новинки")
    void TestLitres2() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='cookie-agreement__button btn']"))));
        driver.findElement(By.xpath("//button[@class='cookie-agreement__button btn']")).click();
        driver.findElement(By.xpath("//button[.='Да']")).click();
        driver.findElement(By.xpath("//div[@class='adult-content-agreement__btns']//button[.='Ок']")).click();
        driver.findElement(By.xpath("//a[.='Новинки']")).click();
        List<WebElement> books = driver.findElements(By.xpath("//a[@class='art__name__href']"));
        books.stream().findFirst().get().click();
        driver.findElement(By.xpath("//span[.='Купить и скачать за']")).click();
        driver.switchTo().frame(driver.findElement(By.id("payment-iframe")));
        Assertions.assertEquals(driver.findElement(By.name("email")).isDisplayed(),true);

    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

}

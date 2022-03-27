package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        driver.get("https://diary.ru");

//        driver.findElement(By.xpath("//a[.='Вход']")).click();
//        driver.findElement(By.id("loginform-username")).sendKeys("S");
//        driver.findElement(By.id("loginform-password")).sendKeys("ar25");
//
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
//        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
//
//        driver.switchTo().parentFrame();
//
//        driver.findElement(By.id("login-btn")).click();

        Cookie authCookie = new Cookie("_identity_", "09cc6f3275a8a2696d3285e83e83b776a9f2bdd5d455a216b2ea16e9" +
                "abae3659a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi" +
                "%3A1%3Bs%3A52%3A%22%5B3565063%2C%226j70YSDLVj_byZcCbxqA0cXATP0nbmDR%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();

        String postName = "Post" + new Random().nextInt(1000);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postTitle")));



        driver.findElement(By.id("postTitle")).sendKeys(postName);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));

        driver.findElement(By.id("tinymce")).sendKeys("Our new post");

        driver.switchTo().parentFrame();

        driver.findElement(By.id("DisableAutoSaveCheck")).click();

        driver.findElement(By.id("rewrite")).click();

        List<WebElement> posts = driver.findElements(By.xpath("//a[class='title']"));
        posts.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();


        Thread.sleep(5000);





        driver.quit();

    }

}

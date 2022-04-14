package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.Tab;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);


        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(5000);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.close();
        Thread.sleep(5000);

        driver.quit();


    }
}

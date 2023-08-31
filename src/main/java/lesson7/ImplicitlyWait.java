package lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ImplicitlyWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //Ожидание появления элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Ожидание загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //Ожидание отработки скриптов
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }
}

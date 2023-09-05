package lesson8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://uhomki.com.ua/");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@class='products-menu__title-link'][contains(text(), 'Птахи')]"))).perform();
        driver.findElement(By.xpath("//span[@class ='productsMenu-submenu-t'][contains(text(), 'Ласощі для птахів')]")).click();
        driver.findElement(By.xpath("//a[@class = 'lang-menu__link']")).click();
        driver.findElement(By.xpath("//span[@class = 'filter-title'][contains(text(), 'Неразлучники')]/../span[1]")).click();
        driver.findElement(By.xpath("//span[text() = 'Купить']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'counter-btn __minus j-decrease-p']"))).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        driver.quit();
    }
}

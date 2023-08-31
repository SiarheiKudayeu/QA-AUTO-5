package lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitersWx3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();

        //presenceOfElementLocated ожидание появления элемента в ДОМ дереве
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        //textToBePresentInElementValue ожидание появления текста в элементе
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("Username"),"Test"));
        driver.findElement(By.id("Password")).sendKeys("qwerty");
        WebElement pass = driver.findElement(By.id("Password"));

        // invisibilityOf ожидает исчезновения элемента
        driver.get("https://dan-it.com.ua/uk");
        wait.until(ExpectedConditions.invisibilityOf(pass));

        // ожидание определенного названия страницы
        wait.until(ExpectedConditions.titleIs("Курси програмування в Україні (онлайн та офлайн)☑️ IT курси з працевлаштуванням"));
        System.out.println(driver.getCurrentUrl());

        // ожидания части текста в названии страницы
        wait.until(ExpectedConditions.titleContains("Курси програмування в Україні "));
        driver.findElement(By.xpath("//a[text()='Для дітей']")).click();

    }
}

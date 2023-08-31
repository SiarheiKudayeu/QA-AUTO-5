package lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showSmallModal"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeSmallModal")));

        System.out.println(driver.findElement(By.cssSelector(".modal-body")).getText());

        driver.findElement(By.id("closeSmallModal")).click();

        //===============================
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showLargeModal"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeLargeModal")));

        System.out.println(driver.findElement(By.cssSelector(".modal-title.h4")).getText());

        driver.findElement(By.id("closeLargeModal")).click();
        driver.quit();
    }
}

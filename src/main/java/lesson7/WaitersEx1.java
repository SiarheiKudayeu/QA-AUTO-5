package lesson7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitersEx1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //Явные ожидания
        //WebDriverWait
        //ExpectedConditions

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");


        //visibilityOfElementLocated - ожидание видимости элемента
/*        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices")));
        driver.findElement(By.id("accept-choices")).click();*/

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices"))).click();

        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices"))).click();

        //frameToBeAvailableAndSwitchToIt - ожидание появления фрейма и переключение на него
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='myFunction()']"))).click();

        //alertIsPresent - ожидание алерта и переключение на него
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        driver.quit();
    }
}

package lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        driver.get("https://demoqa.com/nestedframes");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));

        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))).getText());

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));

        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p"))).getText());
        driver.quit();
    }
}

package lesson7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        Thread.sleep(2000);
        driver.findElement(By.id("accept-choices")).click();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.quit();
    }
}

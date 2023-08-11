package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selen15\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\selen15\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//div[text()='Принять все']")).click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}

package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(5000);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector(".o-link.is-active"));
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.cssSelector(".o-link.is-active")), 0, 50)
                    .clickAndHold().moveToElement(driver.findElement(By.cssSelector(".c-header__logo")))
                    .release().build().perform();
            Thread.sleep(1000);
        }
    }
}

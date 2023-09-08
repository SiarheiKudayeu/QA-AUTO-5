package lesson9;

import lesson8.WaitersClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class Parameters {
    static WebDriver driver;
    static WaitersClass waitersClass;

    @Test
    @org.testng.annotations.Parameters({"login","password"})
    public void task1(String login, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        waitersClass = new WaitersClass(driver);
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys(login);
        driver.findElement(By.id("auth_pass")).sendKeys(password);
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("auth_pass")).getAttribute("type").equals("text"));
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
        driver.quit();
    }

}


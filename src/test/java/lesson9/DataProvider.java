package lesson9;

import lesson8.WaitersClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {
    static WebDriver driver;
    static WaitersClass waitersClass;

    @BeforeMethod
    public void precondition() {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        waitersClass = new WaitersClass(driver);
    }

    @AfterMethod
    public void finishTesting() {
        driver.quit();
    }

    @Test(dataProvider = "searchParameters")
    public void task1(String login, String login2, int pass) throws InterruptedException {
        ;
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys(login + login2);
        String passw = String.valueOf(pass);
        driver.findElement(By.id("auth_pass")).sendKeys(passw);
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("auth_pass")).getAttribute("type").equals("text"));
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @org.testng.annotations.DataProvider(name = "searchParameters")
    public Object[][] createData() {
        return new Object[][]{
                {"bababooey", "bababooey", 12345},
                {"xxxxxxxxxx", "xxxxxxxxxx", 1234345},
                {"yyyyyyyyyy", "xxxxxxxxxx", 122345},
        };
    }

}


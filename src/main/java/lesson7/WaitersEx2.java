package lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitersEx2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //elementSelectionStateToBe, elementToBeSelected, elementToBeClickable

        //elementToBeClickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ez-accept-all"))).click();
        //elementToBeSelected
        wait.until(ExpectedConditions.elementToBeSelected(By.id("RememberMe")));
        driver.findElement(By.id("Username")).sendKeys("QA");
        //elementSelectionStateToBe
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("RememberMe"),false));
        driver.findElement(By.id("Username")).clear();

    }
}

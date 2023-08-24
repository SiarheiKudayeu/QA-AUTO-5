package lesson4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class WorkingWithHandle2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> windowHandles2 = driver.getWindowHandles();
        String newDescriptor = (String) windowHandles2.toArray()[1];
        System.out.println(newDescriptor);
        driver.switchTo().window(newDescriptor);
        driver.get("https://guinnessworldrecords.com/records/");
        //driver.quit();
    }
}

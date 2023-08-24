package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");
        System.out.println(driver.findElement(By.cssSelector(".banner-meta__item--main--offline p")).getText());
        String text = driver.findElement(By.xpath("//p[contains(text(), 'Мі')]/../../../div[1]//li[contains(text(),'понад')]")).getText();
        System.out.println(text);
        int countOfStudents = Integer.parseInt(text.split("\\s")[1]);
        System.out.println(countOfStudents);
        driver.quit();
    }
}

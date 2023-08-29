package lesson6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DoubleAndContext {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Thread.sleep(2000);


        //WebElement
/*        WebElement iframe = driver.findElement(By.xpath("//iframe[@aria-label='Privacy Manager window']"));
        driver.switchTo().frame(iframe);*/
        //driver.switchTo().frame("gdpr-consent-notice");
        try {
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@aria-label='Privacy Manager window']")));
            driver.findElement(By.xpath("//span[text()='Accept All']")).click();
        } catch (Exception e){
            e.printStackTrace();
        }
        //.context-menu-icon-quit
        driver.findElement(By.cssSelector(".context-menu-one.btn"));
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.cssSelector(".context-menu-one.btn"))).perform();
        driver.findElement(By.cssSelector(".context-menu-icon-quit")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@ondblclick]"));
        action.doubleClick(driver.findElement(By.xpath("//button[@ondblclick]"))).perform();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert();

        System.out.println(alert1.getText());
        alert1.accept();

        driver.quit();
    }
}

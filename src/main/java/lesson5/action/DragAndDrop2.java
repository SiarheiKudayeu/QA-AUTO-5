package lesson5.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop2 {
    public static void dragNDrop(WebDriver driver, int numberOfOption) {
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        driver.findElement(By.id("menu-btn")).click();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("option" + numberOfOption)))
                .clickAndHold()
                .moveToElement(driver.findElement(By.cssSelector(".dots-icon")))
                .release()
                .build().perform();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.signesduquotidien.org/");
        Actions actions = new Actions(driver);

        //driver.findElement(By.cssSelector(".dots-icon"));
        //driver.findElement(By.id("option1"));
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        driver.findElement(By.id("menu-btn")).click();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        WebElement source = driver.findElement(By.id("option4"));
        WebElement target = driver.findElement(By.id("menu-btn"));
        actions.dragAndDrop(source,target).perform();
    }
}

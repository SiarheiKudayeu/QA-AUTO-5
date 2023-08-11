package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {
        //xpath
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
/*        driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.xpath("//input[@id='search-term']")).sendKeys("handstand push ups");
        driver.findElement(By.xpath("//button[@id='search-button']")).click();
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.tagName("h2")).getText());
        driver.quit();*/

        //xpath по тексту
        //a[text()='Standard application']
        //p[contains(text(), 'to Guinness')]
        //a[contains(@class, 'pa')]
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(3000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }
        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[text()='Standard application']")).click();
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'to Guinness')]")).getText());
        driver.findElement(By.xpath("//a[contains(@class, 'pa')]")).click();
        Thread.sleep(1500);
        System.out.println(driver.getTitle());
        driver.quit();
        //можно комбинировать атрибуты
        // //div[contains(@class,'block block-4-12')][not(contains(@class,'columned'))]
        // //section[contains(@class,'imple-intro-wrapper')]//a[text()='Apply now']
    }
}

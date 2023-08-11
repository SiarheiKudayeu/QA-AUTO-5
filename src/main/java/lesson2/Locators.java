package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //id поиск по айди
/*        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(3000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }
        Thread.sleep(1500);
        driver.findElement(By.id("search")).click();
        Thread.sleep(3000);
        driver.quit();*/


        //name поиск по атрибуту "name"
        /*driver.get("https://uhomki.com.ua/");
        driver.findElement(By.name("q")).sendKeys("Hello Friday");*/
/*        driver.get("https://uhomki.com.ua/");
        driver.findElement(By.id("search_uid879e3a308b83d40ea62321053643c54b")).sendKeys("Hello Friday");*/
        //search_uideff6cb630e63048d59140b572faa6e74
        //search_uid879e3a308b83d40ea62321053643c54b
        //search_uidcb918aebbdab7647042cfae7e47cd7b0


        //className поиск по атрибуту "class"
/*        driver.get("https://uhomki.com.ua/");
        String text = driver.findElement(By.className("basket__title")).getText();
        System.out.println(text);
        driver.quit();*/


        //example String 100ml
 /*       driver.get("https://uhomki.com.ua/");
        String value = driver.findElement(By.xpath("//a[@title='Аурікап - спрей для догляду за вухами собак та кішок, 100 мл']")).getText();
        boolean valueCompare = value.contains("100 мл");
        System.out.println(value);
        System.out.println(valueCompare);
        driver.quit();*/

        //tagName поиск по названию тега
/*        driver.get("https://uhomki.com.ua/");
        driver.findElement(By.name("q")).sendKeys("медведь");
        Thread.sleep(3000);
        driver.findElement(By.className("icon--search")).click();
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.quit();*/


        //linkText по тексту ссылки
        //partialLinkText
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }
        Thread.sleep(1500);
        driver.findElement(By.linkText("APPLICATION PROCESS")).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        driver.findElement(By.partialLinkText("what m")).click();
        Thread.sleep(1500);
        System.out.println(driver.getTitle());
        driver.quit();

        //  /html/body/div[1]/main/div/section/div/div[3]/a
    }
}

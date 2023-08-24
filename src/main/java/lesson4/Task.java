package lesson4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class Task {
    //Открыть в браузере три различные вкладки.
    // На каждой вкладке открыть отдельно различные любые страницы,
    // вывести в консоль названия открытых страниц. Закрыть браузер.
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");
        System.out.println(driver.getTitle());
        Set<String> windowHandles1 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> windowHandlesAll = driver.getWindowHandles();
        windowHandlesAll.removeAll(windowHandles1);
        String newDescriptor = windowHandlesAll.iterator().next();
        driver.switchTo().window(newDescriptor);
        driver.get("https://www.pikabu.ru/");
        System.out.println(driver.getTitle());
        Set<String> windowHandles2 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> windowHandlesAll3 = driver.getWindowHandles();
        windowHandlesAll3.removeAll(windowHandles2);
        String newDescriptor3 = windowHandlesAll3.iterator().next();
        driver.switchTo().window(newDescriptor3);
        driver.get("https://www.rozetka.ua/");
        System.out.println(driver.getTitle());

        //close();
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
}

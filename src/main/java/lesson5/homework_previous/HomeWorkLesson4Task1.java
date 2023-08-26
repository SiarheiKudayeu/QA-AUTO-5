package lesson5.homework_previous;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class HomeWorkLesson4Task1 {
    /*1)
Написать программу, которая будет открывать пять различных страниц в новых окнах:
    https://uhomki.com.ua/ru/koshki/1074/
    https://zoo.kiev.ua/
    https://www.w3schools.com/
    https://taxi838.ua/ru/dnepr/
    https://klopotenko.com/

Прописать цикл, который будет переключаться поочередно через все страницы,
для каждой страницы выводить в консоль название и ссылку на эту страницу.
И будет закрывать ту страницу в названии которой есть слово зоопарк.*/
    public static void main(String[] args) {
        String[] url = {
                "https://uhomki.com.ua/ru/koshki/1074/",
                "https://zoo.kiev.ua/",
                "https://www.w3schools.com/",
                "https://taxi838.ua/ru/dnepr/",
                "https://klopotenko.com/"
        };

        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url[0]);
        for (int i = 0; i < 5; i++) {
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println("");
            if (i + 1 == 5) {
                break;
            }
            Set<String> set1 = driver.getWindowHandles();
            ((JavascriptExecutor) driver).executeScript("window.open()");
            Set<String> set2 = driver.getWindowHandles();
            set2.removeAll(set1);
            String descriptorOfNewPage = set2.iterator().next();
            if (driver.getTitle().contains("зоопарк")) {
                driver.close();
            }
            driver.switchTo().window(descriptorOfNewPage);
            driver.get(url[i + 1]);
        }
    }
}

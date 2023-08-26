package lesson5.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectEx {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");


        WebElement countriesWebElement = driver.findElement(By.id("itt_country"));
        Select countries = new Select(countriesWebElement);

        //select
/*        countries.selectByVisibleText("Греция");
        Thread.sleep(2000);
        countries.selectByValue("320");
        Thread.sleep(2000);
        countries.selectByIndex(4);*/

        //isMultiple
        Select region = new Select(driver.findElement(By.id("region_list")));
        System.out.println(countries.isMultiple());
        System.out.println(region.isMultiple());

        //getOptions
        List<WebElement> regionList = region.getOptions();
        for(WebElement singleRegion: regionList){
            System.out.println(singleRegion.getText());
        }
        region.selectByVisibleText("Аланья");
        region.selectByVisibleText("Анталия");
        region.selectByVisibleText("Белек");

        //deselect //getFirstSelectedOption //getAllSelectedOptions
        System.out.println("Первый выбранный элемент " + region.getFirstSelectedOption().getText());

        System.out.println("Все выбранные элементы: ");
        for (WebElement element:region.getAllSelectedOptions()){
            System.out.println(element.getText());
        }

        region.deselectByIndex(0);
        Thread.sleep(2000);
        region.selectByVisibleText("Анталия");
        Thread.sleep(2000);
        region.deselectByValue("6818");
        Thread.sleep(2000);
        region.deselectAll();
        driver.quit();
    }
}

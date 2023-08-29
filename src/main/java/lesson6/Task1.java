package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        //Бельгия Германия Греция // 2 //Киев Львов // 0
        //div[@class='pager_block']//input[@value='Найти']
        driver.findElement(By.cssSelector(".hike_tour.no_active")).click();
        Select countryList = new Select(driver.findElement(By.id("country_list")));
        Select transportList = new Select(driver.findElement(By.id("transport_list")));
        Select cityList = new Select(driver.findElement(By.id("city_list")));
        Select tourCityList = new Select(driver.findElement(By.id("tour_city_list")));
        countryList.selectByVisibleText("Бельгия");
        Thread.sleep(1000);
        countryList.selectByVisibleText("Германия");
        Thread.sleep(1000);
        countryList.selectByVisibleText("Греция");
        Thread.sleep(1000);
        countryList.deselectByValue("30");
        Thread.sleep(3000);

        transportList.selectByValue("2");
        Thread.sleep(1000);
        transportList.deselectByValue("0");
        Thread.sleep(2000);

        cityList.selectByVisibleText("Киев");
        Thread.sleep(1000);
        cityList.selectByVisibleText("Львов");
        Thread.sleep(1000);
        cityList.deselectByValue("0");
        Thread.sleep(3000);

        tourCityList.selectByValue("0");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='pager_block']//input[@value='Найти']")).click();
    }
}

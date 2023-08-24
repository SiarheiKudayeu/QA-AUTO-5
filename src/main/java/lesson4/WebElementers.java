package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementers {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        /*driver.get("https://www.guinnessworldrecords.com/search");

        WebElement element = driver.findElement(By.xpath("//input[@id='search-term']"));
        element.sendKeys("handstand");
        element.sendKeys(Keys.ENTER);

        //clear
        element.clear();
        driver.navigate().refresh();
        element = driver.findElement(By.xpath("//input[@id='search-term']"));
        element.sendKeys("handstand");

        //get
        WebElement searchButton = driver.findElement(By.id("search-button"));
        System.out.println(searchButton.getText());
        System.out.println(searchButton.getTagName());
        System.out.println(searchButton.getAttribute("class"));
        System.out.println(searchButton.getCssValue("line-height"));

        //getSize Location
        System.out.println("Размер нашей кнопки " + searchButton.getSize());
        System.out.println("Ширина кнопки " + searchButton.getSize().width);
        System.out.println("Высота кнопки " + searchButton.getSize().height);

        System.out.println("Координаты верхнего левого угла " + searchButton.getLocation());
        System.out.println("Координаты x верхнего левого угла " + searchButton.getLocation().x);
        System.out.println("Координаты y  верхнего левого угла " + searchButton.getLocation().y);

        int xOfSearchButtonCentre = searchButton.getLocation().x + searchButton.getSize().width/2;
        int yOfSearchButtonCentre = searchButton.getLocation().y + searchButton.getSize().height/2;
        System.out.println("Координаты центра" + xOfSearchButtonCentre+", "+ yOfSearchButtonCentre);*/


        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }

        WebElement checkBox = driver.findElement(By.id("RememberMe"));

        System.out.println("Виден ли чек-бокс? " + checkBox.isDisplayed());
        System.out.println("Активен ли чек-бокс? " + checkBox.isEnabled());
        System.out.println("Выбран ли чек-бокс? " + checkBox.isSelected());

        checkBox.click();

        System.out.println("=========================");

        System.out.println("Виден ли чек-бокс? " + checkBox.isDisplayed());
        System.out.println("Активен ли чек-бокс? " + checkBox.isEnabled());
        System.out.println("Выбран ли чек-бокс? " + checkBox.isSelected());

        driver.get("https://www.guinnessworldrecords.com/search");

        WebElement element = driver.findElement(By.xpath("//input[@id='search-term']"));
        element.sendKeys("handstand");
       // driver.quit();
    }
}

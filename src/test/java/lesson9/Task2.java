package lesson9;

import lesson8.WaitersClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 extends BaseTest{


    @Test
    public void task1() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test
    public void task2() throws InterruptedException {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://foodex24.pl/ua");
        action.moveToElement(driver.findElement(By.xpath("//span[text()='Риба та морепродукти']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text() = 'Паста з морепродуктів']")))).click();
        driver.findElement(By.cssSelector(".action-bar-search__input")).sendKeys("Халва");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".action-bar-search__submit")))).click();
        System.out.println();
        String result = driver.findElement(By.xpath("//h1[@class = 'title title--size-h1 _text-center']")).getText();
        String number = result.split("\\s")[4];
        Assert.assertEquals(number, "23");
    }

    @Test
    public void task3() throws InterruptedException {
        String[] ingredients = {"400 г кисломолочного сиру 9%",
                "1 яйце", "3 ст. л. борошна (+додатково для паніровки)", "3 ст. л. цукру",
                "3-4 ст. л. соняшникової олії для смаження", "10 г ванільного цукру", "дрібка солі"};
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://klopotenko.com/syrniki-prostyj-retsept/");
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div"))));
        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div")).size(),7);
        for(int i = 0; i < ingredients.length; i++ ){
            Assert.assertEquals(driver.findElements(By.xpath("//div[@class='col-12 col-md-6']/div/div")).get(i).getText(),
                    ingredients[i]);
        }

    }
}


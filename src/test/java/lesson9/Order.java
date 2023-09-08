package lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Order extends BaseTest{


    @Test(priority = 3)
    public void a() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test(priority = 1)
    public void e() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test(priority = 2)
    public void c() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test
    public void b() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test(priority = 5)
    public void d() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

}


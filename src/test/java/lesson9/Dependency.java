package lesson9;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency extends BaseTest{


    @Test
    public void a() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test
    public void e() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
        Assert.assertTrue(false);
    }

    @Test
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

    @Test(dependsOnMethods = {"e"}, alwaysRun = true)
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


package lesson9;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependencyGroups extends BaseTest{


    @Test(groups = "smoke")
    public void a() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test(groups = "smoke")
    public void e() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test
    @Ignore
    public void c() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test(enabled = false)
    public void b() {
        driver.get("https://rozetka.com.ua/");
        driver.findElements(By.cssSelector(".header__button.ng-star-inserted")).get(0).click();
        driver.findElement(By.id("auth_email")).sendKeys("bababooey");
        driver.findElement(By.id("auth_pass")).sendKeys("passBababooey");
        driver.findElement(By.cssSelector(".button_type_link.form__toggle-password")).click();
        Assert.assertEquals(driver.findElement(By.id("auth_pass")).getAttribute("type"), "text");
        Assert.assertTrue(driver.findElement(By.cssSelector(".error-message")).isDisplayed());
    }

    @Test(dependsOnGroups = {"smoke"})
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


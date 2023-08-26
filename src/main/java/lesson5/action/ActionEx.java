package lesson5.action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionEx {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://dan-it.com.ua/uk/");
        Actions actions = new Actions(driver);

        //moveTo
        /*WebElement adults = driver.findElement(By.cssSelector(".menu-item-50667"));
        actions.moveToElement(adults).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Програмування']"))).perform();
        System.out.println(driver.findElement(By.xpath("//a[text()='Python Developer']")).getSize());
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Python Developer']")),0,42).click().build().perform();*/

/*        actions.moveToElement(driver.findElement(By.cssSelector(".menu-item-50667")))
                .moveToElement(driver.findElement(By.xpath("//a[text()='Програмування']")))
                .moveToElement(driver.findElement(By.xpath("//a[text()='Python Developer']")))
                .click().build().perform();*/

        //moveByOffset
/*        WebElement element = driver.findElement(By.cssSelector(".menu-item-73306"));
        int x = element.getLocation().x + element.getSize().width / 2;
        int y = element.getLocation().y + element.getSize().height / 2;

        actions.moveByOffset(x, y).perform();*/

        //keyDown //keyUp
        actions.keyDown(Keys.COMMAND)
                .click(driver.findElement(By.cssSelector(".menu-item-50667")))
                .click(driver.findElement(By.cssSelector(".menu-item-50723")))
                .keyUp(Keys.COMMAND)
                .build().perform();
    }
}

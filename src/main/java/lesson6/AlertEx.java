package lesson6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertEx {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        String alertResult1 = "You successfully clicked an alert";
        String alertResult2 = "You clicked: Cancel";
        String alertResult3 = "You entered: ";
        String insertText = "Hello QA";
//Alert1
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("");
        System.err.println(alert1.getText());
        Thread.sleep(1000);
        alert1.accept();
        boolean resultAlert1 = (driver.findElement(By.id("result")).getText()).equals(alertResult1);
        if (resultAlert1) {
            System.out.println("Результат совпадает");
        } else {
            System.out.println("Результат не совпадает");
        }
        System.out.println("");
//Alert2
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println("");
        System.err.println(alert2.getText());
        Thread.sleep(1000);
        alert2.dismiss();
        boolean resultAlert2 = (driver.findElement(By.id("result")).getText()).equals(alertResult2);
        if (resultAlert2) {
            System.out.println("Результат совпадает");
        } else {
            System.out.println("Результат не совпадает");
        }
        System.out.println("");
//Alert3
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println("");
        System.err.println(alert3.getText());
        Thread.sleep(1000);
        alert3.sendKeys("Hello ");
        alert3.sendKeys("QA");
        Thread.sleep(3000);
        alert3.accept();
        boolean resultAlert3 = (driver.findElement(By.id("result")).getText()).equals(alertResult3 + "QA");
        if (resultAlert3) {
            System.out.println("Результат совпадает");
        } else {
            System.out.println("Результат не совпадает");
        }
        System.out.println("");

        driver.quit();
    }
}

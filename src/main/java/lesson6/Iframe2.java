package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Iframe2 {
    public static void main(String[] args) {
        https:
//www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css");

        //accept-choices
        //iframeResult
        //h1[text()='The iframe element + CSS']/..//iframe[2]
        //signupbtn_topnav
        try {
            driver.findElement(By.id("accept-choices")).click();
        } catch (Exception e) {
            System.out.println("Element with xpath \"accept-choices\" not found");
        }
        driver.switchTo().frame("iframeResult");
        //driver.switchTo().frame(1);
        driver.switchTo().frame(driver.findElement(By.xpath("//h1[text()='The iframe element + CSS']/..//iframe[2]")));
        try {
            driver.findElement(By.id("accept-choices")).click();
        } catch (Exception e) {
            System.out.println("Element with xpath \"accept-choices\" not found");
        }
        driver.findElement(By.id("signupbtn_topnav")).click();
    }
}

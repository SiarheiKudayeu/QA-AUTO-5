package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath_2 {

    private static class Url {
        private static final String breakArecordPage = "https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/";
        private static final String loginPage = "https://www.guinnessworldrecords.com/Account/Login";
    }

    private static class Locators {
        private static final By acceptCookiesButton = By.id("ez-accept-all");
        private static final By passwordField = By.xpath("//input[@data-val-length-max<'255']");
        private static final By loginField = By.xpath("//input[@data-val-length-max!='100']");
        private static final By checkBox = By.id("RememberMe");
    }

    private static class Data {
        private static final String password = "Password";
        private static final String login = "Login";
    }
    public static void login(WebDriver driver){
        driver.findElement(Locators.passwordField).sendKeys(Data.password);
        driver.findElement(Locators.loginField).sendKeys(Data.login);
        driver.findElement(Locators.checkBox).click();
    }
    public static void acceptCookies(WebDriver driver){
        driver.get(Url.loginPage);
        try {
            Thread.sleep(1000);
            driver.findElement(Locators.acceptCookiesButton).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }
    }
    public static void closeDriverWithWait(WebDriver driver, int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException exception){
            exception.printStackTrace();
        }
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
/*
// /.. - вверх по тегу
// /имя_тега вниз к указанному тегу
// переход на родительский тег /parent::div
// переход на дочерний тег /child::a
// переход на параллельный тег /following-sibling::*[1]
// предок /ancestor::span
// потомок /descendant::h3
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        Thread.sleep(3000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }
        String xpath = "//a[text()='Apply now']/../../div/following-sibling::div/p/a";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        System.out.println(driver.findElement
                (By.xpath("//a[text()='APPLICATION PROCESS']/../following-sibling::div[2]/a")).getText());
// ключевое слово last()
        System.out.println(driver.findElement
                (By.xpath("//a[text()='APPLICATION PROCESS']/../following-sibling::div[last()]/a")).getText());
        driver.quit();
*/

        //xpath операторы >, <, >=, <=, !=
/*        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        Thread.sleep(1000);
        try {
            driver.findElement(By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Нет кнопки \"accept-all\"");
        }
        driver.findElement(By.xpath("//input[@data-val-length-max<'255']")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@data-val-length-max!='100']")).sendKeys("Login");
        driver.findElement(By.id("RememberMe")).click();
        Thread.sleep(6000);
        driver.quit();*/


        //вложенные классы
        acceptCookies(driver);
        login(driver);
        closeDriverWithWait(driver,6);
    }
}

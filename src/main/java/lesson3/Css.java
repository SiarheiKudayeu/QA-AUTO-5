package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Css {
    private static class Url {
        private static final String breakArecordPage = "https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/";
        private static final String loginPage = "https://www.guinnessworldrecords.com/Account/Login";
        private static final String searchPage = "https://www.guinnessworldrecords.com/search?term=%2A";
    }

    private static class Locators {
        private static final By acceptCookiesButton = By.id("ez-accept-all");
        private static final By passwordField = By.xpath("//input[@data-val-length-max<'255']");
        private static final By loginField = By.xpath("//input[@data-val-length-max!='100']");
        private static final By checkBox = By.id("RememberMe");
        private static final By searchField = By.cssSelector("input");
    }
    private static class LocatorCss {
        //по имени тега
        private static final By searchField = By.cssSelector("input");
        //по id
        private static final By searchButton = By.cssSelector("#search-button");
        private static final By acceptCookiesButton = By.cssSelector("#ez-accept-all");
        //по имени класса
        private static final By GoButton = By.cssSelector(".btn-primary");
        //по атрибуту и значению
        private static final By searchIcon = By.cssSelector("a[title='Search']");
        //по буквосочетанию атрибута
        private static final By searchIcon1 = By.cssSelector("[title*='ear']");
        private static final By searchIcon2 = By.cssSelector("[title^='Sea']");
        private static final By searchIcon3 = By.cssSelector("[title$='arch']");
        //для движения к дочерним элементам по DOM дереву
        private static final By searchField2 = By.cssSelector(".record-search.search-form-container div [placeholder='Search']");
        //ключевое слово not для исключения определенных классов
        private static final By CreateAccountNowButton = By.cssSelector(".btn:not(.blue)");
    }

    public static WebDriver driverInit() {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
    public static void clickOnElement(WebDriver driver, By by){
        driver.findElement(by).click();
    }
    public static void sendKeys(WebDriver driver, By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static void acceptCookies(WebDriver driver) {
        try {
            Thread.sleep(2000);
            driver.findElement(LocatorCss.acceptCookiesButton).click();
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

    public static void openBreakArecordPage(WebDriver driver) {
        acceptCookies(driver);
        driver.get(Url.breakArecordPage);
    }

    public static void openLoginPage(WebDriver driver){
        acceptCookies(driver);
        driver.get(Url.loginPage);
    }

    public static void openSearchPage(WebDriver driver){
        acceptCookies(driver);
        driver.get(Url.searchPage);
    }

    public static void main(String[] args) throws InterruptedException {
/*        //пример 1 по имени тега
        WebDriver driver = driverInit();
        openSearchPage(driver);
        driver.findElements(LocatorCss.searchField).get(1).sendKeys("Handstand push ups");
        //пример 2 по id
        driver.findElement(LocatorCss.seachButton).click();
        closeDriverWithWait(driver,4);*/

        //пример 3 по классу
        //пример 4 по атрибуту и значению
        WebDriver driver = driverInit();
        driver.get(Url.loginPage);
        acceptCookies(driver);
/*        sendKeys(driver, LocatorCss.loginField, "Login");
        sendKeys(driver, LocatorCss.passwordField, "Password");*/
        clickOnElement(driver, LocatorCss.GoButton);
        sendKeys(driver, Locators.loginField, "Login");
        sendKeys(driver, Locators.passwordField, "Password");
        driver.findElement(LocatorCss.searchIcon3).click();
        Thread.sleep(2000);
        sendKeys(driver, LocatorCss.searchField2, "Test text");
        clickOnElement(driver, LocatorCss.searchButton);
        closeDriverWithWait(driver,4);
    }
}

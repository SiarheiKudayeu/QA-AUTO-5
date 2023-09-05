package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class Test1 {
    static WebDriver driver;
    static WaitersClass waitersClass;
    @BeforeClass
    public void precondition(){
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        waitersClass = new WaitersClass(driver);
        driver.get("https://uhomki.com.ua/");
    }


    @Test
    public void checkPageTitle(){
        driver.navigate().to("https://klopotenko.com/en/");
        try {
            waitersClass.waitForVisabilityOfElementAndReturn(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        assertTrue(driver.getTitle().contains("Chef Ievgen Klopotenko"),
                "Название страницы не содержит искомого буквосочетания");

        assertFalse(driver.getTitle().contains("Chef Ievgen Klopotenko2"),
                "Название страницы содержит искомое буквосочетание");
        assertEquals(driver.findElements(By.xpath("//ul[@id='menu-main_menu-en-1']//a")).get(0).getText(),
                "UKRAINIAN",
                "Я ожидал один текст, а получил текст "+ driver.findElements(By.xpath("//ul[@id='menu-main_menu-en-1']//a")).get(0).getText());

        assertNotEquals(driver.findElements(By.xpath("//ul[@id='menu-main_menu-en-1']//a")).get(0).getText(),
                "UKRAINIAN3",
                "Я ожидал один текст, а получил текст "+ driver.findElements(By.xpath("//ul[@id='menu-main_menu-en-1']//a")).get(0).getText());
    }

    @Test
    public void searchFieldFunction(){
        driver.navigate().to("https://www.guinnessworldrecords.com/search");
        String search = "handstand";
        waitersClass.waitForVisabilityOfElementAndReturn(By.id("search-term")).sendKeys(search);
        driver.findElement(By.id("search-button")).click();
        assertTrue(waitersClass.waitForVisabilityOfElementAndReturn(By.tagName("h2"))
                .getText().contains(search));
    }

    @Test
    public void workingCheckBox(){
        driver.navigate().to("https://www.guinnessworldrecords.com/Account/Login");
        try {
            waitersClass.waitForVisabilityOfElementAndReturn(By.id("ez-accept-all")).click();
        }catch (Exception e){
            e.printStackTrace();
        }
        WebElement checkBox = driver.findElement(By.id("RememberMe"));
        assertTrue(checkBox.isDisplayed());
        assertFalse(checkBox.isSelected());
        checkBox.click();
        assertTrue(checkBox.isSelected());
        //assertFalse(checkBox.isSelected(),"Чек бокс оказался выбранным");
        checkBox.click();
        assertFalse(checkBox.isSelected());
    }
    @Test
    public void sizeOfHeaderElements(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://uhomki.com.ua/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class = 'products-menu__container']")));
        List<WebElement> headerList = driver.findElements(By.xpath("//ul[@class = 'products-menu__container']/li"));
        int list = headerList.size();
        Assert.assertEquals(list, 11);
    }

    @AfterClass
    public void finishTesting(){
        driver.quit();
    }
}

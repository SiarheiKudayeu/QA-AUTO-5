package lesson5.homework_previous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWorkLesson4Task2 {
    /*2)
Написать метод в параметры которого принимаются два ВебЭлемента.
метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
какой из элементов располагается левее на странице,
а также какой из элементов занимает большую площадь.
Параметры метода могут также включать в себя другие аргументы, если это необходимо.

3)
Написать метод который выводит сообщение об айди элемента,
значении тэга элемента , значении класса элемента,
значении атрибута name элемента, текста данного элемента,
а также о координатах центра контейнера данного элемента.
*/
    public static void compareLocationOfElements(WebElement element1, WebElement element2) {
        int locationX1 = element1.getLocation().x;
        int locationX2 = element2.getLocation().x;
        if (locationX1 < locationX2) {
            System.out.println("Первый элемент находится левее второго");
        } else {
            System.out.println("Второй элемент находится левее первого");
        }

        int locationY1 = element1.getLocation().y;
        int locationY2 = element2.getLocation().y;
        if (locationY1 < locationY2) {
            System.out.println("Первый элемент находится выше второго");
        } else {
            System.out.println("Второй элемент находится выше первого");
        }

        int size1 = element1.getSize().height * element1.getSize().width;
        int size2 = element2.getSize().height * element2.getSize().width;
        if (size1 < size2) {
            System.out.println("Первый элемент занимает меньшую площадь чем второй");
        } else {
            System.out.println("Второй элемент занимает меньшую площадь чем первый");
        }
    }
    public static void getInfoAboutElement(WebElement element){
        System.out.println(element.getAttribute("id"));
        System.out.println(element.getTagName());
        System.out.println(element.getAttribute("class"));
        System.out.println(element.getAttribute("name"));
        System.out.println(element.getText());
        int xOfSearchButtonCentre = element.getLocation().x + element.getSize().width/2;
        int yOfSearchButtonCentre = element.getLocation().y + element.getSize().height/2;
        System.out.println("Координаты центра " + xOfSearchButtonCentre+", "+ yOfSearchButtonCentre);
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/kudayeusiarhei/Desktop/chromedriver2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Users/kudayeusiarhei/chrome/mac_arm-115.0.5790.102/chrome-mac-arm64/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://zoo.kiev.ua/");
        WebElement element1 = driver.findElement(By.xpath("//b[text()='КУПИТИ КВИТОК']"));
        WebElement element2 = driver.findElements(By.xpath("//label[contains(text(),'ВАРТІСТЬ КВИТКІВ')]")).get(0);
        compareLocationOfElements(element1, element2);
        System.out.println("");
        getInfoAboutElement(element1);
        System.out.println("");
        getInfoAboutElement(element2);
        driver.quit();
    }
}

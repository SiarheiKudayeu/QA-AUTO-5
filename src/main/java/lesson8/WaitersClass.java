package lesson8;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitersClass {
    private final WebDriver driver;
    private static final long EXPLICITY_WAIT = 10L;

    public WaitersClass(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait(Long duration){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeOutInSeconds){
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }
    public WebElement waitForVisabilityOfElementAndReturn(By locator){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void switchToFrame(By locator){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator),EXPLICITY_WAIT);
    }
    public Alert switchToAlert(){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }
}

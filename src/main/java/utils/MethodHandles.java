package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {
    protected WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    public MethodHandles(WebDriver driver){
        this.driver =driver;
    }

    private final By barNotification = By.cssSelector("#add-to-cart-button-5");
    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }
    private void explicitWait(By locator,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }
    protected void click(By locator,int time){
        explicitWait(locator,time);
        webElement(locator).click();
    }
    protected void sendKeys(By locator,int time,String text){
        explicitWait(locator,time);
        webElement(locator).sendKeys(text);
    }
    protected void hoverOverElement(By locator,int time){

        actions = new Actions(driver);
        explicitWait(locator,time);
        actions.moveToElement(webElement(locator)).build().perform();
    }

    protected boolean isDisplayed(By locator, int time){
        explicitWait(locator,time);
        return webElement(locator).isDisplayed();
    }
    public boolean barNotificationIsDisplayed(){
        return isDisplayed(barNotification,5);
    }

}

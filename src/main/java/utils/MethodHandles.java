package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class MethodHandles {
    protected WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    static ExtentReports extent;
    static ExtentTest test;
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
        setSteps();
        addBorderToElement(driver,webElement(locator));
        webElement(locator).click();
    }
    protected String getText(By locator, int time){
        explicitWait(locator,time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        return webElement(locator).getText();
    }
    protected void sendKeys(By locator,int time,String text){
        explicitWait(locator,time);
        setSteps();
        addBorderToElement(driver,webElement(locator));
        webElement(locator).sendKeys(text);
    }
    protected void hoverOverElement(By locator,int time){

        actions = new Actions(driver);
        explicitWait(locator,time);
        actions.moveToElement(webElement(locator)).build().perform();
    }

    protected boolean isDisplayed(By locator, int time){
        explicitWait(locator,time);
        addBorderToElement(driver,webElement(locator));
        return webElement(locator).isDisplayed();
    }
    public boolean barNotificationIsDisplayed(){
        return isDisplayed(barNotification,5);
    }

    private static String getMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length >= 2) {
            if (stackTraceElements.length >= 4)
                return stackTraceElements[4].getMethodName();
            return stackTraceElements[2].getMethodName();
        } else {
            return "Unknown";
        }
    }
    private void setSteps() {
        test.info(getMethodName());
    }
    private static void addBorderToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '5px solid blue'", element);
    }
    public static void myAssertEquals(Object actual, Object expected){
        test.info(MarkupHelper.createLabel(
                "------------------------- Expected Result -------------------------",
                ExtentColor.GREY));
        test.info((String) expected);
        test.info(
                MarkupHelper.createLabel(
                        "------------------------- Actual Result -------------------------",
                        ExtentColor.GREY));
        test.info((String) actual);
        assertEquals((Object)actual, (Object)expected, (String)null);
    }
}

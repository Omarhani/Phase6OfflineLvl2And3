package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class MethodHandles {
    protected WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    Select select;

    static ExtentReports extent;
    static ExtentTest test;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    private final By barNotification = By.cssSelector("#add-to-cart-button-5");

    private WebElement webElement(By locator) {
        return driver.findElement(locator);
    }

    private void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }
    protected void invisibilityOf(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.invisibilityOf(webElement(locator)),
                ExpectedConditions.invisibilityOfElementLocated(locator)
        ));
    }

    private void alertWait(int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    private void frameWait(int time, String nameOrID) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
    }

    protected void click(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).click();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clear(By locator, int time) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).clear();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected String getText(By locator, int time) {
        String text = null;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                text = webElement(locator).getText();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return text;
    }

    protected void sendKeys(By locator, int time, String text) {
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                webElement(locator).sendKeys(text);
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void hoverOverElement(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                actions.moveToElement(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void clickWithActions(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                actions.click(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void doubleClick(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                actions.doubleClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void contextClick(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                actions.contextClick(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }
    protected void clickAndHold(By locator, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                actions.clickAndHold(webElement(locator)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void dragAndDrop(By src, By target, int time) {
        actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(src, time);
                explicitWait(target, time);
                actions.dragAndDrop(webElement(src), webElement(target)).build().perform();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected boolean isDisplayed(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isDisplayed();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected boolean isSelected(By locator, int time) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            try {
                explicitWait(locator, time);
                setSteps();
                addBorderToElement(driver, webElement(locator));
                flag = webElement(locator).isSelected();
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        return flag;
    }

    protected void acceptAlert(int time) {
        alertWait(time);
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert(int time) {
        alertWait(time);
        driver.switchTo().alert().dismiss();
    }

    protected void sendKeysAlert(int time, String text) {
        alertWait(time);
        driver.switchTo().alert().sendKeys(text);
    }

    protected String getTextAlert(int time) {
        alertWait(time);
        return driver.switchTo().alert().getText();
    }

    protected void switchToFrameWithNameOrID(int time, String nameOrID) {
        frameWait(time, nameOrID);
        driver.switchTo().frame(nameOrID);
    }

    protected void switchToFrameWithWebElement(int time, By locator, String nameOrID) {
        for (int i = 0; i < 3; i++) {
            try {
                frameWait(time, nameOrID);
                driver.switchTo().frame(webElement(locator));
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
    }

    protected void selectByIndex(By locator, int index) {
        for (int i = 0; i < 3; i++) {
            try {
                select = new Select(webElement(locator));
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        select.selectByIndex(index);
    }

    protected void selectByValue(By locator, String value) {
        for (int i = 0; i < 3; i++) {
            try {
                select = new Select(webElement(locator));
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        select.selectByValue(value);
    }

    protected void selectByVisibleText(By locator, String visibleText) {
        for (int i = 0; i < 3; i++) {
            try {
                select = new Select(webElement(locator));
                break;
            } catch (StaleElementReferenceException e) {

            }
        }
        select.selectByVisibleText(visibleText);
    }

    public boolean barNotificationIsDisplayed() {
        return isDisplayed(barNotification, 5);
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

    public static void myAssertEquals(Object actual, Object expected) {
        test.info(MarkupHelper.createLabel(
                "------------------------- Expected Result -------------------------",
                ExtentColor.GREY));
        test.info((String) expected);
        test.info(
                MarkupHelper.createLabel(
                        "------------------------- Actual Result -------------------------",
                        ExtentColor.GREY));
        test.info((String) actual);
        assertEquals((Object) actual, (Object) expected, (String) null);
    }
}

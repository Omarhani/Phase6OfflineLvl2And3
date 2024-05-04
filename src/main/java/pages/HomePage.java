package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By loginLink = By.cssSelector(".ico-login");

    private final By computerLink = By.xpath("(//a[contains(text(),'Computers ')])[1]");

    private final By notBookLink = By.xpath("(//a[contains(text(),'Notebooks ')])[1]");

    public LoginPage clickOnLoginLink(){
        click(loginLink,6);
        return new LoginPage(driver);
    }

    private void hoverOverComputers(){
        hoverOverElement(computerLink,4);
    }

    private void clickOnNotBookLink(){
        click(notBookLink,5);
    }

    public NotBookPage navigateToNotBook(){
        hoverOverComputers();
        clickOnNotBookLink();
        return new NotBookPage(driver);
    }

}

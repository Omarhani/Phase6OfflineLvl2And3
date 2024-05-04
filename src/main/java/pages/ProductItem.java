package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ProductItem extends MethodHandles {
    public ProductItem(WebDriver driver) {
        super(driver);
    }
    private final By addToCartButton = By.cssSelector("#add-to-cart-button-5");

    public void clickOnAddToCartButton(){
        click(addToCartButton,5);
    }
}

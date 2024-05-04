package shoppingCart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NotBookPage;
import pages.ProductItem;

import static org.testng.Assert.assertTrue;

public class ShoppingCartTests extends BaseTests {

    @Test
    public void testNotificationBar(){
        NotBookPage notBookPage = homePage.navigateToNotBook();
        ProductItem productItem = notBookPage.clickOnProductLink("Asus N551JK-XO076H Laptop");
        productItem.clickOnAddToCartButton();
        assertTrue(productItem.barNotificationIsDisplayed());
    }
}

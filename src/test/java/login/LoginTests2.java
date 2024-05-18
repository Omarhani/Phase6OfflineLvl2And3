package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests2 extends BaseTests {

    @Test
    public void testSuccessfulLogin2() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(
                dataModel().Login.ValidCredentials.Username,
                dataModel().Login.ValidCredentials.Password);
    }
    @Test
    public void testSuccessfulLogin3() {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature("test","test");
    }
}

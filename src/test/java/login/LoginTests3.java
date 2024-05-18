package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests3 extends BaseTests {

    @Test
    public void testSuccessfulLogin5() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(
                dataModel().Login.ValidCredentials.Username,
                dataModel().Login.ValidCredentials.Password);
    }
    @Test
    public void testSuccessfulLogin6() {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature("testttttt","testttttt");
    }
}

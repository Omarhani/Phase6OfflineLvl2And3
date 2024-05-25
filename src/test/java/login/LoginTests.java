package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

import static utils.MethodHandles.myAssertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.loginFeature(
                dataModel().Login.ValidCredentials.Username,
                dataModel().Login.ValidCredentials.Password);
        myAssertEquals(loginPage.getValidationMessage(),"Please enter a valid email address.");
    }
}

package testcases;

import Pages.P03_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static testcases.Tc02_Register.invalidEmail;

public class Tc03_Login extends TestBase {

    P03_LoginPage loginPage;
    //TODO: Login with valid scenarios

    @Test(priority = 2, dependsOnGroups = {"step1"}, groups = {"step2"}
    )
    public void loginWithValidData()
    {
        System.out.println(Tc02_Register.email + "Email in login");
        String email = (Tc02_Register.email == null) ? "mostafamahmoudaboads@gmail.com" : Tc02_Register.email;
        String password = (Tc02_Register.password == null) ? "AB123456" : Tc02_Register.password;
        loginPage = new P03_LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.getMyAccountText());
    }

    //TODO: Login with invalid scenarios

    @Test(priority = 2)
    public void loginWithValidEmailAndInvalidPassword() {
        String email = (Tc02_Register.email == null) ? "mostafamahmoudaboads@gmail.com" : Tc02_Register.email;
        String password = "123";
        loginPage = new P03_LoginPage(driver);
        loginPage.login(email, password);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getErrorMessage());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void loginWithInvalidEmailAndValidPassword() {
        String password = (Tc02_Register.password == null) ? "AB123456" : Tc02_Register.password;
        loginPage.login(invalidEmail, password);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getErrorMessage());
        softAssert.assertAll();
    }


    @Test(priority = 4)
    public void loginWithInvalidEmailAndInvalidPassword() {
        String password = "Ab123";
        loginPage.login(invalidEmail, password);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getErrorMessage());
        softAssert.assertAll();
    }

    @Test(priority = 5, description = "Navigate to forgot password page")
    public void navigateToForgotPasswordPage() {
        loginPage = new P03_LoginPage(driver);
        loginPage.navigateToForgotPasswordPage();
    }

}



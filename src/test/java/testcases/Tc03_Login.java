package testcases;

import Pages.P01_HomeLayout;
import Pages.P03_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static testcases.Tc02_Register.invalidEmail;

public class Tc03_Login extends TestBase
{

    P03_LoginPage loginPage;
    //TODO: Login with valid scenarios

    @Test(priority = 1)
    public void loginWithValidData() throws InterruptedException {
        System.out.println(Tc02_Register.email + "Email in login");
        String email = (Tc02_Register.email == null) ? "mostafamahmoudaboads@gmail.com" : Tc02_Register.email;
        String password = (Tc02_Register.password == null ) ? "AB123456" : Tc02_Register.password;
        loginPage = new P03_LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertEquals(loginPage.getMyAccountText(), "My Account");
        Thread.sleep(2000);
    }

    //TODO: Login with invalid scenarios

    @Test(priority = 2)
    public void loginWithValidEmailAndInvalidPassword()
    {
        System.out.println(Tc02_Register.email + "Email in login");
        String email = (Tc02_Register.email == null ) ? "mostafamahmoudaboads@gmail.com" : Tc02_Register.email;
        String password = "123";
        loginPage = new P03_LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertEquals(loginPage.getErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");
    }

    String loginError = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    String loginError2 = "Warning: No match for E-Mail Address and/or Password.";

    @Test(priority = 3)
    public void loginWithInvalidEmailAndValidPassword()
    {
        invalidEmail = "mostafamahmcccccd@gmail.com";
        String password = (Tc02_Register.password == null ) ? "AB123456" : Tc02_Register.password;
        loginPage.login(invalidEmail, password);
        Assert.assertEquals(loginPage.getErrorMessage(), loginError);
    }


    @Test(priority = 4)
    public void loginWithInvalidEmailAndInvalidPassword()
    {
        invalidEmail = "mostafamahmcccccd@gmail.com";
        String password = "123";
        loginPage.login(invalidEmail, password);
        Assert.assertEquals(loginPage.getErrorMessage(), loginError);
    }

    @Test(priority = 5, description = "Navigate to forgot password page")
    public void navigateToForgotPasswordPage()
    {
        loginPage = new P03_LoginPage(driver);
        loginPage.navigateToForgotPasswordPage();
    }
}



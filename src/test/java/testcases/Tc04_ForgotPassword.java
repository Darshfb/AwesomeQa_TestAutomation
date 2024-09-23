package testcases;

import Pages.P04_ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static testcases.Tc02_Register.email;

public class Tc04_ForgotPassword extends TestBase
{

    P04_ForgotPasswordPage forgotPasswordPage;

    @Test(priority = 1, description = "Forgot password with valid email")
    public void forgotPasswordWithValidData(){
        forgotPasswordPage = new P04_ForgotPasswordPage(driver);
        System.out.println(Tc02_Register.email + "Email in forgot password " + forgotPasswordPage.getForgotPasswordSuccessText());
        forgotPasswordPage.forgotPassword(email);
        Assert.assertEquals(forgotPasswordPage.getForgotPasswordSuccessText(), "An email with a confirmation link has been sent your email address.");
    }

    @Test(priority = 2, description = "Forgot password with invalid email")
    public void forgotPasswordWithInvalidData(){
        forgotPasswordPage = new P04_ForgotPasswordPage(driver);
        forgotPasswordPage.forgotPassword("mostafamahmoudads32323@mail.com");
        Assert.assertEquals(forgotPasswordPage.getForgotPasswordSuccessText(), "Warning: The E-Mail Address was not found in our records, please try again!");


    }


}

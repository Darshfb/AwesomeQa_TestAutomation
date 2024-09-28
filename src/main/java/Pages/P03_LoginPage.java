package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_LoginPage
{
    public P03_LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "(//input)[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "(//div)[@class='alert alert-danger alert-dismissible']")
    WebElement errorMessage;

    @FindBy(xpath = "(//a)[text()='My Account'][2]")
    WebElement myAccountTextButton;

    @FindBy(xpath = "(//a)[text()='Forgotten Password']")
    WebElement forgotPasswordButton;

    public void login(String email, String password)
    {
        this.email.clear();
        this.password.clear();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public Boolean getErrorMessage(){
        return errorMessage.getText().equals("Warning: No match for E-Mail Address and/or Password.");
    }

    public Boolean getMyAccountText(){
        return myAccountTextButton.getText().equals("My Account");
    }

    public void navigateToForgotPasswordPage(){
        forgotPasswordButton.click();
    }


}

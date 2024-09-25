package testcases;

import Pages.P01_HomePage;
import Pages.P02_RegisterPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc02_Register extends TestBase {

    static String email;
    static String password;
    static  String invalidEmail = "mostafamahmoud32323";
    P02_RegisterPage registerPage;
    Faker faker;

    // TODO: Valid Scenarios
    @Test(priority = 1, description = "Register with valid data", groups = {"step2"},dependsOnGroups = {"step1"})
    public void registerWithValidEmailAndPassword() {
        P01_HomePage homeLayout = new P01_HomePage(driver);
        homeLayout.enterRegisterPage();
        registerPage = new P02_RegisterPage(driver);
        faker = new Faker();

        registerPage.register(
                faker.name().firstName(),
                faker.name().lastName(),
                email = faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                password = faker.internet().password(),
                false,
                true
        );

        System.out.println("email: " + email + " password: " + password);
        Assert.assertEquals(registerPage.getMyAccountText(), "My Account");

    }

    // TODO: Invalid Scenarios

    @Test(priority = 2, description = "Register with valid email invalid password")
    public void registerWithValidEmailAndInvalidPassword() {
        registerPage = new P02_RegisterPage(driver);
        faker = new Faker();
        registerPage.register(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                "123",
                true,
                true
        );
        Assert.assertEquals(registerPage.checkPasswordErrorMessage("password"), "Password must be between 4 and 20 characters!");
    }

    @Test(priority = 3, description = "Register with inValid email valid password")
    public void registerWithInvalidEmailAndPassword()
    {
        registerPage.register(
                faker.name().firstName(),
                faker.name().lastName(),
                invalidEmail,
                faker.phoneNumber().phoneNumber(),
                faker.internet().password(),
                true,
                true
        );
        Assert.assertEquals(registerPage.checkPasswordErrorMessage("email"), "Your Personal Details");


    }

    @Test(priority = 4, description = "Register with inValid data")
    public void registerWithInvalidEmailAndInvalidPassword()
    {
        registerPage.register(
                faker.name().firstName(),
                faker.name().lastName(),
                invalidEmail,
                faker.phoneNumber().phoneNumber(),
                "123",
                true,
                true
        );
        Assert.assertEquals(registerPage.checkPasswordErrorMessage("password"), "Password must be between 4 and 20 characters!");
        Assert.assertEquals(registerPage.checkPasswordErrorMessage("email"), "Your Personal Details");
    }

    @Test(priority = 5, description = "Register with valid data without policy agreement")
    public void registerWithValidDataWithoutPolicyAgreement() {
        registerPage.register(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().password(),
                true,
                false
        );
        Assert.assertEquals(registerPage.checkPasswordErrorMessage("policy"), "Warning: You must agree to the Privacy Policy!");

    }


}

package testcases;

import Pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tc01_Home extends TestBase {
    P01_HomePage homeLayout;

    @Test(priority = 1, groups = {"step1"})
    public void validateEnteringRegisterPage() {
        homeLayout = new P01_HomePage(driver);
        homeLayout.enterRegisterPage();
    }

    @Test(priority = 1, groups = {"step1"})
    public void validateEnteringLoginPage() {
        homeLayout = new P01_HomePage(driver);
        homeLayout.enterLoginPage();
    }

    @Test(priority = 3)
    public void validateLogout() throws InterruptedException {
//        homeLayout = new P01_HomeLayout(driver);
        Thread.sleep(2000);

        homeLayout.logout();
    }


    @Test(priority = 1, description = "Searching for items", dependsOnGroups = {"step2"})
    public void searchingForItems() throws InterruptedException {
        homeLayout = new P01_HomePage(driver);
        homeLayout.search("MacBook");
        Assert.assertTrue(homeLayout.searchResult("MacBook"));
        Thread.sleep(1000);
    }

    @Test(priority = 3, description = "Change currency to Euro")
    void changeCurrencyToEuro() throws InterruptedException {
        homeLayout = new P01_HomePage(driver);
        homeLayout.openCurrencyDropMenu(false);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homeLayout.getEuroText());
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    @Test(priority = 2, description = "Change currency Randomly", dependsOnGroups = {"step2"})
    public void changeCurrencyRandomly() throws InterruptedException {
        homeLayout = new P01_HomePage(driver);
        homeLayout.openCurrencyDropMenu(true);
        Thread.sleep(1000);
    }

    @Test(priority = 5, dependsOnGroups = {"step2"})
    public void selectCategories() throws InterruptedException {
        homeLayout.openCategoryDropMenu();

//        System.out.println(homeLayout.isSelectedCategoryTrue());
        System.out.println(homeLayout.isSelectedCategoryTrue() + " getTitle" );
        Thread.sleep(1000);
    }

    @Test(priority = 3, dependsOnGroups = {"step2"})
    public void addItemToCart() {
        homeLayout.addItemToCartFromHome();
        Assert.assertTrue(homeLayout.getCartTotal().contains("2"));
    }

    @Test(priority = 4, dependsOnGroups = {"step2"})
    public void addToWishList() {
        homeLayout.addItemToWishListFromHome();
    }

    @Test(priority = 4)
    public void goToCart() {
        homeLayout.navigateToCart();
    }


}

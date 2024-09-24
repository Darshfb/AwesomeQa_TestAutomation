package testcases;

import Pages.P01_HomePage;
import org.testng.annotations.Test;

public class Tc01_Home extends TestBase
{
    P01_HomePage homeLayout;

    @Test(priority = 1)
    public void validateEnteringRegisterPage()
    {
        homeLayout = new P01_HomePage(driver);
        homeLayout.enterRegisterPage();
    }

    @Test(priority = 2, groups = {"step1"})
    public void validateEnteringLoginPage()
    {
        homeLayout = new P01_HomePage(driver);
        homeLayout.enterLoginPage();
    }

    @Test(priority = 3)
    public void validateLogout() throws InterruptedException {
//        homeLayout = new P01_HomeLayout(driver);
        Thread.sleep(2000);

        homeLayout.logout();
    }


    @Test(priority = 4)
    public void search(){
        homeLayout.search("MacBook");
    }

    @Test(priority = 5, dependsOnGroups = {"step2"})
    public void selectCategories() throws InterruptedException {
        homeLayout.openCategoryDropMenu();
        System.out.println("Hello world");
        Thread.sleep(2000);
    }

    @Test(priority = 3, description = "Change currency to Euro")
    void changeCurrencyToEuro() throws InterruptedException {
        homeLayout = new P01_HomePage(driver);
        homeLayout.openCurrencyDropMenu(false);
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Change currency Randomly", dependsOnGroups = {"step2"})
    public void changeCurrencyRandomly() throws InterruptedException {
        homeLayout = new P01_HomePage(driver);
        homeLayout.openCurrencyDropMenu(true);
        Thread.sleep(10000);
    }

    @Test(priority = 1, description = "Searching for items", dependsOnGroups = {"step2"})
    public void searchingForItems() throws InterruptedException {
        homeLayout = new P01_HomePage(driver);
        homeLayout.search("MacBook");
        Thread.sleep(10000);

    }
}

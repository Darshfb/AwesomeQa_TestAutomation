package testcases;

import Pages.P01_HomeLayout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc01_HomeLayout extends TestBase
{
    P01_HomeLayout homeLayout;


    @Test(priority = 1)
    public void validateEnteringRegisterPage()
    {
        homeLayout = new P01_HomeLayout(driver);
        homeLayout.enterRegisterPage();
    }

    @Test(priority = 2)
    public void validateEnteringLoginPage()
    {
        homeLayout = new P01_HomeLayout(driver);
        homeLayout.enterLoginPage();
    }

    @Test
    public void validateLogout() throws InterruptedException {
//        homeLayout = new P01_HomeLayout(driver);
        Thread.sleep(2000);

        homeLayout.logout();
    }

    @Test
    public void testTest(){
        System.out.println("Hello World");
        Assert.assertEquals("mostafa", "mostafa");
    }

    @Test(priority = 4)
    public void search(){
        homeLayout.search("MacBook");
    }
}

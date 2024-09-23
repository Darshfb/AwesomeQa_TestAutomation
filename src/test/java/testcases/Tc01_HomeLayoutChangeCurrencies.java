package testcases;

import Pages.P01_HomeLayout;
import org.testng.annotations.Test;

public class Tc01_HomeLayoutChangeCurrencies extends TestBase {
    P01_HomeLayout homeLayout;

    @Test(priority = 3, description = "Change currency to Euro")
    void changeCurrencyToEuro() throws InterruptedException {
        homeLayout = new P01_HomeLayout(driver);
        homeLayout.openCurrencyDropMenu(false);
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Change currency Randomly")
    public void changeCurrencyRandomly() throws InterruptedException {
        homeLayout = new P01_HomeLayout(driver);
        homeLayout.openCurrencyDropMenu(true);
        Thread.sleep(2000);

    }


}

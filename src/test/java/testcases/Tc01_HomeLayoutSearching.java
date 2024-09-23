package testcases;

import Pages.P01_HomeLayout;
import org.testng.annotations.Test;

public class Tc01_HomeLayoutSearching extends TestBase{

    P01_HomeLayout homeLayout;
    @Test(priority = 1, description = "Searching for items")
    public void searchingForItems() {
        homeLayout = new P01_HomeLayout(driver);
        homeLayout.search("MacBook");
    }


}

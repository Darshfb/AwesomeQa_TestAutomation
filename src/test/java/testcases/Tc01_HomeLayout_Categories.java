package testcases;

import Pages.P01_HomeLayout;
import org.testng.annotations.Test;

public class Tc01_HomeLayout_Categories extends TestBase
{
    P01_HomeLayout homeLayout;

    @Test
    public void selectCategories() throws InterruptedException {
        homeLayout = new P01_HomeLayout(driver);
        homeLayout.openCategoryDropMenu();
        Thread.sleep(2000);
    }
}

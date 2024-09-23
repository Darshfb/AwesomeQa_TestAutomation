package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    static WebDriver driver;

    // Java class include before and after methods
    @BeforeTest
    public void setupWebDriver()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://awesomeqa.com/ui/");
    }


    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}

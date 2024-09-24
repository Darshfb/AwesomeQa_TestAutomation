package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static util.Utility.selectRandomElement;

public class P01_HomePage {
    WebDriver customDriver;

    public P01_HomePage(WebDriver driver) {
        customDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a)[@title='My Account']")
    WebElement accountElement;

    @FindBy(xpath = "(//a)[text()='Register']")
    WebElement registerElement;

    @FindBy(xpath = "(//a)[text()='Login'][1]")
    WebElement loginElement;

    @FindBy(xpath = "(//a)[text()='Logout'][1]")
    WebElement logout;

    public void enterRegisterPage() {
        accountElement.click();
        registerElement.click();
    }

    public void enterLoginPage() {
        accountElement.click();
        loginElement.click();
    }

    public void logout() {
        accountElement.click();
        logout.click();
    }

    @FindBy(name = "search")
    WebElement searchTextField;

    @FindBy(xpath = "(//button)[@type='button'][4]")
    WebElement searchButton;

    public void search(String searchText) {
        searchTextField.sendKeys(searchText);
        searchButton.click();
    }

    @FindBy(xpath = "(//span)[text()='Currency']")
    WebElement currency;

    @FindBy(xpath = "(//ul)[@class='dropdown-menu']/li")
    List<WebElement> currencyList;

    @FindBy(xpath = "(//button)[text()='€ Euro']")
    WebElement poundSterlingElement;

    public void openCurrencyDropMenu(Boolean getRandom) {
        currency.click();
        if (getRandom)
            selectRandomElement(currencyList).click();
        else
            poundSterlingElement.click();
    }

    @FindBy(xpath = "(//ul)[@class='nav navbar-nav']/li")
    List<WebElement> categoryList;

    public void openCategoryDropMenu() {
        WebElement category = selectRandomElement(categoryList);
        System.out.println("The selected category is: " + category.getText());
        Actions actions = new Actions(customDriver);
        actions.moveToElement(category).perform();
        category.click();

        try{
            List<WebElement> list = category.findElements(By.xpath("./div/div/ul/li"));
            if (list.isEmpty()) {
                System.out.println("There are no categories");
                System.out.println(list.size());
                System.out.println(list);
            } else {
                selectRandomElement(list).click();
                System.out.println("There is some categories");

            }
            }catch (StaleElementReferenceException e) {
            // Handle the exception and retry
            System.out.println("Stale element exception. Retrying...");
        }

    }


}

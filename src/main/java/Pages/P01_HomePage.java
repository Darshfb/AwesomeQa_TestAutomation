package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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
        if (getRandom) selectRandomElement(currencyList).click();
        else poundSterlingElement.click();
    }

    @FindBy(xpath = "(//ul)[@class='nav navbar-nav']/li")
    List<WebElement> categoryList;

    public void openCategoryDropMenu() {
        WebElement category = selectRandomElement(categoryList);
        System.out.println("The selected category is: " + category.getText());
        Actions actions = new Actions(customDriver);
        actions.moveToElement(category).perform();
        category.click();

        try {
            List<WebElement> list = category.findElements(By.xpath("./div/div/ul/li"));
            if (list.isEmpty()) {
                System.out.println("There are no categories");
                System.out.println(list.size());
                System.out.println(list);
            } else {
                selectRandomElement(list).click();
                System.out.println("There is some categories");

            }
        } catch (StaleElementReferenceException e) {
            // Handle the exception and retry
            System.out.println("Stale element exception. Retrying...");
        }

    }

    @FindBy(xpath = "(//div)[@id='content']/div[2]/div")
    List<WebElement> listOfProductsFromCategories;

    @FindBy(xpath = "(//div)[@class='row'][3]/div")
    List<WebElement> listOfProductsFromHome;

    @FindBy(xpath = "(//img)[@class='img-responsive']")
    WebElement websiteLogo;

    @FindBy(id = "cart-total")
    WebElement cartTotal;

    @FindBy(xpath = "(//div)[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    public void addItemToCartFromHome() {
        websiteLogo.click();
        String currentUrl = customDriver.getCurrentUrl();
        for (WebElement item : listOfProductsFromHome) {
            WebElement element = item.findElement(By.xpath(".//button[1]"));
            if (element.isDisplayed())
                element.click();
            if (successMessage.isDisplayed()) {
                System.out.println("The show that the item is added to cart=>...:   " + successMessage.getText());
            }
        }
        System.out.println("currentUrl" + currentUrl);
        WebDriverWait wait = new WebDriverWait(customDriver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.urlContains("https://awesomeqa.com/ui/index.php?route=product/product&product_id"));
        } catch (TimeoutException e) {
            System.err.println("URL did not change as expected within the timeout.");
        }
        String newUrl = customDriver.getCurrentUrl();

        System.out.println("newUrl" + newUrl);
        if (!newUrl.equals(currentUrl)) {
            System.out.println("It opened an item details");
        }
    }

    public void addItemToWishListFromHome() {
        websiteLogo.click();
        for (WebElement item : listOfProductsFromHome) {
            WebElement element = item.findElement(By.xpath(".//button[2]"));
            if (element.isDisplayed())
                element.click();
            if (successMessage.isDisplayed()) {
                System.out.println("The show that the item is added to wish list=>...:   " + successMessage.getText());
            }
        }
    }

    public String getCartTotal() {
        return cartTotal.getText();
    }

    @FindBy(xpath = "(//i)[@class='fa fa-shopping-cart'][1]")
    WebElement cartIcon;

    public void navigateToCart(){
        cartIcon.click();
    }


}

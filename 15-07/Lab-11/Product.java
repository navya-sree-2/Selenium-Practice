package Labs.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class Product {
	
    WebDriver driver;
    WebDriverWait wait;

    public Product(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Women")
    WebElement womenTab;

    @FindBy(id = "layered_id_feature_21")
    WebElement filterCheckbox;

    @FindBy(css = "ul.product_list > li")
    WebElement firstProductCard;

    @FindBy(xpath = "//span[text()='More']")
    WebElement moreButton;

    @FindBy(id = "group_1")
    WebElement sizeDropdown;

    @FindBy(xpath = "//p[@id='add_to_cart']/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@title, 'Close window')]")
    WebElement closeCartPopup;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cartButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]")
    WebElement quantityField;

    @FindBy(xpath = "//a[@title='Proceed to checkout' and contains(@class, 'standard-checkout')]")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//h1[@class='page-subheading']")
    WebElement addressHeading;

    @FindBy(css = "a.logout")
    WebElement logoutLink;

    @FindBy(css = "a.login")
    WebElement loginAgainLink;

    public void applyFilterAndOpenProduct() throws InterruptedException {
        womenTab.click();
        filterCheckbox.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(firstProductCard));
        new Actions(driver).moveToElement(firstProductCard).perform();
        moreButton.click();
    }

    public void selectSizeAndAddToCart() throws InterruptedException {
        new Select(sizeDropdown).selectByIndex(1);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.visibilityOf(closeCartPopup)).click();
    }

    public void updateCartQuantity(String qty) throws InterruptedException {
        cartButton.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(quantityField)).clear();
        quantityField.sendKeys(qty);
        Thread.sleep(5000);
        proceedToCheckout.click();
    }
    
    public boolean isCartConfirmationVisible() {
        return closeCartPopup.isDisplayed();
    }

    public boolean isOnAddressPage() {
        return addressHeading.isDisplayed();
    }

    public void logout() throws InterruptedException {
        logoutLink.click();
        Thread.sleep(1000);
    }

    public boolean isLoggedOut() {
        return loginAgainLink.isDisplayed();
    }
}


package Labs.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    WebElement loginButton;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;

    @FindBy(xpath = "//div[@class='header_user_info']")
    WebElement userHeader;

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitLogin.click();
    }

    public boolean isUserLoggedIn() {
        return userHeader.isDisplayed();
    }
	
}

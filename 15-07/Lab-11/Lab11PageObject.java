package Labs.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Lab11PageObject {
	WebDriver driver;
    Login loginPage;
    Product productPage;

    @BeforeClass
    public void beforeClass() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");

        loginPage = new Login(driver);
        productPage = new Product(driver);
    }

    @Test(priority = 1, dataProvider = "dp")
    public void testLogin(String username, String password) {
        loginPage.clickLogin();
        loginPage.login(username, password);
        if(loginPage.isUserLoggedIn()) {
        	Assert.assertTrue(true);
        	System.out.println("User Logged in");
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("User Log in failed");
        }
    }

    @Test(priority = 2)
    public void testProductSelectionAndCart() throws InterruptedException {
        productPage.applyFilterAndOpenProduct();
        productPage.selectSizeAndAddToCart();
        if(productPage.isCartConfirmationVisible()) {
        	Assert.assertTrue(true);
        	System.out.println("Item added to cart");
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("Item not added to cart!");
        }
        System.out.println("Item added to cart");
    }

    @Test(priority = 3)
    public void testUpdateCartAndCheckout() throws InterruptedException {
        productPage.updateCartQuantity("3");
        if(productPage.isOnAddressPage()) {
        	Assert.assertTrue(true);
        	System.out.println("Proceeded to pay");        	
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("Checkout page not reached!");
        }
        System.out.println("Proceeded to checkout");
    }

    @Test(priority = 4)
    public void testLogout() throws InterruptedException {
        productPage.logout();
        if(productPage.isLoggedOut()) {
        	Assert.assertTrue(true);
        	System.out.println("Logged out successfully");        	
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("Logout failed!");
        }
        System.out.println("Logout successful");
    }

    @DataProvider
    public Object[][] dp() {
		return new Object[][] {
			new Object[] {"navu@gmail.com", "navya123" },
		};
	}

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

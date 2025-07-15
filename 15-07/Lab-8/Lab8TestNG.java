package Jul14;

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class Lab8TestNG {
	
	WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
    }

    @Test(dataProvider="dp", priority = 1)
    public void loginTest(String un, String pwd) {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(un);
        driver.findElement(By.id("passwd")).sendKeys(pwd);
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement user = driver.findElement(By.xpath("//div[@class='header_user_info']"));
        if(user.isDisplayed()) {
        	Assert.assertTrue(true);
        	System.out.println("User Logged in");
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("User Log in failed");
        }
        
    }

    @Test(priority = 2)
    public void selectDressAndAddToCart() throws InterruptedException {
        driver.findElement(By.partialLinkText("Women")).click();
        driver.findElement(By.id("layered_id_feature_21")).click();
        Thread.sleep(6000);

        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.product_list > li")));
        Actions a = new Actions(driver);
        a.moveToElement(productCard).perform();
        driver.findElement(By.xpath("//span[text()='More']")).click();

        Thread.sleep(1000);
        WebElement size = driver.findElement(By.id("group_1"));
        Select s = new Select(size);
        s.selectByIndex(1);
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")).click();

        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@title, 'Close window')]")));
        if(close.isDisplayed()) {
        	Assert.assertTrue(true);
        	System.out.println("Item added to cart");
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("Item not added to cart!");
        }
        close.click();
    }

    @Test(priority = 3)
    public void updateCartAndCheckout() throws InterruptedException {
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();

        WebElement qty = driver.findElement(By.xpath("//input[@name='quantity_5_23_0_0']"));
        qty.clear();
        qty.sendKeys("3");
        System.out.println("Cart updated to 3 products");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@title='Proceed to checkout' and contains(@class, 'standard-checkout')]")).click();

        WebElement address = driver.findElement(By.xpath("//h1[@class='page-subheading']"));
        if(address.isDisplayed()) {
        	Assert.assertTrue(true);
        	System.out.println("Proceeded to pay");        	
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("Checkout page not reached!");
        }
    }

    @Test(priority = 4)
    public void logoutTest() throws InterruptedException {
        driver.findElement(By.cssSelector("a.logout")).click();
        Thread.sleep(1000);

        WebElement ele = driver.findElement(By.cssSelector("a.login"));
        if(ele.isDisplayed()) {
        	Assert.assertTrue(true);
        	System.out.println("Logged out successfully");        	
        }
        else {
        	Assert.assertTrue(false);
        	System.out.println("Logout failed!");
        }
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

package Jul14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Lab6 {

    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.automationpractice.pl/index.php");

        WebElement login = driver.findElement(By.className("login"));
        login.click();
        driver.findElement(By.id("email")).sendKeys("navu@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("navya123");
        driver.findElement(By.id("SubmitLogin")).click();
        
        WebElement user = driver.findElement(By.xpath("//div[@class='header_user_info']"));
        if(user.isDisplayed()) {
        	System.out.println("User Logged in");
        }


        WebElement dress = driver.findElement(By.partialLinkText("Women"));
        dress.click();
        
        driver.findElement(By.id("layered_id_feature_21")).click();        
        
        Thread.sleep(6000);
        
        WebElement productCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.product_list > li")));
        
        Actions actions = new Actions(driver);
        actions.moveToElement(productCard).perform();
        
        driver.findElement(By.xpath("//span[text()='More']")).click();
        
        WebElement size = driver.findElement(By.xpath("//select[@id='group_1']"));
        Select s = new Select(size);
        s.selectByIndex(1);
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")).click();
        
        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@title, 'Close window')]")));
        if(close.isDisplayed()) {
        	System.out.println("Item added to cart");
        }
        close.click();
        
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
        
        WebElement qty = driver.findElement(By.xpath("//input[@name='quantity_5_23_0_0']"));
        qty.clear();
        qty.sendKeys("3");
        System.out.println("Cart updated to 3 products");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//a[@title='Proceed to checkout' and contains(@class, 'standard-checkout')]")).click();
        
        WebElement address = driver.findElement(By.xpath("//h1[@class='page-subheading']"));
        if(address.isDisplayed()) {
        	System.out.println("Proceeded to pay");
        }
        
        driver.findElement(By.cssSelector("a.logout")).click();
        
        Thread.sleep(1000);
        
        WebElement ele = driver.findElement(By.cssSelector("a.login"));
        if(ele.isDisplayed()) {
        	System.out.println("Logged out succesfully");
        }
        
//        driver.quit();
    }

}

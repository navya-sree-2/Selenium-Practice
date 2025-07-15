package Jul15;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PageObjectModel {
	@Test
  	public void f() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String username="Admin";
		String password="admin123";
		Login_PO obj = new Login_PO(driver);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonsubmit();
	}
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

}

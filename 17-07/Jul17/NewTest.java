package Jul17;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;
	
	public void login1(String username, String password) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(dataProvider = "dp1", priority=1)
	public void login(String username, String password) {
		
		login1(username, password);

		if(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "dp2", priority=2)
	public void leave(Integer days,String username, String password) {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report1.html");
		
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Verify login");
		
		
		
		login1(username, password);
		driver.findElement(By.xpath("//span[text()='Leave']")).click();

		WebElement leavelist=driver.findElement(By.xpath("//h5[text()='Leave List']"));
		if(leavelist.isDisplayed()) {
			Assert.assertEquals(leavelist.isDisplayed(), true);
			test.pass("Leave list is displayed");
		}
		else {
			Assert.assertEquals(leavelist.isDisplayed(), false);
			test.fail("Leave list is not displayed"); 
		}
		extent.flush();
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}


	@DataProvider
	public Object[][] dp1() {
		return new Object[][] {
			new Object[] {"Admin", "admin123" },
		};
	}
	
	@DataProvider
	public Object[][] dp2() {
	    return new Object[][] {
	    	new Object[] {3, "Admin", "admin123" },
	    };
	}
	
	@BeforeClass
	public void beforeClass() {
//		System.out.println("This is before class");
	}

	@AfterClass
	public void afterClass() {
//		System.out.println("This is after class");
	}

	@BeforeTest
	public void beforeTest() {
//		System.out.println("This is before test");
	}

	@AfterTest
	public void afterTest() {
//		System.out.println("This is after test");
	}

	@BeforeSuite
	public void beforeSuite() {
//		System.out.println("This is before suite");
	}

	@AfterSuite
	public void afterSuite() {
//		System.out.println("This is after suite");
	}

}

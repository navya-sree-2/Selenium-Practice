package Labs.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		
		d.get("http://www.automationpractice.pl/index.php");
		d.manage().window().maximize();
		
		d.findElement(By.linkText("Sign in")).click();
		
		Thread.sleep(5000);
		
		WebElement email=d.findElement(By.id("email_create"));
		if(email.isDisplayed()) {
			email.sendKeys("navyasreen@gmail.com");
			System.out.println("email is displayed");
		}
		else {
			System.out.println("email is not displayed");;
		}
		d.findElement(By.id("SubmitCreate")).click();
		
		Thread.sleep(5000);
		
		d.findElement(By.id("uniform-id_gender2")).click();
		d.findElement(By.id("customer_firstname")).sendKeys("Navya Sree");
	    d.findElement(By.id("customer_lastname")).sendKeys("Nallamothu");
        d.findElement(By.id("passwd")).sendKeys("Navya@123");
        
        WebElement day = d.findElement(By.id("days"));
        Select s1 = new Select(day);
        s1.selectByIndex(2);
        WebElement month = d.findElement(By.id("months"));
        Select s2 = new Select(month);
        s2.selectByValue("6");
        WebElement year = d.findElement(By.id("years"));
        Select s3 = new Select(year);
        s3.selectByValue("2004");
        
        d.findElement(By.id("uniform-newsletter")).click();
        WebElement flag = d.findElement(By.id("submitAccount"));
        flag.click();
        
	}

}

package Jul15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_PO {
	WebDriver driver;
	
	By uname=By.name("username");
	By pword=By.name("password");
	By submit=By.xpath("//button[@type='submit']");
	
	
	public Login_PO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public void enterusername(String username)
	{
		driver.findElement(uname).sendKeys(username);
	}
			
	public void enterpassword(String password)
	{
		driver.findElement(pword).sendKeys(password);
	}
	
	public void clickonsubmit()
	{
		driver.findElement(submit).click();
	}
}

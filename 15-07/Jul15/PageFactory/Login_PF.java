package Jul15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PF {
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	public void enterusername()
	{
		uname.sendKeys("Admin");
	}
	
	public void enterpassword()
	{
		pword.sendKeys("admin123");
	}
	
	
	public void clickonsubmit()
	{
		submit.click();
	}
}

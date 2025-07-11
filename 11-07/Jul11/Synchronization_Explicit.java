package Jul11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization_Explicit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		WebElement username=driver.findElement(By.name("username"));

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement username=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("username"))));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		username.sendKeys("Admin");
		
		System.out.println("Explicit wait time - done");
	}

}

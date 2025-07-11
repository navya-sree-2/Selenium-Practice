package Jul11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		js.executeScript("alert('hello');");
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h5[contains(text(),'Amazon Web Services')]")).click();
	}

}

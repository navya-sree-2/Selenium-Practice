package Jul11;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://letcode.in/window");
		driver.findElement(By.id("home")).click();
		System.out.println("parent window:"+driver.getWindowHandle());
		driver.findElement(By.id("multi")).click();
		Set<String> l1= driver.getWindowHandles();

		System.out.println("size:"+l1.size());
		for(String childwin:l1) {
			driver.switchTo().window(childwin);
			System.out.println(driver.getCurrentUrl());
			String url=driver.getCurrentUrl();
			if(url.equals("https://letcode.in/alert")) {
				System.out.println("alert window is disapled");
			}
			
		}
//		System.out.println(driver.getCurrentUrl());
		driver.close();
//		System.out.println(driver.getCurrentUrl());
		
	}
}

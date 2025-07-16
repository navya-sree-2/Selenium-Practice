package Jul16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelLogin_1 {
	@Test(dataProvider="logindata")
	public void f(String username,String password) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
		driver.quit();
	  
	}
	
	@DataProvider
	public String[][] logindata() throws IOException {
		String[][] data=new String[5][2];
		String projectpath=System.getProperty("user.dir");
		System.out.println("project path is:"+projectpath);
		File file1=new File(projectpath+"\\testdata.xlsx");
		FileInputStream fs=new FileInputStream(file1);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet worksheet=workbook.getSheetAt(0);
		int rowcount=worksheet.getPhysicalNumberOfRows();
		System.out.println("row count:"+rowcount);
		for(int i=1;i<rowcount;i++) {
			data[i-1][0]=worksheet.getRow(i-1).getCell(0).getStringCellValue();
			data[i-1][1]=worksheet.getRow(i-1).getCell(1).getStringCellValue();
		}
		return data;
	}
}

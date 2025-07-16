package Jul16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_12 {
	String projectpath=System.getProperty("user.dir");
	@Test(dataProvider="registerData")
	public void f(String email, String gender, String fn, String ln, String pwd, String dob) throws ParseException, IOException {
		
		Properties prob=new Properties();
		FileInputStream f1=new FileInputStream(projectpath+"//register.properties");
		prob.load(f1);
		String url= prob.getProperty("url");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        if(gender.equalsIgnoreCase("male")) {
            driver.findElement(By.id("uniform-id_gender1")).click();
        }
        else {
            driver.findElement(By.id("uniform-id_gender2")).click();
        }
        driver.findElement(By.id("customer_firstname")).sendKeys(fn);
        driver.findElement(By.id("customer_lastname")).sendKeys(ln);
        driver.findElement(By.id("passwd")).sendKeys(pwd);
        
        SimpleDateFormat excel_dob = new SimpleDateFormat("M/d/yy");
        Date dob_d = excel_dob.parse(dob);
		
        SimpleDateFormat dob_format = new SimpleDateFormat("dd-MM-yyyy");
        String date_of_birth = dob_format.format(dob_d);
        
        String[] dob_ = date_of_birth.split("-");
        int day = Integer.parseInt(dob_[0]);
        int month = Integer.parseInt(dob_[1]);
        int year = Integer.parseInt(dob_[2]);

        Select s1 = new Select(driver.findElement(By.id("days")));
        s1.selectByIndex(day);
        Select s2 = new Select(driver.findElement(By.id("months")));
        s2.selectByValue(String.valueOf(month));
        Select s3 = new Select(driver.findElement(By.id("years")));
        s3.selectByValue(String.valueOf(year));

        driver.findElement(By.id("uniform-newsletter")).click();
        driver.findElement(By.id("submitAccount")).click();
		  
		driver.quit();
	}
	
	@DataProvider
	public Object[][] registerData() throws IOException {
		String projectpath = System.getProperty("user.dir");
		System.out.println("project path is:"+projectpath);
		File f = new File(projectpath+"\\register.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet ws = wb.getSheetAt(0);
		int rc = ws.getPhysicalNumberOfRows();
		System.out.println("row count:"+rc);
		Object[][] data = new Object[rc-1][6];
		DataFormatter formatter = new DataFormatter();
		for(int i=1; i<rc; i++) {
			data[i-1][0] = ws.getRow(i).getCell(0).getStringCellValue();
			data[i-1][1] = ws.getRow(i).getCell(1).getStringCellValue();
			data[i-1][2] = ws.getRow(i).getCell(2).getStringCellValue();
			data[i-1][3] = ws.getRow(i).getCell(3).getStringCellValue();
			data[i-1][4] = ws.getRow(i).getCell(4).getStringCellValue();
			data[i-1][5] = formatter.formatCellValue(ws.getRow(i).getCell(5));
			
		}
		return data;
	}
}

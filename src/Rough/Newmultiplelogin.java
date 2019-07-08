package Rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.lang.String;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Xls_Reader;



public class Newmultiplelogin {

	public static WebDriver driver;
	Xls_Reader reader;
	String username1;
	String password1;
	
	@DataProvider(getdata="logindata")
	
	{
		
		
		reader = new Xls_Reader(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\logindatasheet.xlsx");
		
		for(int i=0;i< reader.getRowCount("logindata"); i++)
		{
			
		 username1 = reader.getCellData("logindata", "username", i);
		System.out.println("username1");

		 password1 = reader.getCellData("logindata", "password", i);
		System.out.println("password1");
		}
	}
	@Test(dataProvider = "logindata")
	public void DataDrivenFrameEx() throws InterruptedException, IOException

	{
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username1);

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password1);

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		Thread.sleep(5000);
		driver.close();
	}
	
	
	
	@AfterMethod

	public void closeapp()

	{

		driver.close();

	}
	}
	


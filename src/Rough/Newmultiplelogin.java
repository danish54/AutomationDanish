package Rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.lang.String;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Xls_Reader;

public class Newmultiplelogin {

	public static WebDriver driver;
	Xls_Reader reader;

	@Test(dataProvider = "getData")
	public void DataDrivenFrameEx(String username1, String password1) throws InterruptedException, IOException

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username1);

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password1);

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		Thread.sleep(2000);
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl());
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {

		reader = new Xls_Reader(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\logindatasheet.xlsx");

		// get row count in sheet
		int rowcount = reader.getRowCount("Newmultiplelogin");
		System.out.println("Row Count is " + rowcount);
		int colcount = reader.getColumnCount("Newmultiplelogin");
		System.out.println("Column Count is " + colcount);

		// object array
		Object[][] data = new Object[rowcount - 1][colcount];

		for (int rownum = 2; rownum <= rowcount; rownum++) {

			data[rownum - 2][0] = reader.getCellData("Newmultiplelogin", "username", rownum);
			System.out.println(data[rownum - 2][0]);

			data[rownum - 2][1] = reader.getCellData("Newmultiplelogin", "password", rownum);
			System.out.println(data[rownum - 2][1]);

		}
		return data;
	}

	@AfterMethod

	public void closeapp()

	{

		driver.quit();

	}
}

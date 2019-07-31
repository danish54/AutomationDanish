package crytobulls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeDataDani

{

	WebDriver driver;
	String path1 = "E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\ExcelWorksheet.xlsx";

	String text;
	
	
	@BeforeTest

	public void openapp()

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cryptobulls.exchange/");

		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test

	public void operation() throws InterruptedException, IOException

	{
		File fso = new File(path1);

		FileInputStream fis = new FileInputStream(fso);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet s = wb.getSheet("Sheet1");

		
		WebElement element = driver.findElement(By.xpath("//tbody[@id='viewpair']"));

		java.util.List<WebElement> countrow = element.findElements(By.tagName("tr"));

		System.out.println(countrow.size());

		for (int i = 53; i < countrow.size(); i++)

		{

			String s1 = "/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";
			
			String s2 = "]/td[";

			String s3 = "]";
			//Object[][] data = new Object[rowcount - 1][colcount];

			for (int j = 4; j <= 8; j++)

			{

				text = driver.findElement(By.xpath(s1 + i + s2 + j + s3)).getText();

				System.out.println(text);
				

				Row r = s.createRow(i-53);

				r.createCell(j-4).setCellValue(text);

				FileOutputStream fo = new FileOutputStream(path1);

				wb.write(fo);

				fo.close();
				Thread.sleep(6000);
}
			
			
}
		}
	@AfterTest

	public void closeapp()

	{

		driver.close();

	}
	}

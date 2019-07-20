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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homedata2raju

{

	WebDriver driver;

	JavascriptExecutor js;

	String path = "E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\testdata.xlsx";

	String path1 = "E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\test.xlsx";

	String text, text1, text2, text3, text4;

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

	// main test
	@Test

	public void operation() throws InterruptedException, IOException

	{

		WebElement element = driver.findElement(By.xpath("//tbody[@id='viewpair']"));

		java.util.List<WebElement> countrow = element.findElements(By.tagName("tr"));

		System.out.println(countrow.size());

		String pairent = "/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";

		String child = "]/td[3]";


		for (int i = 50; i < countrow.size(); i++)

		{

			String s1 = "/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";
			/// html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[3]
			String s2 = "]/td[";

			String s3 = "]";

			for (int j = 4; j <= 8; j++)

			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,400)");

				text = driver.findElement(By.xpath(s1 + i + s2 + j + s3)).getText();

				System.out.println(text);
				System.out.println("========================================================");

				File fso = new File(path1);

				FileInputStream fis = new FileInputStream(fso);

				XSSFWorkbook wb = new XSSFWorkbook(fis);

				XSSFSheet s = wb.getSheet("Sheet1");

				Row r = s.createRow(i);

				r.createCell(j-4).setCellValue(text);

				Thread.sleep(3000);

				FileOutputStream fo = new FileOutputStream(path1);

				wb.write(fo);

				fo.close();

			}

			pairent = "/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";
			child = "]";

			Thread.sleep(4000);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,400)");

			driver.findElement(By.xpath(pairent + i + child)).click();

			Thread.sleep(8000);

			String linkname = driver
					.findElement(By
							.xpath("//span[@class='poppins g-font-size-16 g-font-weight-600 g-color-gray-dark-v5 capitalize g-line-height-1_8']"))
					.getText();

			System.out.println("Coin Name =" + linkname);

			String twentyFourH = driver
					.findElement(By
							.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/h4[1]/span[1]"))
					.getText();

			System.out.println("24HHValue" + twentyFourH);

			String twentyFourL = driver
					.findElement(By
							.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/h4[1]/span[1]"))
					.getText();

			System.out.println("24HLValue =" + twentyFourL);

			String Lastprice = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/h4[1]"))
					.getText();

			System.out.println("Last price =" + Lastprice);

			String Sevendayschange = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/h5[1]"))
					.getText();

			System.out.println("7dayschange =" + Sevendayschange);

			String twentyFourHchange = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/h5[1]"))
					.getText();

			System.out.println("24HHchange =" + twentyFourHchange);

			String twentyFourHVolume = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/h5[1]"))
					.getText();

			System.out.println("24HHVolume =" + twentyFourHVolume);

			String twentyFourHFee = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/h5[1]"))
					.getText();

			System.out.println("24HFee =" + twentyFourHFee);
			File fso = new File(path);

			FileInputStream fis = new FileInputStream(fso);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet s = wb.getSheet("Sheet1");

			Row r = s.createRow(i);

			r.createCell(0).setCellValue(linkname);

			r.createCell(1).setCellValue(twentyFourH);

			r.createCell(2).setCellValue(twentyFourL);

			r.createCell(3).setCellValue(Lastprice);

			r.createCell(4).setCellValue(Sevendayschange);

			r.createCell(5).setCellValue(twentyFourHchange);

			r.createCell(6).setCellValue(twentyFourHVolume);

			r.createCell(7).setCellValue(twentyFourHFee);

			FileOutputStream fo = new FileOutputStream(path);

			wb.write(fo);

			fo.close();
			

			driver.navigate().back();
			Thread.sleep(6000);
		}
	}

	@AfterTest

	public void closeapp()

	{

		driver.close();

	}

}

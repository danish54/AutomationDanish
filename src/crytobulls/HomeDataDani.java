package crytobulls;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeDataDani

{

	WebDriver driver;

	JavascriptExecutor js;
	String text, text1, text2, text3, text4;

	@BeforeTest

	public void openapp()

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.cryptobulls.exchange/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test

	public void operation() throws InterruptedException, IOException

	{

		WebElement element = driver.findElement(By.xpath("//tbody[@id='viewpair']"));

		List<WebElement> countrow = element.findElements(By.tagName("tr"));

		System.out.println(countrow.size());

		for (int i = 1; i < countrow.size(); i++)

		{
			int v = 4, w = 5, x = 6, y = 7, z = 8;

			String parent1 = "/html[1]/body[1]/section[2]/div[2]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[";

			String mid = "]/td[";

			String child1 = "]";

			text = element.findElement(By.xpath(parent1 + i + mid + v + child1)).getText();

			text1 = element.findElement(By.xpath(parent1 + i + mid + w + child1)).getText();

			text2 = element.findElement(By.xpath(parent1 + i + mid + x + child1)).getText();

			text3 = element.findElement(By.xpath(parent1 + i + mid + y + child1)).getText();

			text4 = element.findElement(By.xpath(parent1 + i + mid + z + child1)).getText();

			System.out.println("LAST PRICE =" + text);

			System.out.println("24H CHANGE =" + text1);

			System.out.println("24H HIGH    =" + text2);

			System.out.println("24H LOW    =" + text3);

			System.out.println("24H VOLUME(BTC)=" + text4);
			System.out.println("========================================================");

			Thread.sleep(2000);

			for (int j = 1; j <= 1; j++)

			{

			countrow.get(i).click();
			Thread.sleep(8000);

			String linkname = driver
					.findElement(By
							.xpath("//span[@class='poppins g-font-size-16 g-font-weight-600 g-color-gray-dark-v5 capitalize g-line-height-1_8']"))
					.getText();

			System.out.println(linkname);

			Thread.sleep(1000);

			String twentyFourH = driver
					.findElement(By
							.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/h4[1]/span[1]"))
					.getText();

			System.out.println(twentyFourH);

			Thread.sleep(1000);

			String twentyFourL = driver
					.findElement(By
							.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/h4[1]/span[1]"))
					.getText();

			System.out.println(twentyFourL);

			Thread.sleep(1000);

			String Lastprice = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/h4[1]"))
					.getText();

			System.out.println(Lastprice);

			Thread.sleep(1000);

			String Sevendayschange = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/h5[1]"))
					.getText();

			System.out.println(Sevendayschange);

			Thread.sleep(1000);

			String twentyFourHchange = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/h5[1]"))
					.getText();

			System.out.println(twentyFourHchange);

			Thread.sleep(1000);

			String twentyFourHVolume = driver
					.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/h5[1]"))
					.getText();

			System.out.println(twentyFourHVolume);

			Thread.sleep(1000);

			String twentyFourHFee = driver.findElement(
							By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/h5[1]")).getText();
			System.out.println(twentyFourHFee);

			if (text1.equals(twentyFourHchange))
			{
				System.out.println("PASS");
			} else
			{
				System.out.println("FALS");
			}
			driver.navigate().back();
			js.executeScript("arguments[0].scrollIntoView(true);", element);

			element = driver.findElement(By.xpath("//tbody[@id='viewpair']"));

			countrow = element.findElements(By.tagName("tr"));
		}
	}
}
}

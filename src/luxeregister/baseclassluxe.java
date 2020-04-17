package luxeregister;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseclassluxe {

	public static WebDriver driver;

	// Setup Browser
	public void Setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ACER.NITRO 5\\Downloads\\eclipse\\workspace\\dependencies\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	// Login
	public void login() {

		baseclassluxe base = new baseclassluxe();

		base.Setup();
		driver.get("https://dev.theluxeregister.com/");
		
		boolean Ele = base.isElementPresent(driver, By.className("nav-link sign-in-btn"));
		
		if(Ele=true) {
			driver.findElement(By.className("nav-link sign-in-btn")).click();
		}

		
		driver.findElement(By.id("userEmail")).sendKeys("danish.ali@hipster-inc.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.xpath("//a[@class='btn dark-btn sign-btn']")).click();

	}

	// is Element Present Method
	public boolean isElementPresent(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		}

		catch (Exception e)

		{

			return false;
		}

		finally {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

}

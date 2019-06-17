package packagesecond;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Chromebrowseropen 
{
	WebDriver driver;
	
	@Test
	
	public void openapp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
	}
	
	@Test (priority=1)
	public void closeapp()
	{
		
	driver.quit();	
		
	}

}


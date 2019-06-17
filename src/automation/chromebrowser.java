package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromebrowser
{
public static	WebDriver driver;
 
	public void openbrowser()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe" );
	    driver=new ChromeDriver();
		
		//driver=new FirefoxDriver();
	     driver.manage().window().maximize();
	     driver.get("https://google.com");
		
		}

	public void closebrowser()
	{
		
		driver.close();
		
	}
	
}

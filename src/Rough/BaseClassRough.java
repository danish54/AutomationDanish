package Rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ByXPath;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassRough {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	public void Setup() throws IOException, InterruptedException {

		// loading config properties
		
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Properties\\config.properties");
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Properties\\OR.properties");
		OR.load(fis);
		// instentiating browser

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		// launching browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		

	}

	public void login() throws IOException, InterruptedException {

		BaseClassRough base = new BaseClassRough();

		base.Setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getProperty("baseurl"));
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id(OR.getProperty("login_button_id"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void captureSnapShot() throws IOException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File ssFile = ((TakesScreenshot) (driver)).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileUtils.copyFile(ssFile, new File(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\" + sdf.format(d) + ".jpg"));
	}

	public void clickbyxpath(String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();;
		//BaseClassRough xp = new BaseClassRough();
		//xp.clickbyxpath("click_xpath");
	}
	
public void sendbyxpath(String xpath, String value) {
		
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		//BaseClassRough xp = new BaseClassRough();
		//xp.sendbyxpath("send_xpath", "value");
	}
	

public  boolean isElementPresent(WebDriver driver,By by)  
 {  
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
    try  
    {  
       driver.findElement(by);  
       return true;  
    }  
    
    catch(Exception e)  
    
    {  
    	
       return false;  
    }  
    
    finally  
    {  
    	
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
     }  
 }  

	

	
	public void Close() {

		driver.quit();
	}

}

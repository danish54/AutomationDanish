package Rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassRough {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	public void Setup() throws IOException, InterruptedException {

		// loading config properties
		fis = new FileInputStream(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\Properties\\config.properties");
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\Properties\\OR.properties");
		OR.load(fis);
		// instentiating browser

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");

		// launching browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("baseurl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	public void Close() {

		driver.quit();
	}

}

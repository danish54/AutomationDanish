package Rough;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.Test;

public class operabroww {
	public static WebDriver driver;
	
	@Test
	public void openbrow() {
		
		
		WebDriver driver;
		System.setProperty("webdriver.opera.driver", "C:\\Users\\Danish\\AppData\\Local\\Programs\\Opera\\63.0.3368.94\\operadriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.setBinary("C:\\Users\\Danish\\AppData\\Local\\Programs\\Opera\\63.0.3368.94\\opera.exe");
	    driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.get("https://stackoverflow.com/questions/42696777/opera-webdriver-wont-launch-opera-selenium-3-1-0");

	}

}

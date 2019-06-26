package crytobulls;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Locators {
	
	public static void main (String [] args){	
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cryptobulls.exchange");
		List <WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: "+list.size());
		for(int i = 0; i < list.size(); i++){
		System.out.println(list.get(i).getText());
		
		//locating presence of a element
		WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//*[@id=\"recaptcha-anchor\"]/div[5]")));
		 
		 Assert.assertEquals("https://www.cryptobulls.exchange", driver.getCurrentUrl());
		}
	}

}

package Rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseRough extends BaseClassRough {

	BaseClassRough base = new BaseClassRough();

	@Test
	public void login() throws IOException, InterruptedException {
		base.Setup();

		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		driver.findElement(By.xpath(OR.getProperty("login_button_xpath"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		
		Assert.assertEquals(URL,"https://www.cryptobulls.exchange/authentication");
		 
		System.out.println("Login Successful!");

		base.Close();

	}

	
		
	}



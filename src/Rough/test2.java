package Rough;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test2 extends BaseClassRough {

	BaseClassRough base = new BaseClassRough();
	
	
@BeforeTest
	public void mainnn() throws InterruptedException, AWTException, IOException {
	
	
		base.Setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		driver.findElement(By.id("identifierId")).sendKeys("danish.a@troology.com");

		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("danish14ali");
		Thread.sleep(1000);
		
}
		
		@Test
		public void mavvinnn() throws InterruptedException, AWTException
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//div[@id='passwordNext']//span[@class='CwaK9']")).click();
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//textarea[@id=':ru']")).sendKeys("danish.a@troology.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Leave");
		Thread.sleep(5000);

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(3000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
	}
		

@AfterTest
public void closeapp() {

	base.Close();

}
}

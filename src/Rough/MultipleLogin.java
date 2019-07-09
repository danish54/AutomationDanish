package Rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleLogin extends BaseClassRough { BaseClassRough base = new BaseClassRough();

	

@DataProvider(name = "wordpress")

	public Object[][] dataprovierEX()

    {

         Object [][] data=new  Object[3][2];

         data [0][0]="admin";

         data [0][1]="admin123";

         data [1][0]="admin";

         data [1][1]="admin123";

         data [2][0]="admin";

         data [2][1]="admin123";

         return data;

    
	}

	@Test(dataProvider = "wordpress")

	public void DataDrivenFrameEx(String username,String pwd) throws InterruptedException, IOException

	{
      base.Setup();
      driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
      driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

     driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);

     driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pwd);

     driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

     String s= driver.getTitle();

      System.out.println(s);

     Thread.sleep(5000);
		
	}

	@AfterMethod

	public void closeapp()

	{

		driver.close();

	}

}

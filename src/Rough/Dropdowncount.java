package Rough;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdowncount extends BaseClassRough {
	
	BaseClassRough base = new BaseClassRough();
      
	@BeforeTest
	public void loginsetup() throws IOException, InterruptedException {

		base.Setup();

	}

	@Test
	public void operation() throws IOException, InterruptedException {

		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com");

		
		
		List<WebElement> elements=driver.findElements(By.tagName("select"));
		
		System.out.println("No of dropdown="+elements.size());
		
		for(int i=0;i<elements.size(); i++)
		{
			
			if(elements.get(i).isDisplayed())
			{    int count=0;
				     ++count;
				  String ss=elements.get(i).getAttribute("name");
				  System.out.println(ss);	
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir") + "\\src\\excel\\visblelinkURL1.xlsx");
				XSSFWorkbook wb=new XSSFWorkbook(fs);
				
				 Sheet s=wb.getSheet("Sheet1");
				
				 Row r=s.createRow(count);
				 
				 r.createCell(0).setCellValue(ss);
				  
				 FileOutputStream outputStream = new FileOutputStream(
							System.getProperty("user.dir") + "\\src\\excel\\visblelinkURL1.xlsx");
					wb.write(outputStream);

					wb.close();
				
			}
			
			
			
			
		}
		
		
		
		
		
			}
		
	

	@AfterTest
	public void closeapp() {

		base.Close();

	}
}

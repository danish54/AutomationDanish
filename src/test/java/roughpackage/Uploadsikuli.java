package roughpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Uploadsikuli {
	
	
	@Test
	public void uploadfile() throws FindFailed {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");
        String filepath = "E:\\eclipse-jee-2018-12-R-win32-x86_64\\eclipse\\workspace\\DanishMaven\\sikuli\\";
        String inputFilePath = "E:\\eclipse-jee-2018-12-R-win32-x86_64\\eclipse\\workspace\\DanishMaven\\excel\\";
        
        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "fileinput_img1.PNG");
        Pattern openButton = new Pattern(filepath + "open_img2.PNG");
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/image_upload/index.php");

        // Click on Browse button and handle windows pop up using Sikuli
        driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "logindatasheet.xlsx");
        s.click(openButton);

        // Close the browser
        driver.close();

    }



}

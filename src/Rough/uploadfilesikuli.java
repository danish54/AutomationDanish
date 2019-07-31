package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadfilesikuli {

	@Test
    public  void uploadfilexls() throws FindFailed {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");
        String filepath = "E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\";
        String inputFilePath = "D:\\Guru99Demo\\Files\\";
        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "fileinput_img1.PNG");
        Pattern openButton = new Pattern(filepath + "open_img2.PNG");
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
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
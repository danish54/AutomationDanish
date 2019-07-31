package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

import Rough.BaseClassRough;

public class TestUtil extends BaseClassRough 
{
	
	public static void capturescreenshot() throws IOException{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File ssFile = ((TakesScreenshot) (driver)).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileUtils.copyFile(ssFile, new File(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\" + sdf.format(d) + ".jpg"));
		
	}

}

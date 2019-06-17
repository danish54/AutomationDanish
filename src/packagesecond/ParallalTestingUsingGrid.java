package packagesecond;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallalTestingUsingGrid 
{

	WebDriver driver;
    String baseURL, nodeURL,nodeURLs;
    @Parameters("browser")
    @Test
    public void LaunchBrowser(String browser) throws MalformedURLException 
     { 
    	 baseURL = "http://demo.guru99.com/test/guru99home/";
         nodeURL = "http://192.168.1.4:4444/wd/hub";
         nodeURLs ="http://192.168.1.15:4444/wd/hub";
         if (browser.equalsIgnoreCase("firefox")) {
         DesiredCapabilities capability = DesiredCapabilities.firefox();
         capability.setBrowserName("firefox");

        //capability.setPlatform(Platform.WIN10);
         driver = new RemoteWebDriver(new URL(nodeURL), capability);
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         driver.navigate().to(baseURL);
         driver.manage().window().maximize();
            }
    else if(browser.equalsIgnoreCase("chrome"))
    {
    	DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
                 
       //capability.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }
         }
    @AfterTest
    public void afterTest()
    {
      //  driver.quit();
     
    }
}
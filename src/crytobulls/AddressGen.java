package crytobulls;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddressGen {
	
	public static WebDriver driver;

	@Test (priority=1)
	public void openbrowser() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Danish\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}

	@Test (priority=2)
	public void login() {
	String username = "daya.s@troology.com", password = "Dayatroology@123";	

	driver.get("https://www.cryptobulls.exchange/login");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"identity\"]")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
	driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/form/div[9]/div/button")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	   @Test (priority=3)
	public void deposit() {
	driver.get("https://www.cryptobulls.exchange/deposit/btc");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement coinlist = driver.findElement(By.xpath("//*[@id=\"btc_pairs_datatable1\"]"));
	List<WebElement> coinname = coinlist.findElements(By.tagName("a"));

	System.out.println(coinname.size());//60
	for(int i=0;i<coinname.size();i++){

	System.out.println(coinname.get(i).getText()); //BITCOIN
	JavascriptExecutor je = (JavascriptExecutor) driver;
	je.executeScript("arguments[0].scrollIntoView(true);",coinlist);

	coinname.get(i).click();
	coinlist = driver.findElement(By.xpath("//*[@id=\"btc_pairs_datatable1\"]"));
	coinname = coinlist.findElements(By.tagName("a"));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	}
	

}

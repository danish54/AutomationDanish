package Rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class screenshot extends BaseClassRough {
	BaseClassRough base = new BaseClassRough();

	@BeforeTest
	public void openapp() throws IOException, InterruptedException {
		base.login();

	}

	@Test
	public void printscreen() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/directory/viewDirectory/reset/1");
		base.captureSnapShot();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		base.captureSnapShot();
	}
	@AfterTest
	public void closeapp() {

		base.Close();

	}
}

package luxeregister;

import org.testng.annotations.Test;

public class login extends baseclassluxe {
	
	baseclassluxe base = new baseclassluxe();

	
	@Test
	public void login1() {
		
		base.login();
		System.out.println(driver.getTitle());
		
	}
	
	
}

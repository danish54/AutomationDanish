package Rough;

import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class sikulidemoo extends BaseClassRough {

	BaseClassRough base = new BaseClassRough();

	@Test
	public void openbrowser() throws IOException, InterruptedException, FindFailed {
		base.Setup();
		BaseClassRough.driver.get("https://www.cryptobulls.exchange/login");
		Screen s = new Screen();
		Pattern exchng = new Pattern("C:\\Users\\Danish\\Documents\\CR_Exchange.PNG");
		s.wait(exchng, 1000);
		s.click();
	}
}

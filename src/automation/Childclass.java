package automation;

import org.testng.annotations.Test;

public class Childclass extends chromebrowser
{
	chromebrowser log=new chromebrowser();
	@Test
	public void operation()
	{
            log.openbrowser();
	       log.closebrowser();
		
	
	}
	
	                       

}

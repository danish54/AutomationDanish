package Rough;

import org.testng.annotations.Test;

import Utility.Xls_Reader;

public class Dataproviderclass {
	
	Xls_Reader reader;

@Test	
public void getData() {
		
		reader = new Xls_Reader("E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\logindatasheet.xlsx");
	
		//get row count in sheet
		int rowcount =reader.getRowCount("Newmultiplelogin");
		System.out.println("Row Count is "+rowcount);
		int colcount =reader.getColumnCount("Newmultiplelogin");
		System.out.println("Column Count is "+colcount);
		//object array
		Object[][] data = new Object[rowcount - 1][colcount];
		
		for (int rownum = 2; rownum <= rowcount ; rownum++) {
			
			data[rownum-2][0] = reader.getCellData("Newmultiplelogin", "username", rownum);
			System.out.println(data[rownum-2][0]);

			data[rownum-2][1] = reader.getCellData("Newmultiplelogin", "password", rownum);
			System.out.println(data[rownum-2][1]);
			
		}
	}
}

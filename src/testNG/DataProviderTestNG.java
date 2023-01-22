package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {
	
	
	@Test(dataProvider="getData")
	public void test1(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];
		
		// 1st set username and password
		data[0][0] = "1st username";
		data[0][1] = "1st password";
		
		// 1st set username and password
		data[1][0] = "2nd username";
		data[1][1] = "2nd password";
		
		// 1st set username and password
		data[2][0] = "3rd username";
		data[2][1] = "3rd password";
		
		return data;
	}

}

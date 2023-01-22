package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ploan {
	// @BeforeTest annotation scope is for test tag only
	// it will execute before all methods in corresponding test tag
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test code of Ploan");
	}

	// @AfterTest annotation scope is for test tag only
	// it will execute after all methods in corresponding test tag
	@AfterTest
	public void afterTest() {
		System.out.println("This is after test code of PLoan");
		System.out.println("");
	}
	
	

	@Parameters({"URL","API_key/username"})
	@Test(groups= {"Smoke"})
	public void pLoan(String url_name, String api_key) {
		System.out.println("personal loan");
		System.out.println(url_name);
		System.out.println(api_key);
	}

}

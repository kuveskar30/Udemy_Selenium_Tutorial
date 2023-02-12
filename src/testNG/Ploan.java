package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ploan {
	//@BeforeTest,@AfterTest,@BeforeSuite and @AfterSuite are related with xml
	
	// @BeforeTest annotation scope is for test tag only
	// it will execute only once before all Tests having @Test annotation
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test code of Ploan");
	}

	// @AfterTest annotation scope is for test tag only
	// it will execute only once after completing all tests having @Test annotation
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
	
	@Test
	public void demo1() {
		System.out.println("demo1");
	}
	
	@Test
	public void demo2() {
		System.out.println("demo2 ploan test");
	}

}

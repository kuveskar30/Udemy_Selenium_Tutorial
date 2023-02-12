package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CarLoan {
	//every method in testNG is treated as a test case
	
	//@BeforeTest,@AfterTest,@BeforeSuite and @AfterSuite are related with xml
	
	//it executed before all test cases of all test tags
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite code");
		System.out.println("");
	}
	////it executed after all test cases of all test tags
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite code");
		System.out.println("");
	}
	
	//@BeforeTest annotation scope is for test tag(folder) only
	//it will execute before all methods in corresponding test tag
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test code of CarLoan");
	}
	
	//@AfterTest annotation scope is for test tag only
	//it will execute after all methods in corresponding test tag
	@AfterTest
	public void afterTest() {
		System.out.println("This is after test code of CarLoan");
		System.out.println("");
	}
	
	@Test(groups= {"Smoke"})
	public void webCarLoan() {
		System.out.println("webCarLoan loan");
	}
	
	//enabled=false it disables test, i.e. test will not be executed
	@Test(enabled=false)
	public void mobileCarLoan1() {
		System.out.println("mobileCarLoan1 loan");
	}
	@Test(dependsOnMethods={"mobileCarLoan2"})
	public void booksLoan() {
		System.out.println("books loan");
	}
	//timeOut will wait for 400 miliseconds brfore test fails
	@Test(timeOut=4000)
	public void mobileCarLoan2() {
		System.out.println("mobileCarLoan2 loan");
	}
	
//	@Parameters({"URL"})
//	@Test
//	public void mobileCarLoan3(String url_name) {
//		System.out.println("mobileCarLoan3 loan");
//		System.out.println(url_name);
//	}
	
	@Test
	public void apiCarLoan() {
		System.out.println("apiCarLoan loan");
	}
	
	
	
}

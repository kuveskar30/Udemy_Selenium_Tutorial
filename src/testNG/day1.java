package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {
	// you need to have @Test annotation followed by method
	// you can define multiple test cases

	// @BeforeMethod and @AfterMethod are limited to class
	// @BeforeClass,@AfterClass
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("before class method");
	}

	// it gets executed before every method present in a class
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is before method code");
	}

	// it gets executed after every method present in a class
	@AfterMethod
	public void afterMethod() {
		System.out.println("this is after method code");
	}

	@Test(groups= {"Smoke"})
	public void demo() {
		System.out.println("demo test code");
	}
	
	@Test
	public void secondTest() {
		System.out.println("secodTest code");
	}
	
	@Test
	public void failTest() {
		System.out.println("failTest code");
		Assert.assertTrue(false);
	}
	

	


}

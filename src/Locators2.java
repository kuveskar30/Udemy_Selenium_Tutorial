import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		//1. chrome browser
//		System.setProperty("webdriver.chrome.driver",
//				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
//		WebDriver d1 = new ChromeDriver();

		//2.FireFox Browser
//		System.setProperty("webdriver.gecko.driver",
//				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_gecko_driver\\geckodriver.exe");
//		WebDriver d1 = new FirefoxDriver();
		
		//3.Edge Browser
		System.setProperty("webdriver.edge.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_edge_driver\\msedgedriver.exe");
		WebDriver d1 = new EdgeDriver();
		WebDriverWait w = new WebDriverWait(d1, Duration.ofSeconds(5));
		
		// it waits for object to show
		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String user_name = "jems";
		String password = Locators2.getPassword(d1, w);
		System.out.println(password);
		
		d1.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);
		d1.findElement(By.id("inputUsername")).sendKeys(user_name);
		
		Thread.sleep(1000);
		d1.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(1000);
		
		d1.findElement(By.className("signInBtn")).click();
		
//		System.out.println(d1.findElement(By.cssSelector(".overlay-panel.overlay-right p")).isDisplayed());
		//I did this for just understanding
		//System.out.println(d1.findElement(By.cssSelector("div[class='overlay-panel overlay-right'] p")).getText());

		//if we don't use Thread.sleep() selenium will try to find p tag just after clicking on sign in button
		//and this happens within miliseconds before loading logged page, already there are some p tags on login page
		//so selenium will consider those p tags as required tags and will go ahead
		//such problems will come in single page applications like angular where state of page changes but
		//URL dosen't change
//		Thread.sleep(2000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
		System.out.println(d1.findElement(By.tagName("p")).getText());
		
		//Testng assertion
		//validating expected login success message with actual using assertion
		Assert.assertEquals(d1.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(d1.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
		//validating expected user welcome success message with actual
		Assert.assertEquals(d1.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello " + user_name + ",");
		
		Thread.sleep(1000);
		//find based on text
		d1.findElement(By.xpath("//button[text()='Log Out']")).click();
		//using regular expression, this method only works in xpath and not in cssSelector
//		d1.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		Thread.sleep(15000);
		d1.quit();
	}
	
	public static String getPassword(WebDriver driver, WebDriverWait w) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//no need of below commented code as this code already present in main method
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Forgot your password?")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.reset-pwd-btn")));
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//extracting password from message
		String temp_password_msg = driver.findElement(By.className("infoMsg")).getText();
		String[] pass1 = temp_password_msg.split("'");
		String password = pass1[1];
		
		return password;
	}

}

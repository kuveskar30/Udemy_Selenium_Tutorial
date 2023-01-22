import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		// it waits for object to show
		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		d1.get("https://rahulshettyacademy.com/locatorspractice/");
		Thread.sleep(1000);
		d1.findElement(By.id("inputUsername")).sendKeys("rahul");
//		d1.findElement(By.xpath("//input[@type='text' and @id='inputUsername']")).sendKeys("rahul");
		Thread.sleep(1000);
		d1.findElement(By.name("inputPassword")).sendKeys("abcd");
		Thread.sleep(1000);
		d1.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		//if i run this line without implicitlyWait then element not found error will come
		System.out.println(d1.findElement(By.cssSelector("p.error")).getText());
		
		//after clicking on forgot password page will be in transition phase,
		//so we should use Thread.sleep() or explicitly wait for page to get stable,
		//otherwise Selenium will not found login button, and will click on wrong element 
		Thread.sleep(1000);
		//for using linkTest text should be in <a></a> tag
		d1.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		d1.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("jems");
		
		Thread.sleep(1000);
		d1.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("jems123@gmail.com");
		
		//if we don't have unique attribute then we use this type
		Thread.sleep(1000);//it is last preferred method
		d1.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		//if we don't have unique attribute then we use this type
		Thread.sleep(1000);
		d1.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("jems@gmail.com");
		//if no attribute present then use this method
		Thread.sleep(1000);
		d1.findElement(By.xpath("//form/input[3]")).sendKeys("9868598798");
		
		Thread.sleep(1000);
		d1.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		Thread.sleep(1000);
		System.out.println(d1.findElement(By.cssSelector("form p")).getText());
		 
		Thread.sleep(1000);//combination of generic xpath and parent to child tag traverse
		d1.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(1000);
		d1.findElement(By.cssSelector("input#inputUsername")).sendKeys("jems");
		
		Thread.sleep(1000);//regular expression, search by matching with partial text
		d1.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		Thread.sleep(1000);
		d1.findElement(By.id("chkboxOne")).click();
		
		Thread.sleep(1000);//xpath regular expressions
		d1.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(15000);
		d1.quit();
	}

}

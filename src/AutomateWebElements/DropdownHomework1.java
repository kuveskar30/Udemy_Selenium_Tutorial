package AutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DropdownHomework1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//select and deselect checkbox and validate
		Thread.sleep(1000);
		d1.findElement(By.xpath("//div[@id='checkbox-example'] //input[@value='option1']")).click();
		Assert.assertTrue(d1.findElement(By.xpath("//div[@id='checkbox-example'] //input[@value='option1']")).isSelected());
		Thread.sleep(1000);
		d1.findElement(By.xpath("//div[@id='checkbox-example'] //input[@value='option1']")).click();
		Assert.assertFalse(d1.findElement(By.xpath("//div[@id='checkbox-example'] //input[@value='option1']")).isSelected());
	
		//counting no of checkboxes
		
		int checkbox_count = d1.findElements(By.cssSelector("input[Type='checkbox']")).size();
		System.out.println(checkbox_count);
	}

}

package AutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		//dynamic dropdown
		//option comes in HTML only after clicking on dropdown
		//if search before clicking you won't find option in HTML
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		d1.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		d1.findElement(By.xpath("//a[@value='ATQ']")).click();
		Thread.sleep(1000);
//		d1.findElement(By.xpath("(//a[@value='BOM'])[2]")).click();
		
		//if you don't want to use index then below is alternate xpath method
		//parent child relationship in xpath
		d1.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BOM']")).click();
		
		Thread.sleep(1000);
		d1.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		Thread.sleep(10000);
		d1.quit();

	}

}

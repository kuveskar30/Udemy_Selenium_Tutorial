package AutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//checking element is selected or not
		Assert.assertFalse(d1.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(d1.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//clicking on checkbox, using regex cssSelector
		d1.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(d1.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(d1.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//counting total no of checkboxes
		int s1 = d1.findElements(By.xpath("//div[@id='discount-checkbox'] //input[@type='checkbox']")).size();
		System.out.println(s1);
		d1.findElement(By.id("divpaxinfo")).click();
		System.out.println(d1.findElement(By.id("divpaxinfo")).getText());

		Thread.sleep(2000);//synchronization issue
		//by default 1 Adult is selected
		//by clicking 2 times, 3 Adult will get selected
		for (int i = 1; i <= 2; i++) {
			d1.findElement(By.id("hrefIncAdt")).click();
		}

		d1.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(d1.findElement(By.id("divpaxinfo")).getText());

		Assert.assertEquals(d1.findElement(By.id("divpaxinfo")).getText(), "3 Adult");

		//checking return date disabled or enabled
		
		System.out.println(d1.findElement(By.id("Div1")).getAttribute("style"));
		d1.findElement(By.id("ctl00_mainContent_view_date2")).click();
		//below method is not useful in all website
//		d1.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
		
		System.out.println(d1.findElement(By.id("Div1")).getAttribute("style"));
		
		if(d1.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("date is enabled");
			Assert.assertTrue(false);
		}else{
			System.out.println("ok date is disabled");
			Assert.assertTrue(true);
		}
		
		Thread.sleep(10000);
		d1.quit();

	}

}

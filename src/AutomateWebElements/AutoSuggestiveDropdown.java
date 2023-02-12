package AutomateWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		d1.findElement(By.id("autosuggest")).click();
		Thread.sleep(2000);
		d1.findElement(By.id("autosuggest")).sendKeys("ind");
		
		Thread.sleep(2000);
		//note that, here findElements is plural
		List<WebElement> list_options = d1.findElements(By.cssSelector("li.ui-menu-item a"));
		//for every list_options store each option in list_option 
		//and it's return type is WebElement
		for(WebElement list_option:list_options) {
			
			if(list_option.getText().equalsIgnoreCase("India")) {
				list_option.click();
				break;
			}
		}
		
		Thread.sleep(10000);
		d1.quit();
	
	}

}

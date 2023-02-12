package section12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Asiignment8 {

	public static void main(String[] args) throws InterruptedException {
		// 1. chrome browser launching
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(d1, Duration.ofSeconds(10));

		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String desired_country_name = "India";
		d1.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys("in");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-1 .ui-menu-item")));
		List<WebElement> countries = d1.findElements(By.cssSelector("#ui-id-1 .ui-menu-item"));
		
		for(WebElement country:countries) {
			String selected_country_name = country.getText();
			if(selected_country_name.equalsIgnoreCase(desired_country_name)) {
				country.click();
				break;
			}
			
		}
		
		Thread.sleep(15000);
		d1.quit();
		

	}

}

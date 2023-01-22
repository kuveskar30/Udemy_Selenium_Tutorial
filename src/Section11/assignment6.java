package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment6 {

	public static void main(String[] args) throws InterruptedException {
		
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String id_of_required_checkbox = "checkBoxOption2";
		WebElement selected_checkbox = d1.findElement(By.id(id_of_required_checkbox));
		
		selected_checkbox.click();
		String value_of_selected_checkbox = selected_checkbox.getAttribute("value");
		
		WebElement options = d1.findElement(By.id("dropdown-class-example"));
		Select s = new Select(options);
		s.selectByValue(value_of_selected_checkbox);
		
		d1.findElement(By.id("name")).sendKeys(value_of_selected_checkbox);
		d1.findElement(By.id("alertbtn")).click();
		
		String alert_msg = d1.switchTo().alert().getText();
		System.out.println(alert_msg);
		
		if(alert_msg.contains(value_of_selected_checkbox)) {
			System.out.println("alert task successful");
		}else {
			System.out.println("alert task failed");
		}
		
		
		
		Thread.sleep(15000);
		d1.quit();
		
		

	}

}

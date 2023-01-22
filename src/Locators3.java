import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		
		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		//find by following-sibling::tagName[tagNumber]
		System.out.println(d1.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//child to parent traverse
		System.out.println(d1.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
	}

}
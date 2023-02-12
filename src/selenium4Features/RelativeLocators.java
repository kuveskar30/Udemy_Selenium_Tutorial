package selenium4Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		d1.get("https://rahulshettyacademy.com/angularpractice/");
		
		//relative locator work in selenium 4+ version
		//below mentioned package needs to be added manually to work with relative locators
		//import static org.openqa.selenium.support.locators.RelativeLocator.*;
		
		//it doesen't work with flex components, it will skip flex html component
		//with(By.tagName("tagName")).above(WebElement))
		WebElement name_editbox = d1.findElement(By.cssSelector("input[name='email']"));
		System.out.println(d1.findElement(with(By.tagName("label")).above(name_editbox)).getText());
		//it doesen't work with flex components, it will skip flex html component
		//it will skip date input component as it is a flex
		WebElement dob_label = d1.findElement(By.cssSelector("label[for='dateofBirth']"));
		d1.findElement(with(By.tagName("input")).below(dob_label)).click();
		
		WebElement checkbox_label = d1.findElement(By.cssSelector("label[for='exampleCheck1']"));
		d1.findElement(with(By.tagName("input")).toLeftOf(checkbox_label)).click();
		
		WebElement radio1 = d1.findElement(By.id("inlineRadio1"));
		System.out.println(d1.findElement(with(By.tagName("label")).toRightOf(radio1)).getText());
		
	}

}

package HandlingMouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class framesHandeling {

	public static void main(String[] args) {

		// launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://jqueryui.com/droppable/");
		//switch to iframe
		//without switching to iframe we can't access elements of iframe
		d1.switchTo().frame(d1.findElement(By.cssSelector("iframe.demo-frame")));
		
		System.out.println(d1.findElement(By.id("draggable")).getText());
		
		Actions a = new Actions(d1);
		
		WebElement source = d1.findElement(By.id("draggable"));
		WebElement target = d1.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		//switch to parent frame from iframe
		//without switching to parent frame from iframe, we won't be able to access elements of parent frame
		d1.switchTo().defaultContent();

	}

}

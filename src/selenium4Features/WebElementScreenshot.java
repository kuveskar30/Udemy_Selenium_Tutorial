package selenium4Features;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		d1.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name_editbox = d1.findElement(By.cssSelector("input[name='name']"));
		name_editbox.sendKeys("lorem ipsum");
		
		File file = name_editbox.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("E:\\pratik30\\Software testing\\screenshots\\element_screenshot.png"));
	}

}

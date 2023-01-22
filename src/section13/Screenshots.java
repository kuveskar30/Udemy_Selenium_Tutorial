package section13;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException, InterruptedException {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(2000);
		File src = ((TakesScreenshot) d1).getScreenshotAs(OutputType.FILE);
		//common.io jar is required for using FileUtils I have taken common.io in pom.xml file from maven website 
		FileUtils.copyFile(src, new File("E:\\pratik30\\Software testing\\screenshots\\screenshot.png"));

	}

}

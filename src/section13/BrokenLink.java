package section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = d1.findElements(By.cssSelector("#gf-BIG li.gf-li>a"));
		//in hard assertion script stops after test failure
		//but in soft assert script continue after failure also
		SoftAssert a = new SoftAssert();
		
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);

			//for assertTrue to fail it should get false
			a.assertTrue(responseCode<400, "The link with text '" + link.getText() + "' and response code =" + responseCode + " is not working");
			
//			if(responseCode>400) {
//				System.out.println("The link with text '" + link.getText() + "' and response code =" + responseCode + " is not working");
//				Assert.assertTrue(false);
//			}
		}
		//it will show failed assertions and will stop the script
		a.assertAll();
		System.out.println("******");
		
		
		
		
		
		
	}

}

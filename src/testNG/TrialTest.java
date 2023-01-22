package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TrialTest {
	
	public static void main(String[] args) {
		// launching browser
		WebDriverManager.chromedriver().setup();
		WebDriver d1 = new ChromeDriver();
	}
}

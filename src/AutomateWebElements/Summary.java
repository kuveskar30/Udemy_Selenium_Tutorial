package AutomateWebElements;

public class Summary {

	//1. dropdowns
	//static, autosuggestive, dynamic, custom
	
	//a. static :
	//select and option tags
	// Select dropdown = new Select(WebElement);
	//selectByValue,selectByInex,selectByVisibleText
	//getFirstSelectedOption.getText
	//deselectAll--work when multiple selection enabled
	
	//b. autosuggestive
	//we write in searchbox and result list dynamically displayed
	//store that result in list and compare with required result and select
	
	//findElement(By.) --WebElement or NoSuchElementException
	//findElements(By.) -- list or emptyList
	
	//checkbox-- isSelected()
	//dateField -- isEbnabled() (not work consistently rahul shetty told)
	//compare by checking opacity style change
	
	//Assert.true/false/assertEquals(actual,expected)
	
	
	//2. Javascript alerts
	//d1.switchTo().alert().accept();
	//d1.switchTo().alert().dismiss();
	//d1.switchTo().alert().getText();
	
	//d1.switchTo().window(window_handle);
	//d1.switchTo().frame(WebElement);
	
}

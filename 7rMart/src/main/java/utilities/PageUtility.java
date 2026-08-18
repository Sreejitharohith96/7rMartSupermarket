package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	WebDriver driver;	

public void dropdownVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);	

	}
	
	public void dropdownIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void dropdownSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	public void dragAndDropAction(WebDriver driver, WebElement source, WebElement target)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{	
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		
	}
	
	public void click(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.click(element).perform();

	}
	
	
}

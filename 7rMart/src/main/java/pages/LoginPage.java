package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']") WebElement usernamefield; 
	@FindBy(xpath="//input[@name='password']") WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement signinButton;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboad;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement errormsg;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	public LoginPage enterUsername(String username) {
		usernamefield.sendKeys(username);
		return this; //not changing to any other page. so return this
		
	}
	
	public LoginPage enterPassword(String password) {
		passwordfield.sendKeys(password);
		return this;
		
	}
	
	public HomePage signin() {
		signinButton.click();
		return new HomePage(driver);
	}
	
	public boolean dashboardIsDisplayed() {
		
		return dashboad.isDisplayed();
	
	}
	
	public String errorIsDisplayed() {
		 String errormessage = errormsg.getText();
		 System.out.println(errormessage);
		return errormessage;
		
	}

}

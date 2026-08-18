package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminbutton;
	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logoutoption;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement signinbtn;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickadminButton() {
		adminbutton.click();
		
	}
	
	public void clicklogout() {
		logoutoption.click();
		
	}
	
	public boolean successfulLogout() {
		return signinbtn.isDisplayed();
	}

}

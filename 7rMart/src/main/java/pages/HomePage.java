package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminbutton;
	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logoutoption;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement signinbtn;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") 
	WebElement managenews;
	
	@FindBy(xpath="//a[@class='small-box-footer' and  @href=\"https://groceryapp.uniqassosiates.com/admin/list-location\"]") 
	WebElement managelocation;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage clickadminButton() {
		adminbutton.click();
		return this;
		
	}
	
	public LoginPage clicklogout() {
		logoutoption.click();
		return new LoginPage(driver);
		
	}
	
	public boolean successfulLogout() {
		return signinbtn.isDisplayed();
	}
	
	public ManageNewsPage clickManageNews() {
		PageUtility pageutil = new PageUtility();
		pageutil.click(driver, managenews);
		//managenews.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageLocationPage clickmanageLocation() {
		managelocation.click();
		return new ManageLocationPage(driver);
	}

}

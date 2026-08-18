package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	
	@FindBy (xpath="//a[@class=\"small-box-footer\" and @href=\"https://groceryapp.uniqassosiates.com/admin/list-admin\"]") 
	WebElement adminuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='username']") WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']") WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']") WebElement usertype;
	@FindBy(xpath="//button[@name='Create']") WebElement savebtn;
	@FindBy(xpath="//h3[@class='card-title']") WebElement adminuserinfo;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successmsg;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement errormsg;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	public void clickAdminUsers()
	{
		adminuser.click();
		
	}
	
	public boolean isAdminPageSubtitleDisplayed() {
		return adminuserinfo.isDisplayed();
	}
	

	public boolean isNewButtonEnabled() {
		return newbutton.isEnabled();
	}
	
	public void clickNewOption() {
		newbutton.click();
	}
	
	public void createnewAdminUser(String username,String password, String usertypedropdown) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		
		PageUtility pageutil = new PageUtility();
		pageutil.dropdownVisibleText(usertype, usertypedropdown);
		
		savebtn.click();		
	}
	
	public boolean getSuccssesAlertText() {
		return successmsg.getText().contains("Success");
			
	}
	


}

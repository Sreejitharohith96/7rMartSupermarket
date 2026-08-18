package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") 
	WebElement deliveryboy;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")WebElement newbtn;
	@FindBy(xpath="//input[@name='name']")WebElement namefield;
	@FindBy(xpath="//input[@name='email']")WebElement email;
	@FindBy(xpath="//input[@name='phone']")WebElement phone;
	@FindBy(xpath="//textarea[@name='address']")WebElement address;
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//button[@name='create']")WebElement savebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successmsg;
	WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	public void clickManageDelivery() {
		deliveryboy.click();
	}
	
	public void clickNewButton() {
		newbtn.click();
	}
	
	public void enterName(String name) {
		namefield.sendKeys(name);
	}
	
	public void enterEmailAddress(String emailaddress) {
		email.sendKeys(emailaddress);
	}
	
	public void enterPhoneNo(int phoneno) {
		phone.sendKeys(String.valueOf(phoneno));
	}
	
	public void enteraddress(String addressinfo) {
		address.sendKeys(addressinfo);
	}
	
	public void enterusername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void enterpassword(String password) {
		passwordfield.sendKeys(password);
	}
	
	public void clicksave() {
		PageUtility pageutil = new PageUtility();
		pageutil.clickUsingJavaScriptExecutor(driver, savebtn);
	}
	
	public boolean getSuccssesAlertText() {
		return successmsg.getText().contains("Success");
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	
	WebDriver driver;
	
//	@FindBy(xpath="//a[@class='small-box-footer' and  @href=\"https://groceryapp.uniqassosiates.com/admin/list-location\"]") 
//	WebElement managelocation;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbtn;
	@FindBy(xpath="//select[@class='form-control selectpicker' and @id='country_id']") WebElement country;
	@FindBy(xpath="//select[@id='st_id']") WebElement state;
	@FindBy(xpath="//input[@id='location']") WebElement location;
	@FindBy(xpath="//input[@id='delivery']") WebElement delivery_charge;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement savebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successmsg;
	
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
//	public void clickmanageLocation() {
//		managelocation.click();
//	}
	
	public ManageLocationPage clickNewButton() {
		newbtn.click();
		return this;
	}
	
	public ManageLocationPage selectCountry() {
		PageUtility pageutility = new PageUtility();
		pageutility.dropdownVisibleText(country, "United Kingdom");;
		return this;
	}
	
	public ManageLocationPage selectState() {
		PageUtility pageutility = new PageUtility();
		pageutility.dropdownVisibleText(state, "London");
		return this;
	}
	
	public ManageLocationPage selectLocation(String locationname) {
		location.sendKeys(locationname);
		return this;
	}
	
	public ManageLocationPage enterdeliverycharge(int del_charge) {
		delivery_charge.sendKeys(String.valueOf(del_charge));
		//return del_charge;
		return this;
	}
	
	public ManageLocationPage saveaction() {
		savebtn.click();
		return this;
	}
	
	public boolean successmsgisDisplayed() {
		return successmsg.isDisplayed();
	}
	

}

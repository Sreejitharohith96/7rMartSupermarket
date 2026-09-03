package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {
	WebDriver driver;
	
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") 
//	WebElement managenews;
	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-danger\"]") WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']") WebElement newstextfield;
	@FindBy(xpath="//button[@name='create']") WebElement savebtn;
	@FindBy(xpath="//div[contains(@class,'alert-success') and contains(.,'News Created Successfully')]") WebElement successmsg;
	@FindBy(xpath="//h1[@class='m-0 text-dark']") WebElement heading;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
//	public void clickManageNews() {
//		PageUtility pageutil = new PageUtility();
//		pageutil.click(driver, managenews);
//		//managenews.click();
//	}
	
	public boolean isPageTitleDisplayed() {
		return heading.isDisplayed();
	}
	
	public ManageNewsPage clickNewButton() {
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String news) {
		newstextfield.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage savenews() {
		savebtn.click();
		return this;
	}
	
	public boolean successmsgvalidation() {
		return successmsg.isDisplayed();
	}

}

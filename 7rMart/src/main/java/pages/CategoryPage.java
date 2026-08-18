package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.ConstantClass;
import utilities.FileuploadUtility;
import utilities.PageUtility;

public class CategoryPage {
	
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement category;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbtn;
	@FindBy(xpath="//input[@id='category']") WebElement categoryfield;
	@FindBy(xpath="//div[@class='ms-selectable']") WebElement selectgroupfrom;
	@FindBy(xpath="//div[@class='ms-selection']") WebElement selectgroupto;
	@FindBy(xpath="//input[@id='main_img']") WebElement choosefile;
	@FindBy(xpath="//input[@value='yes' and @name='top_menu']") WebElement showonTopYes;
	@FindBy(xpath="//input[@value='no' and @name='top_menu']") WebElement showonTopNo;
	@FindBy(xpath="//input[@value='yes' and @name='show_home']") WebElement showonleftYes;
	@FindBy(xpath="//input[@value='no' and @name='show_home']") WebElement showonleftNo;
	@FindBy(xpath="//button[@name='create']") WebElement savebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successmsg;
		
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	
	public void clickcategory() {
		category.click();
	}
	
	public void clicknewbutton() {
		newbtn.click();
		
	}
	
	public void entercategory(String categorydetails) {
		categoryfield.sendKeys(categorydetails);
	}
	
	public void selectgroup(String groupName) {
//		for (WebElement group : selectgroupfrom) {
//			if (group.getText().equalsIgnoreCase(groupName)) {
//				group.click();
//				break;
//			}
		
		selectgroupfrom.click();
			
						
	}
	public void verifyGroupselected() {		
		selectgroupto.equals(selectgroupfrom);		
	}
	
	public void choosephoto() {
		FileuploadUtility fileuploadutility = new FileuploadUtility();
		fileuploadutility.fileuploadUsingSendKeys(choosefile, ConstantClass.IMAGE);
		
	}
	
	public void selectshowOnTopYesOption() {
		pageutility.click(driver, showonTopYes);
		//showonTopYes.click();
	}
	
	public void selectshowOnTopNoOption() {
		pageutility.click(driver, showonTopNo);
	}
	
	public void selectshowOnLeftYesOption() {
		pageutility.click(driver, showonleftYes);
	}
	public void selectshowOnLeftNoOption() {
		pageutility.click(driver, showonleftNo);
	}
	public void clickSave() {
		pageutility.clickUsingJavaScriptExecutor(driver, savebtn);
	}
	public boolean getSuccssesAlertText() {
		return successmsg.getText().contains("Success");
	}
}

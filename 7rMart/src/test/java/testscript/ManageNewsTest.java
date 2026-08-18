package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass{
	@Test
	public void verifyUserAbletoAddNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.signin();
	
	ManageNewsPage managenews = new ManageNewsPage(driver);
	managenews.clickManageNews();
	
	managenews.clickNewButton();
	
	String news = ExcelUtility.getStringData(1, 0, "newspage");
	managenews.enterNews(news);
	
	managenews.savenews();
	AssertJUnit.assertTrue(managenews.successmsgvalidation());
	

}
}
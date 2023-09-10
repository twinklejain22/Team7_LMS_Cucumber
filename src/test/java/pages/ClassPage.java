package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class ClassPage {
	
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//a[text()='classPage']") WebElement classPage;//Link List
	
	public ClassPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}
	

	public void GoToClassPage() 
	{
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User navigates to LMS  Page");
	}
	
	public void VerifyClassPage()
	{
		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getClassPageTitle());
		Log.info("Verified that user is on LMS Class Page");
	}
	
//	public void VerifyClassBtn()
//	{
//		Assert.assertTrue(btnClass.isDisplayed());
//		Log.info("Verified that Login button is displayed");
//	}
//	
//	public void ClickOnLoginBtn()
//	{
//		actionHelper.Click(btnClass);
//		Log.info("User clicks on Login button");
//	}

}

	


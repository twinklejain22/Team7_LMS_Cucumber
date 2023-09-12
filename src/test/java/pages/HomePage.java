package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class HomePage {
	
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//a[text()='Login']") WebElement btnLogin;
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}
	
	public void GoToHomePage() 
	{
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User navigates to LMS Home Page");
	}
	
	public void VerifyHomePage()
	{
		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getHomePageTitle());
		Log.info("Verified that user is on LMS Home Page");
	}
	
	public void VerifyLoginBtn()
	{
		Assert.assertTrue(btnLogin.isDisplayed());
		Log.info("Verified that Login button is displayed");
	}
	
	public void ClickOnLoginBtn()
	{
		actionHelper.Click(btnLogin);
		Log.info("User clicks on Login button");
	}

}

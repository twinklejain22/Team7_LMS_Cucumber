package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class DashboardPage {
	
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//a[text()='User']") WebElement linkUser;
	@FindBy(xpath = "//a[text()='Program']") WebElement linkProgram;
	@FindBy(xpath = "//h1[contains(text(),'User')]") WebElement txtUserHeader;
	@FindBy(xpath = "//div[contains(@class, 'pagination')]") WebElement pagination;
	
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void VerifyDashboardPage()
	{
		Assert.assertTrue(actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getDashboardPageTitle()));
		Log.info("Verified that user is on LMS Dashboard Page");
	}
	
	public void GoToPage(String page)
	{
		if(page.equals("Program"))
			linkProgram.click();
		else if(page.equals("User"))
			linkUser.click();
			
		Log.info("User clicks on " + page + " on LMS Dashboard Page");
	}
	
	public void ValidatePageURL(String urlText)
	{
		Assert.assertTrue(actionHelper.VerifyURL(urlText));
		Log.info("Verified Page URL contains " + urlText);
	}
	
	public void VerifyPageHeader(String expectedHeader)
	{
		Assert.assertTrue(actionHelper.IsHeaderValid(txtUserHeader, expectedHeader));
		Log.info("Verified header text for LMS " + expectedHeader + " Page");
	}

}

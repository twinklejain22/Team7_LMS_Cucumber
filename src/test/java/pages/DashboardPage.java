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
	
	@FindBy(xpath = "//h1[text()='Dashboard']") WebElement txtHeader;
	
	
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

}

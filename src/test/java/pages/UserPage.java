package pages;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class UserPage {

	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//table") WebElement tableUser;
	@FindBy(xpath = "//button[text()='Delete'][0]") WebElement btnMultipleDelete;
	@FindBy(xpath = "//button[text()='+ Add New User']") WebElement btnAddUser;
	@FindBy(xpath = "//button[text()='+ Assign Staff']") WebElement btnAssignStaff;
	@FindBy(xpath = "//input[id='Search']") WebElement txtSearch;
	
	public UserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}
	
	public void ValidateTableHeaders()
	{
		String[] expectedHeaders = FileReaderManager.getInstance().getConfigReader().getUserTableExpectedHeaders().split(",");
		Assert.assertTrue(actionHelper.ValidateTableHeaders(tableUser, Arrays.asList(expectedHeaders)));
		Log.info("Verified user page table headers on User Page");
	}
	
	public void VerifyDeleteMutipleBtnDisabled()
	{
		Assert.assertFalse(btnMultipleDelete.isEnabled());
		Log.info("Verified Multiple delete button disabled on User Page");
	}
	
	public void VerifyDeleteButtonInEachRow()
	{
		Assert.assertTrue(actionHelper.IsDeleteButtonInTableRows(tableUser));
		Assert.assertTrue(actionHelper.IsDeleteButtonEnabledInTableRows(tableUser));
		Log.info("Verified delete button present and enabled in table on User Page");
	}
	
	public void VerifyEditButtonInEachRow()
	{
		Assert.assertTrue(actionHelper.IsEditButtonInTableRows(tableUser));
		Assert.assertTrue(actionHelper.IsEditButtonEnabledInTableRows(tableUser));
		Log.info("Verified edit button present and enabled in table on User Page");
	}
	
	public void VerifyCheckboxInEachRow()
	{
		Assert.assertTrue(actionHelper.IsCheckBoxInTableRows(tableUser));
		Log.info("Verified checkbox present and enabled in table on User Page");
	}
	
	public void VerifyAddUserBtnPresent()
	{
		Assert.assertTrue(btnAddUser.isDisplayed());
		Log.info("Verified Add new user button present on User Page");
	}
	
	public void VerifyAssignStaffBtnPresent()
	{
		Assert.assertTrue(btnAssignStaff.isDisplayed());
		Log.info("Verified Assign Staff button present on User Page");
	}
	
	public void VerifySearchTextboxPresent()
	{
		Assert.assertTrue(txtSearch.isDisplayed());
		Log.info("Verified search textbox present on User Page");
	}
	
	public void ClickAddUserBtnPresent()
	{
		actionHelper.Click(btnAddUser);
		Log.info("User click on Add new user button on User Page");
	}
}

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

public class AttendancePage 
{
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//table") WebElement tableAssignment;
	@FindBy(xpath = "//button[text()='Delete'][0]") WebElement btnMultipleDelete;
	@FindBy(xpath = "//button[text()='+ Add New User']") WebElement btnAddUser;
	@FindBy(xpath = "//button[text()='+ Assign Staff']") WebElement btnAssignStaff;
	@FindBy(xpath = "//input[id='Search']") WebElement txtSearch;
	
	public AttendancePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}
	
	public void ValidateTableHeaders()
	{
		String[] expectedHeaders = FileReaderManager.getInstance().getConfigReader().getAssignmentTableHeaders().split(",");
		Assert.assertTrue(actionHelper.ValidateTableHeaders(tableAssignment, Arrays.asList(expectedHeaders)));
		Log.info("Verified user page table headers on ManageAttendancePageVerification");
	}
	
	public void VerifyDeleteMutipleBtnDisabled()
	{
		Assert.assertFalse(btnMultipleDelete.isEnabled());
		Log.info("Verified Multiple delete button disabled on User Page");
	}
	
	public void VerifyDeleteButtonInEachRow()
	{
		Assert.assertTrue(actionHelper.IsDeleteButtonInTableRows(tableAssignment));
		Assert.assertTrue(actionHelper.IsDeleteButtonEnabledInTableRows(tableAssignment));
		Log.info("Verified delete button present and enabled in table on ManageAttendancePageVerification");
	}
	
	public void VerifyEditButtonInEachRow()
	{
		Assert.assertTrue(actionHelper.IsEditButtonInTableRows(tableAssignment));
		Assert.assertTrue(actionHelper.IsEditButtonEnabledInTableRows(tableAssignment));
		Log.info("Verified edit button present and enabled in table on ManageAttendancePageVerification");
	}
	
	public void VerifyCheckboxInEachRow()
	{
		Assert.assertTrue(actionHelper.IsCheckBoxInTableRows(tableAssignment));
		Log.info("Verified checkbox present and enabled in table on ManageAttendancePageVerification");
	}
	
	public void VerifyAddUserBtnPresent()
	{
		Assert.assertTrue(btnAddUser.isDisplayed());
		Log.info("Verified Add new user button present on ManageAttendancePageVerification");
	}
	
	public void VerifyAssignStaffBtnPresent()
	{
		Assert.assertTrue(btnAssignStaff.isDisplayed());
		Log.info("Verified Assign Staff button present on ManageAttendancePageVerification");
	}
	
	public void VerifySearchTextboxPresent()
	{
		Assert.assertTrue(txtSearch.isDisplayed());
		Log.info("Verified search textbox present on ManageAttendancePageVerification");
	}
	
	public void ClickAddUserBtnPresent()
	{
		actionHelper.Click(btnAddUser);
		Log.info("User click on Add new user button on ManageAttendancePageVerification");
	}
}


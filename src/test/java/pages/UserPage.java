package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
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
	private static String mainWindowHandle;
	private static String addeditPopUpHandle;
	
	@FindBy(xpath = "//table") WebElement tableUser;
	@FindBy(xpath = "//button[text()='Delete'][0]") WebElement btnMultipleDelete;
	@FindBy(xpath = "//button[text()='+ Add New User']") WebElement btnAddUser;
	@FindBy(xpath = "//button[text()='+ Assign Staff']") WebElement btnAssignStaff;
	@FindBy(xpath = "//input[id='Search']") WebElement txtSearch;
	// Add/Edit Popup Controls
	@FindBy(xpath = "//textbox[id='firstname']") WebElement txtFirstName;
	@FindBy(xpath = "//textbox[id='middlename']") WebElement txtMiddleName;
	@FindBy(xpath = "//textbox[id='lastname']") WebElement txtLastName;
	@FindBy(xpath = "//textbox[id='location']") WebElement txtLocation;
	@FindBy(xpath = "//textbox[id='phoneno']") WebElement txtPhone;
	@FindBy(xpath = "//textbox[id='email']") WebElement txtEmail;
	@FindBy(xpath = "//textbox[id='linkedinurl']") WebElement txtLinkedinUrl;
	@FindBy(xpath = "//textbox[id='undergraduate']") WebElement txtUG;
	@FindBy(xpath = "//textbox[id='postgraduate']") WebElement txtPG;
	@FindBy(xpath = "//textbox[id='timezone']") WebElement txtTimezone;
	@FindBy(xpath = "//textbox[id='comments']") WebElement txtComments;
	@FindBy(xpath = "//select[id='userrole']") WebElement selectUserRole;
	@FindBy(xpath = "//select[id='rolestatus']") WebElement selectRoleStatus;
	@FindBy(xpath = "//select[id='visastatus']") WebElement selectVisaStatus;
	@FindBy(xpath = "//button[id='submit']") WebElement btnSubmit;
	@FindBy(xpath = "//button[id='cancel']") WebElement btnCancel;
	
	
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
	
	public void ClickAddUserBtn()
	{
		actionHelper.Click(btnAddUser);
		Log.info("User click on Add new user button on User Page");
	}
	
	// User Details Pop up actions start here
	
	public void VerifyUserDetailsPopUpOpen()
	{
		mainWindowHandle = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			addeditPopUpHandle = iterator.next();
		}
		
		// switch to pop up window
		driver.switchTo().window(addeditPopUpHandle);
		
		Assert.assertEquals(driver.getTitle(), FileReaderManager.getInstance().getConfigReader().getUserDetailsPopUpTitle());
		Log.info("Verified that User Details pop is open");			
	}
	
	public void VerifyFieldPresentOnUserDetailsPopUp(String field)
	{
		driver.switchTo().window(addeditPopUpHandle);
		
		if(field.equalsIgnoreCase("First Name"))
			Assert.assertTrue(txtFirstName.isDisplayed());
		if(field.equalsIgnoreCase("Middle Name"))
			Assert.assertTrue(txtMiddleName.isDisplayed());
		if(field.equalsIgnoreCase("Last Name"))
			Assert.assertTrue(txtLastName.isDisplayed());
		if(field.equalsIgnoreCase("Location"))
			Assert.assertTrue(txtLocation.isDisplayed());
		if(field.equalsIgnoreCase("Email"))
			Assert.assertTrue(txtEmail.isDisplayed());
		if(field.equalsIgnoreCase("Phone"))
			Assert.assertTrue(txtEmail.isDisplayed());
		if(field.equalsIgnoreCase("Linkedin Url"))
			Assert.assertTrue(txtLinkedinUrl.isDisplayed());
		if(field.equalsIgnoreCase("Undergraduate"))
			Assert.assertTrue(txtUG.isDisplayed());
		if(field.equalsIgnoreCase("Postgraduate"))
			Assert.assertTrue(txtPG.isDisplayed());
		if(field.equalsIgnoreCase("Time Zone"))
			Assert.assertTrue(txtTimezone.isDisplayed());
		if(field.equalsIgnoreCase("User Comments"))
			Assert.assertTrue(txtComments.isDisplayed());
		if(field.equalsIgnoreCase("Visa Status"))
			Assert.assertTrue(selectRoleStatus.isDisplayed());
		if(field.equalsIgnoreCase("Role Status"))
			Assert.assertTrue(selectUserRole.isDisplayed());
		if(field.equalsIgnoreCase("User Role"))
			Assert.assertTrue(selectVisaStatus.isDisplayed());
		
		Log.info("Verified " + field + " is present on User Details pop up");
	}
	
	public void EnterUserDetails(HashMap<String, String> userDetails)
	{
		driver.switchTo().window(addeditPopUpHandle);
		
		if(!userDetails.get("First Name").isBlank())
		{
			actionHelper.EnterText(txtFirstName, userDetails.get("First Name"));
		}
		actionHelper.EnterText(txtMiddleName, userDetails.get("Middle Name"));
		actionHelper.EnterText(txtLastName, userDetails.get("Last Name"));
		actionHelper.EnterText(txtLocation, userDetails.get("Location"));
		actionHelper.EnterText(txtPhone, userDetails.get("Phone"));
		actionHelper.EnterText(txtEmail, userDetails.get("Email"));
		actionHelper.EnterText(txtUG, userDetails.get("UG"));
		actionHelper.EnterText(txtPG, userDetails.get("PG"));
		actionHelper.EnterText(txtTimezone, userDetails.get("Time Zone"));
		actionHelper.EnterText(txtComments, userDetails.get("User Comments"));
		
		actionHelper.SelectDropdownValue(selectUserRole, userDetails.get("User Role"));
		actionHelper.SelectDropdownValue(selectRoleStatus, userDetails.get("Role Status"));
		actionHelper.SelectDropdownValue(selectVisaStatus, userDetails.get("Visa Status"));
		
		Log.info("User enters user details on User details pop up");
	}
	
	public void ClickOnSubmitButton()
	{
		actionHelper.Click(btnSubmit);
		driver.switchTo().window(mainWindowHandle);
		
		Log.info("User clicks on Submit button on Add User Details pop up");
	}
	
	public void VerifyUserAdded(HashMap<String, String> userDetails)
	{
		// Enter search text
		actionHelper.EnterText(txtSearch, userDetails.get("First Name"));
		List<String> lstValues = new ArrayList<>();
		for (Map.Entry<String, String> set : userDetails.entrySet()) 
		{
			lstValues.add(set.getValue());
		}
		
		// verify added record in table
		Assert.assertTrue(actionHelper.VerifyRowPresent(tableUser, lstValues));
		
		Log.info("Verified user added on User Page");
	}
	
	public void VerifyMissingMandatoryErrorMessage(String message)
	{
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), message);
		alert.accept();
		
		Log.info("Verified error message for missing mandatory fields");
	}
	
	public void ClickEditForUser(String user)
	{
		
	}
	
}

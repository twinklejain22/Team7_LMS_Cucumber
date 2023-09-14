package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class ClassPage {

	WebDriver driver;
	static ActionHelper actionHelper;
	static String classTopic;

	private static String mainWindowHandle;
	private static String addeditPopUpHandle;

	@FindBy(xpath = "//table") static WebElement tableClass;
	@FindBy(xpath = "//a[text()='classPage']") WebElement classPage;// Link List
	@FindBy(xpath = "//button[text()='Delete'][0]") WebElement btnMultipleDelete;
	@FindBy(xpath = "//input[id='Search']") WebElement txtSearch;
	@FindBy(xpath = "//button[text()='+ Add New Class']") WebElement btnAddClass;
	@FindBy(xpath = "//button[text()='Sort Button']") WebElement btnSortClass;
	@FindBy(xpath = "//button[text()='Check Box Button']") WebElement btnCheckBoxClass;
	// Define the WebElement for the Batch ID dropdown using @FindBy annotation
	@FindBy(id = "batchIdDropdown") WebElement batchIdDropdown;
	@FindBy(id = "batchIdDropdown") WebElement staffIdDropdown;
	// Define the WebElement for the calendar icon using @FindBy annotation
	@FindBy(xpath = "//input[@id='classDate']/following-sibling::span[contains(@class,'calendar-icon')]") WebElement calendarIcon;
	// Define the WebElement for the "save" button using @FindBy annotation
	@FindBy(id = "saveButton") WebElement saveButton;// Replace with the actual ID of your save button
	@FindBy(id = "closeButton") WebElement closeButton;
	// Define the WebElement for the "cancel" button using @FindBy annotation
	@FindBy(id = "cancelButton") WebElement cancelButton; // Replace with the actual ID of your cancel button
	// Define WebElements for each field using @FindBy annotation
	@FindBy(id = "Batch ID") public static WebElement BatchIDText;
	// Replace with the actual ID of the first name field

	// Add/Edit Popup Controls
	@FindBy(xpath = "//textbox[id='txtBatchID']") WebElement txtBatchID;
	@FindBy(xpath = "//textbox[id='txtNoOfClassess']") WebElement txtNoOfClassess;
	@FindBy(xpath = "//textbox[id='txtClassDate']") WebElement txtClassDate;
	@FindBy(xpath = "//textbox[id='txtClassTopic']") WebElement txtClassTopic;
	@FindBy(xpath = "//textbox[id='txtStaffID']") WebElement txtStaffID;
	@FindBy(xpath = "//textbox[id='txtClassDescription']") WebElement txtClassDescription;
	@FindBy(xpath = "//textbox[id='txtComments']") WebElement txtComments;
	@FindBy(xpath = "//textbox[id='txtNotes']") WebElement txtNotes;
	@FindBy(xpath = "//textbox[id='txtRecording']") WebElement txtRecording;
	@FindBy(xpath = "//button[id='submit']") WebElement btnSubmit;
	@FindBy(xpath = "//button[id='cancel']") WebElement btnCancel;
	// Alert pop up
	@FindBy(xpath = "//button[id='Yes']") WebElement btnYes;
	@FindBy(xpath = "//button[id='No']") WebElement btnNo;
	@FindBy(xpath = "//button[id='btnBatchIDSort']") WebElement btnBatchIDSort;
	@FindBy(id = "batchIdHeader")  private WebElement batchIdHeader; // Replace with the actual ID or locator of the Batch ID column header

   

	public ClassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void GoToClassPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User navigates to LMS  Page");
	}

	public String GetClassAlertPopup() {
		Log.info("User sees alert pop up");
		return FileReaderManager.getInstance().getConfigReader().getClassDetailsPopUpTitle();

	}

	public long GetClassPageLoadingTime() {
		Log.info("class");
		return FileReaderManager.getInstance().getConfigReader().getClassLoadingTime();

	}

	public void VerifyClassPage() {
		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getClassPageTitle());

	}

	public void ValidateTableHeaders() {
		String[] expectedHeaders = FileReaderManager.getInstance().getConfigReader().getUserTableExpectedHeaders()
				.split(",");
		Assert.assertTrue(actionHelper.ValidateTableHeaders(tableClass, Arrays.asList(expectedHeaders)));
		Log.info("Verified user page table headers on Class Page");
	}

	public void ValidateBatchIDLabel(String text) {
		String batchIDText = FileReaderManager.getInstance().getConfigReader().getBatchIDLabel();
		Assert.assertTrue(batchIDText == text);
		Log.info("Verified batch id label is correct");
	}

	public void VerifyTextboxPresent() {
		Assert.assertTrue(txtSearch.isDisplayed());
		Log.info("Verified search textbox present on Class Page");
	}

	public void VerifyDeleteMutipleBtnDisabled() {
		Assert.assertFalse(btnMultipleDelete.isEnabled());
		Log.info("Verified Multiple delete button disabled on Class Page");
	}

	public void VerifySearchTextboxPresent() {
		Assert.assertTrue(txtSearch.isDisplayed());
		Log.info("Verified search textbox present on Class Page");
	}

	public void ClickAddClassBtnPresent() {
		actionHelper.Click(btnAddClass);
		Log.info("User click on Add new user button on Class Page");
	}

	public void VerifyEditButtonInEachRow() {
		Assert.assertTrue(actionHelper.IsEditButtonInTableRows(tableClass));
		Assert.assertTrue(actionHelper.IsEditButtonEnabledInTableRows(tableClass));
		Log.info("Verified edit button present and enabled in table on Class Page");
	}

	public void VerifyEditButtonNoEnteriesInEachRow() {
		Assert.assertTrue(actionHelper.IsEditButtonInTableRows(tableClass));
		Assert.assertTrue(actionHelper.IsEditButtonEnabledInTableRows(tableClass));
		Log.info("Verified edit button present and enabled in table on Class Page");
	}

	public void VerifyDeleteButtonInEachRow() {
		Assert.assertTrue(actionHelper.IsDeleteButtonInTableRows(tableClass));
		Assert.assertTrue(actionHelper.IsDeleteButtonEnabledInTableRows(tableClass));
		Log.info("Verified delete button present and enabled in table on Class Page");
	}

	public void ClickSortBtnPresent() {
		actionHelper.Click(btnSortClass);
		Log.info("User click on Add new user button on Class Page");// doubt
	}
	
	 public WebElement getBatchIdHeader() {
	        return batchIdHeader;
	    }

	 
	public void ClickCheckBoxBtnPresent() {
		actionHelper.Click(btnCheckBoxClass);
		Log.info("Admin click on Add new user button on Class Page");// doubt method shud be from action helper
	}

	public void alertPopDeleteDetails() {
		try {
			String alert = driver.switchTo().alert().getText();
			Assert.assertEquals(alert,
					FileReaderManager.getInstance().getConfigReader().getDeleteAlertText() + classTopic);
		} catch (Exception e) {
			// exception handling
		}
	}

	public void alertPopUpYes() {

		Alert alert = driver.switchTo().alert(); // switch to alert
		alert.accept();
	}

	public void alertPopUpNo() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void verifyPopUpWindowisBack() {

	}

//	click on date picker

	// Method to check if the "cancel" button is displayed
	public boolean isCancelButtonDisplayed() {
		return cancelButton.isDisplayed();
	}

	// Method to check if the Batch ID dropdown is displayed
	public boolean isBatchIdDropdownDisplayed() {
		return batchIdDropdown.isDisplayed();
	}

	public boolean isStaffIdDropdownDisplayed() {
		return staffIdDropdown.isDisplayed();
	}

	// Method to check if the calendar icon is displayed
	public boolean isCalendarIconDisplayed() {
		return calendarIcon.isDisplayed();
	}

	// Method to check if the "save" button is displayed
	public boolean isSaveButtonDisplayed() {
		return saveButton.isDisplayed();
	}

	// Method to check if the "close" button is displayed
	public boolean isCloseButtonDisplayed() {
		return closeButton.isDisplayed();
	}

	public void ClickBactchIDSortBtn() {
		actionHelper.Click(btnBatchIDSort);
		Log.info("User click on Add new user button on Class Page");
	}

	public void ClickAddUserBtnPresent() {
		actionHelper.Click(btnAddClass);
		Log.info("User click on Add new user button on Class Page");
	}

	/**
	 * Verifies if a field is present on User Details pop Up
	 * 
	 * @param field - Field name
	 */
	public void VerifyFieldPresentOnClassDetailsPopUp(String field) {
		driver.switchTo().window(addeditPopUpHandle);

		if (field.equalsIgnoreCase("Batch ID"))
			Assert.assertTrue(txtBatchID.isDisplayed());
		if (field.equalsIgnoreCase("No of Classes"))
			Assert.assertTrue(txtNoOfClassess.isDisplayed());
		if (field.equalsIgnoreCase("Class Date"))
			Assert.assertTrue(txtClassDate.isDisplayed());
		if (field.equalsIgnoreCase("Class Topic"))
			Assert.assertTrue(txtClassTopic.isDisplayed());
		if (field.equalsIgnoreCase("Staff ID"))
			Assert.assertTrue(txtStaffID.isDisplayed());
		if (field.equalsIgnoreCase("Class Description"))
			Assert.assertTrue(txtClassDescription.isDisplayed());
		if (field.equalsIgnoreCase("Comments"))
			Assert.assertTrue(txtComments.isDisplayed());
		if (field.equalsIgnoreCase("Notes"))
			Assert.assertTrue(txtNotes.isDisplayed());
		if (field.equalsIgnoreCase("Recording"))
			Assert.assertTrue(txtRecording.isDisplayed());

		Log.info("Verified " + field + " is present on Class Details pop up");
	}

	/**
	 * Verifies Error message for missing mandatory fields on User Details pop up
	 * 
	 * @param message
	 */
	public void VerifyMissingMandatoryErrorMessage(String message) {
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), message);
		alert.accept();

		Log.info("Verified error message for missing mandatory fields");
	}

	/**
	 * Clicks on Edit for a row based on user firstname
	 * 
	 * @param user
	 */
	public static void ClickEditForClass(String user) {
		try {
			try {
				try {
					try {
						actionHelper.ClickEditInRow(tableClass, user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.info("User clicks on Edit button for added user");
	}

	// User Details Pop up actions start here

	/**
	 * Verifies User Details (Add/Edit User) Pop Up is open
	 */
	public void VerifyClassDetailsPopUpOpen() {
		mainWindowHandle = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			addeditPopUpHandle = iterator.next();
		}
	}
		/**
		 * Clicks on Submit Button on User Details Pop Up
		 */
		public void ClickOnSubmitButton()
		{
			actionHelper.Click(btnSubmit);
			driver.switchTo().window(mainWindowHandle);
			
			Log.info("User clicks on Submit button on Add Class Details pop up");
		}
		
		/**
		 * Enters user details in all the fields
		 * @param userDetails - user details to be entered on User Details pop up
		 */
		public void EnterClassDetails(HashMap<String, String> classDetails)
		{
			driver.switchTo().window(addeditPopUpHandle);
			
			if(!classDetails.get("Batch ID").isBlank())
			{
				actionHelper.EnterText(txtBatchID, classDetails.get("Batch ID"));
			}
			actionHelper.EnterText(txtClassDate, classDetails.get("No of Classess"));
			actionHelper.EnterText(txtClassDate, classDetails.get("Class Date"));
			actionHelper.EnterText(txtClassTopic, classDetails.get("Class Topic"));
			actionHelper.EnterText(txtStaffID, classDetails.get("Staff ID"));
			actionHelper.EnterText(txtClassDescription, classDetails.get("Class Description"));
			actionHelper.EnterText(txtComments, classDetails.get("Comments"));
			actionHelper.EnterText(txtNotes, classDetails.get("Notes"));
			actionHelper.EnterText(txtRecording, classDetails.get("Recording"));
			
			Log.info("User enters class details on Class details pop up");
		}
		/**
		 * Verifies that a user is added
		 * @param userDetails - used added and to be verified
		 */
		public void VerifyClassAdded(HashMap<String, String> classDetails)
		{
			// Enter search text
			actionHelper.EnterText(txtSearch, classDetails.get("Batch ID"));
			List<String> lstValues = new ArrayList<>();
			for (Map.Entry<String, String> set : classDetails.entrySet()) 
			{
				lstValues.add(set.getValue());
			}
			
			// verify added record in table
			Assert.assertTrue(actionHelper.VerifyRowPresent(tableClass, lstValues));
			
			Log.info("Verified user added on Class Page");
		}
	

	public void VerifyUserAdded(HashMap<String, String> user) {
		// TODO Auto-generated method stub
		
	}

	public void DoubleClickOnBatchIDHeader() {
		actionHelper.DoubleClickOnColumnHeader(tableClass, "Batch Id");
	}
}









//
//public void VerifyDeleteButtonNotVisible()
//{
//	Assert.assertTrue(actionHelper.IsDeleteButtonInTableRows(tableUser));
//	Assert.assertTrue(actionHelper.IsDeleteButtonEnabledInTableRows(tableUser));
//	Log.info("Verified delete button present and enabled in table on Class Page");
//}

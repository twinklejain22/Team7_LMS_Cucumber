package pages;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class StudentPage {

	WebDriver driver;
	ActionHelper actionHelper;

	@FindBy(xpath = "//a[text()='Student']")
	WebElement studentButton;
	@FindBy(xpath = "/a")
	WebElement titleBar;
	@FindBy(xpath = "/label")
	WebElement textInTitleBar;
//	@FindBy(xpath="//")
	@FindBy(xpath = "span[text()='student_page.title]")
	WebElement studentPageTitle;
	@FindBy(xpath = "//select[@name='student']")
	WebElement studentNameDropdown;
	@FindBy(xpath = "//select[@name='batch']")
	WebElement batchIdDropdown;

	@FindBy(xpath = "//label[@name='student']")
	WebElement labelInStudentDropdown;
	@FindBy(xpath = "//input[@type='text' and @name='student']")
	WebElement studentDropdownSearchBox;
	
	@FindBy(xpath = "//label[@name='batchid']")
	WebElement labelInBatchIdDropdown;
	@FindBy(xpath = "//input[@type='text' and @name='batchid']")
	WebElement batchIdDropdownSearchBox;
	@FindBy(xpath="//a[text='Program']") WebElement programLink;
	@FindBy(xpath="//a[text='Batch']") WebElement batchLink;
	@FindBy(xpath="//a[text='class']") WebElement classLink;
	@FindBy(xpath="//a[text='user']") WebElement userLink;
	@FindBy(xpath="//a[text='admin']") WebElement adminLink;
	@FindBy(xpath="//a[text='attendance']") WebElement attendanceLink;
	@FindBy(xpath="//a[text='logout']") WebElement logoutLink;


	public StudentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void goToDashBoardPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		Log.info("User navigates to LMS Home Page");
	}

	public void verifyDashBoardPage() {
		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getDashBoardTitle());
		Log.info("Verified that user is on LMS Home Page");
	}

//	
//	public void VerifyLoginBtn()
//	{
//		Assert.assertTrue(btnLogin.isDisplayed());
//		Log.info("Verified that Login button is displayed");
//	}
//	
	public void clickOnStudentBtn() {
		actionHelper.Click(studentButton);
		Log.info("User clicks on Student button");
	}

	public void clickOnStudentDropdown() {
		actionHelper.Click(studentNameDropdown);
		Log.info("User clicks on Student dropdown");
	}

	public void clickOnBatchidDropdown() {
		actionHelper.Click(batchIdDropdown);
		Log.info("User clicks on BatchId dropdown");
	}

	public void verifyStudentPageTitle() {
		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getStudentPageTitle());
		Log.info("verified that user is on lms student details page");

	}

	public Long validateTime() {
		Long frontendTime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.domComplete-performance.timing.responseStart");

		System.out.println("frontendTime = " + frontendTime);

		return frontendTime;
	}

	public void verifyUrl() {

		String url;
		String appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		url = driver.getCurrentUrl();
		Assert.assertEquals(url, appUrl);
	}

	public void verifyLMSTitle() {
		String expectedTitle = "LMS - Learning Management System";
		String title = textInTitleBar.getText();
		Assert.assertEquals(title, expectedTitle);
	}

	public void verfyTheTitleIsCenter() {
		boolean result = studentPageTitle.isDisplayed();
		if (result == true) {
			// studentPageTitle.getAttribute("style").equalsIgnoreCase("text-align:center")
			Assert.assertEquals(studentPageTitle.getAttribute("style"), "text-align:center");
		} else {
			Assert.assertTrue(false);
		}

	}

	public void isDropDownPresent() {
		if (studentNameDropdown.isDisplayed() && batchIdDropdown.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void isTextBoxPresentInsideStudentNameDropDown() {
		if (studentDropdownSearchBox.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void isTextBoxPresentInsideBatchIdDropDown() {
		if (batchIdDropdownSearchBox.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void defaultDropdownTextSpelledCorrect(String expectedTitle) {
		Assert.assertEquals(studentNameDropdown.getText(), expectedTitle);

	}

	public void defaultBatchDropdownTextSpelledCorrect(String expTitle) {
		Assert.assertEquals(batchIdDropdown.getText(), expTitle);

	}

	public void checkNumbersBatchIdDropDown() {
		clickOnBatchidDropdown();
		Select se = new Select(batchIdDropdown);

		List<WebElement> l = se.getOptions();
		
		for (int i = 0; i <= l.size(); i++) {
			try {
				Integer.parseInt( l.get(i).getText() );
				Assert.assertTrue(true);
			} catch (NumberFormatException nfe) {
				Assert.assertTrue(false);
			}

		}

	}

	public void checkColorStudentName(String Expectedcolor)
	  {
		  String color = studentNameDropdown.getCssValue("color");
		  Assert.assertEquals(color, Expectedcolor);
	  }
    public void checkColorBatchId(String Expectedcolor)
    {
    	String color=batchIdDropdown.getCssValue("color");
    	Assert.assertEquals(color,Expectedcolor);
    }
    public void checkLabelInStudentDropDown(String text)
    {    	
    	Assert.assertEquals(labelInStudentDropdown.getText(), text);
    			
    }
    public void checkLabelInBatchIdDropDown(String text)
    {
    	Assert.assertEquals(labelInBatchIdDropdown.getText(), text);
		
    }
    public void validateStudentScrolldown()
    {
    	
    }
    public void validateBatchIdScrolldown()
    {
    	
    }
    
    public void selectStudentInDropdown()
    {
    	Select studentDropDown = new Select(studentNameDropdown);
    	
    	studentDropDown.selectByIndex(0);
    }
    
    public void verifyStudentDropdownLabelAfterSelection()
    {
    	Assert.assertNotEquals(labelInStudentDropdown.getText(), "Select Student Name");
    }
    
    public void selectBatchIdInDropdown()
    {
    	Select batchIdDropDown = new Select(batchIdDropdown);
    	
    	batchIdDropDown.selectByIndex(0);
    }
    
    public void inputStudentSearchText(String searchText) {
    	studentDropdownSearchBox.sendKeys(searchText);
    }
    
    public void verifyStudentDropdownOptions(String searchText) {
    	Select studentDropdown = new Select(studentNameDropdown);
    	
    	List<WebElement> options = studentDropdown.getOptions();
    	
    	Boolean result = true;
    	
    	for (int i = 0; i < options.size() && result; i++)
    	{
    		if ( ! options.get(i).getText().startsWith(searchText))
    			result = false;
    	}
    	
    	if (result == true) {
    		Assert.assertTrue(true);
    	}
    	else {
    		Assert.assertTrue(false);
    	}
    }
    
    public void inputBatchSearchText(Integer batchId){
    	batchIdDropdownSearchBox.sendKeys(batchId.toString());
    }
    
    public void verifyBatchDropdownOptions(Integer batchId) {
        Select batchDropdown = new Select(batchIdDropdown);
    	
    	List<WebElement> options = batchDropdown.getOptions();
    	
    	Boolean result = true;
    	
    	for (int i = 0; i < options.size() && result; i++)
    	{
    		if ( ! options.get(i).getText().startsWith(batchId.toString()))
    			result = false;
    	}
    	
    	if (result == true) {
    		Assert.assertTrue(true);
    	}
    	else {
    		Assert.assertTrue(false);
    	}
    }
    
    public void verifyBatchDropdownLabelAfterSelection()
    {
    	Assert.assertNotEquals(labelInBatchIdDropdown.getText(), "Select batch Id");
    }
    
    //features
    public void verifyStudentDetailsPage() {
		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getStudentPageTitle());
		Log.info("Verified that user is on LMS Home Page");
	}
    public void clickProgramLink()
    {
    	programLink.click();
    }
    public void isProgramPage()
    {
    	actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getProgramPageURL());
    	
    }
    //test_002
    public void verifyBatchPage() {
  		actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getBatchPageURL());
  		Log.info("Verified that user is on LMS Home Page");
  	}
      public void clickBatchLink()
      {
      	batchLink.click();
      }
      //test_003
      public void isClassPage()
      {
      	actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getClassPageURL());
      	
      }
      public void clickClassLink()
      {
      	classLink.click();
      }
      //test_004
      public void clickUserLink()
      {
      	userLink.click();
      }
      
      public void isUserPage()
      {
      	actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getClassPageURL());
      	
      }
      //test_005
      public void clickAdminLink()
      {
      	adminLink.click();
      }
      
      public void isAdminPage()
      {
      	actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getAdminURL());
      	
      }
      //test_006
      public void clickAttendanceLink()
      {
      	attendanceLink.click();
      }
      
      public void isAttendancePage()
      {
      	actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getAttendanceURL());
      	
      }
      //test_006
      public void clickLogoutLink()
      {
      	logoutLink.click();
      }
      
      public void isLogoutPage()
      {
      	actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getLogoutURL());
      	
      }
 
      
    }

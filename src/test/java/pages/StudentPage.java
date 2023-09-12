package pages;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.util.List;

import org.junit.Assert;
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

	@FindBy(xpath = "//input[@type='text' and @name='student']")
	WebElement studentDropdownSearchBox;
	@FindBy(xpath = "//input[@type='text' and @name='batchid']")
	WebElement batchIdDropdownSearchBox;

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

}
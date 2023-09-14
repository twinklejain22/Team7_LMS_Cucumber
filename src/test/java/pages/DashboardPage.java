package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	@FindBy(xpath = "//a[text()='User']")
	WebElement linkUser;
	@FindBy(xpath = "//a[text()='Program']")
	WebElement linkProgram;
	@FindBy(xpath = "//h1[contains(text(),'User')]")
	WebElement txtUserHeader;
	@FindBy(xpath = "//div[contains(@class, 'pagination')]")
	WebElement pagination;
	@FindBy(xpath = "//a[text()='Batch']")
	WebElement linkBatch;
	@FindBy(xpath = "//a[text()='Class']")
	WebElement linkClass;
	@FindBy(xpath = "//a[text()='Attendance']")
	WebElement linkAttendance;
	@FindBy(xpath = "//a[text()='Assignment']")
	WebElement linkAssignment;
	@FindBy(xpath = "//a[text()='Student']")
	WebElement linkStudent;

	@FindBy(xpath = "//nav")
	WebElement navigationBar;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement linkLogout;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void VerifyDashboardPage() {
		try {
			Assert.assertTrue(
					actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getDashboardPageTitle()));
			Log.info("Verified that user is on LMS Dashboard Page");
		} catch (NoSuchElementException ex) {
			if (driver.getTitle().contains("40")) {
				Assert.assertTrue(true);
				Log.info("Verified for broken link for Dashboard Page");
			}
		}
		Assert.assertTrue(
				actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getDashboardPageTitle()));
		Log.info("Verified that user is on LMS Dashboard Page");
	}

	public void GoToPage(String page) {
		if (page.equals("Program"))
			linkProgram.click();
		else if (page.equals("User"))
			linkUser.click();
		else if (page.equals("Batch"))
			linkBatch.click();
		else if (page.equals("Class"))
			linkClass.click();
		else if (page.equals("Attendance"))
			linkAttendance.click();
		else if (page.equals("Assignment"))
			linkAssignment.click();
		else if (page.equals("Student"))
			linkStudent.click();

		Log.info("User clicks on " + page + " on LMS Dashboard Page");
	}

	public void ValidatePageURL(String urlText) {
		Assert.assertTrue(actionHelper.VerifyURL(urlText));
		Log.info("Verified Page URL contains " + urlText);
	}

	public void VerifyPageHeader(String expectedHeader) {
		Assert.assertTrue(actionHelper.IsHeaderValid(txtUserHeader, expectedHeader));
		Log.info("Verified header text for LMS " + expectedHeader + " Page");
	}

	public void VerifyDashboardTitle() {
		Assert.assertEquals(driver.getTitle(), FileReaderManager.getInstance().getConfigReader().getDashboardTitle());
		Log.info("Verified Dashboard page title");
	}

	public void VerifyDashboardTitleAlignment() {
		Assert.assertTrue(actionHelper.IsAlignedInLeftHorizontally(txtUserHeader));
		Log.info("Verified Dashboard page title is aligned to left");
	}

	public void ValidateNavigationTimeToDashboard(LoginPage loginPage, String username, String password) {
		loginPage.EnterUsernamePassword(username, password);

		long start = System.currentTimeMillis();
		loginPage.ClickOnLoginBtn();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;

		Assert.assertTrue(totalTime <= FileReaderManager.getInstance().getConfigReader().getDashBoardLoadingTime());

		Log.info("Verified load time for Dashboard page");
	}

	public void VerifyNavigationBarAlignment() {
		Assert.assertTrue(actionHelper.IsAlignedInRightHorizontally(navigationBar));
		Log.info("Verified Dashboard navigation bar is aligned to right");
	}

	public void VerifyNavigationBarLinks() {
//		List<WebElement> navLinks = navigationBar.findElements(By.tagName("//a"));
//		List<String> navLinksText = new ArrayList<>();
		List <WebElement> navLinks = navigationBar.findElements(By.tagName("//a"));
		List <String> navLinksText = new ArrayList<>();
		for (WebElement link : navLinks )
		{
			navLinksText.add(link.getText());
		}
		List expectedLinks = (List) Arrays.asList(FileReaderManager.getInstance().getConfigReader().getNavigationLinks().split(","));
		
//		List<String> expectedLinks = Arrays.asList(FileReaderManager.getInstance().getConfigReader().getNavigationLinks().split(","));
		
		Assert.assertEquals(navLinksText, expectedLinks); 
		Log.info("Verified spelling and order of navigation links in navigation bar");
	
	}

	public void ClickOnLogout() {
		actionHelper.Click(linkLogout);
		Log.info("User clicks on Logout");
	}

}

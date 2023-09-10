package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.Log;
import utils.ActionHelper;

public class LoginPage {
	
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//h1[text()='Login']") WebElement txtHeader;
	@FindBy(xpath = "//a[id='username']") WebElement txtUserName;
	@FindBy(xpath = "//a[id='password']") WebElement txtPassword;
	@FindBy(xpath = "//a[text()='Login']") WebElement btnLogin;
	@FindBy(xpath = "//a[text()='Login']") WebElement linkForgot;
	@FindBy(xpath = "//a[text()='Login']") WebElement linkReset;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void VerifyLoginPage()
	{
		Assert.assertTrue(actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getLoginPageTitle()));
		Log.info("Verified that user is on LMS Login Page");
	}
	
	public void VerifyLoginHeader()
	{
		Assert.assertEquals(txtHeader.getText(), FileReaderManager.getInstance().getConfigReader().getLoginPageHeader());
		Log.info("Verified that header text for LMS Login Page");
	}
	
	public void VerifyUserNameTextBoxPresent()
	{
		Assert.assertTrue(txtUserName.isDisplayed());
		Log.info("Verified that Username textbox is displayed");
	}
	
	public void VerifyUserNameDefaultText()
	{
		Assert.assertEquals(txtUserName.getText(), FileReaderManager.getInstance().getConfigReader().getUsernameDefaultText());
		Log.info("Verified username defailt text on LMS Login Page");
	}
	
	public void VerifyPasswordTextBoxPresent()
	{
		Assert.assertTrue(txtPassword.isDisplayed());
		Log.info("Verified that Password textbox is displayed");
	}
	
	public void VerifyUsernameCenterAlignment()
	{
		Assert.assertTrue(actionHelper.IsAlignedInCenterHorizontally(txtUserName));
		Log.info("Verified username field is in the center horizontally");
	}
	
	public void VerifyUsernameFontColor()
	{
		Assert.assertTrue(actionHelper.VerifyFontColor(txtUserName, FileReaderManager.getInstance().getConfigReader().getTextFieldFintColor()));
		Log.info("Verified username default text is Dark Grey");
	}
	
	public void VerifyPasswordDefaultText()
	{
		Assert.assertEquals(txtPassword.getText(), FileReaderManager.getInstance().getConfigReader().getPasswordDefaultText());
		Log.info("Verified password defailt text on LMS Login Page");
	}
	
	public void VerifyPasswordCenterAlignment()
	{
		Assert.assertTrue(actionHelper.IsAlignedInCenterHorizontally(txtPassword));
		Log.info("Verified password field is in the center horizontally");
	}
	
	public void VerifyPasswordFontColor()
	{
		Assert.assertTrue(actionHelper.VerifyFontColor(txtPassword, FileReaderManager.getInstance().getConfigReader().getTextFieldFintColor()));
		Log.info("Verified username default text is Dark Grey");
	}
	
	public void VerifyLoginBtn()
	{
		Assert.assertTrue(btnLogin.isDisplayed());
		Log.info("Verified that Login button is displayed");
	}
	
	public void VerifyLoginBtnCenterAlignment()
	{
		Assert.assertTrue(actionHelper.IsAlignedInCenterHorizontally(btnLogin));
		Log.info("Verified login button is in the center horizontally");
	}
	
	public void ClickOnLoginBtn()
	{
		btnLogin.click();
		Log.info("User clicks on Login button");
	}
	
	public void VerifyForgotCredDisplayed()
	{
		Assert.assertTrue(linkForgot.isDisplayed());
		Log.info("Verified that Forgot Username/Password link is displayed");
	}
	
	public void VerifyResetPasswordDisplayed()
	{
		Assert.assertTrue(linkReset.isDisplayed());
		Log.info("Verified that Reset Password link is displayed");
	}
	
	public void Login(String userName, String password)
	{
		actionHelper.EnterText(txtUserName, userName);
		actionHelper.EnterText(txtPassword, password);
		actionHelper.Click(btnLogin);
		
		Log.info("User enters username, password and clicks on Login button");
	}

}

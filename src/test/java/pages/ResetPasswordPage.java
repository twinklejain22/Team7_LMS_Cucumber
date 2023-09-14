package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class ResetPasswordPage {
	
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//label[id='lblNewPassword']") WebElement lblNewPassword;
	@FindBy(xpath = "//label[id='lblRetypePassword']") WebElement lblRetypePassword;
	@FindBy(xpath = "//input[id='newpassword']") WebElement txtNewPassword;
	@FindBy(xpath = "//input[id='retypepassword']") WebElement txtRetypePassword;
	@FindBy(xpath = "//button[id='submit']") WebElement btnSubmit;
	
	
	public ResetPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void VerifyResetPasswordPage()
	{
		Assert.assertTrue(actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getResetPageTitle()));
		Log.info("Verified that user is on LMS resery password Page");
	}

	public void VerifySpellings() 
	{
		Assert.assertEquals(lblNewPassword.getText(), FileReaderManager.getInstance().getConfigReader().getNewPwdlabelText());
		Assert.assertEquals(lblRetypePassword.getText(), FileReaderManager.getInstance().getConfigReader().getRetypePwdlabelText());
		Assert.assertEquals(btnSubmit.getText(), FileReaderManager.getInstance().getConfigReader().getSubmitBtnText());
		Log.info("Verified spellings on Reset Page");
	}

	public void VerifySubmitBtnDisplayed() 
	{
		Assert.assertTrue(btnSubmit.isDisplayed());
		Log.info("Verified that Submit button is displayed");
	}

	public void VerifySubmitBtnAlignment() 
	{
		Assert.assertTrue(actionHelper.IsAlignedInCenterHorizontally(btnSubmit));
		Log.info("Verified that Submit button is aligned in center horizontally");
	}

	public void VerifyNewPwdLabelTxt() 
	{
		Assert.assertEquals(lblNewPassword.getText(), FileReaderManager.getInstance().getConfigReader().getNewPwdlabelText());
		Log.info("Verified New password label text");
	}

	public void VerifyRetypePwdLabelTxt() 
	{
		Assert.assertEquals(lblNewPassword.getText(), FileReaderManager.getInstance().getConfigReader().getRetypePwdlabelText());
		Log.info("Verified Retype password label text");
	}

	public void VerifyNewPwdTextDisabled() 
	{
		Assert.assertTrue(!txtNewPassword.isEnabled());
		Log.info("Verified new password textbox is disabled");
	}

	public void ClickOnNewPwdText() 
	{
		actionHelper.Click(txtNewPassword);
		Log.info("User clicks on New password text field");
	}

	public void VerifyNewPwdTextEnabled() 
	{
		Assert.assertTrue(txtNewPassword.isEnabled());
		Log.info("Verified new password textbox is enabled");
	}

	public void ClickOnRetypePwdText() 
	{
		actionHelper.Click(txtRetypePassword);
		Log.info("User clicks on Retype password text field");
	}

	public void VerifyRetypePwdTextEnabled() 
	{
		Assert.assertTrue(txtRetypePassword.isEnabled());
		Log.info("Verified retype password textbox is enabled");
	}

	public void SubmitNewPassword(String newPwd, String retypePwd) 
	{
		actionHelper.EnterText(txtNewPassword, newPwd);
		actionHelper.EnterText(txtRetypePassword, retypePwd);
		
		actionHelper.Click(btnSubmit);
		
		Log.info("User enters passwords and clicks on Submit");
	}

	public void VerifyMessage(String message) 
	{
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), message);
		
		alert.accept();
		Log.info("Verified message after entering passwords");
	}

}

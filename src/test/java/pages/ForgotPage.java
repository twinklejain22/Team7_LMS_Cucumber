package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.ActionHelper;
import utils.Log;

public class ForgotPage {
	
	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//a[id='email']") WebElement txtEmail;
	@FindBy(xpath = "//button[id='Send']") WebElement btnSend;
	
	
	public ForgotPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}

	public void VerifyForgotPage()
	{
		Assert.assertTrue(actionHelper.IsPageOpen(FileReaderManager.getInstance().getConfigReader().getForgotPageTitle()));
		Log.info("Verified that user is on LMS Forgot username/password Page");
	}
	
	public void VerifyEmailFontColor()
	{
		Assert.assertTrue(actionHelper.VerifyFontColor(txtEmail, FileReaderManager.getInstance().getConfigReader().getTextFieldFintColor()));
		Log.info("Verified email default text is Dark Grey");
	}
	
	public void VerifyEmailDefaultText()
	{
		Assert.assertEquals(txtEmail.getText(), FileReaderManager.getInstance().getConfigReader().getEmailDefaultText());
		Log.info("Verified email defailt text on LMS Forgot username/password Page");
	}

	public void VerifySendBtnPresent() 
	{
		Assert.assertTrue(btnSend.isDisplayed());
		Log.info("Verified send button is displayed");
	}

	public void ClickOnSendButton() {
		actionHelper.Click(btnSend);
		Log.info("User clicks on Send button");
	}

	public void EnterEmailId(String text) 
	{
		actionHelper.EnterText(txtEmail, text);
	}

	public void VerifyEmailSent() 
	{
		// TODO Auto-generated method stub
	}

	public void VerifyEmailNotSent() 
	{
		// TODO Auto-generated method stub
	}

}

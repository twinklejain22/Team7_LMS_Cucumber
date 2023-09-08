package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import utils.Log;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//h1[text()='Login']") WebElement txtHeader;
	@FindBy(xpath = "//a[id='username']") WebElement txtUserName;
	@FindBy(xpath = "//a[id='password']") WebElement txtPassword;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyLoginPage()
	{
		Assert.assertEquals(driver.getTitle(), FileReaderManager.getInstance().getConfigReader().getLoginPageTitle());
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
	
	public void VerifyPasswordTextBoxPresent()
	{
		Assert.assertTrue(txtPassword.isDisplayed());
		Log.info("Verified that Password textbox is displayed");
	}
	
	public void VerifyUserNameDefaultText()
	{
		Assert.assertEquals(txtUserName.getText(), FileReaderManager.getInstance().getConfigReader().getUsernameDefaultText());
		Log.info("Verified username defailt text on LMS Login Page");
	}
	
	public void VerifyPasswordDefaultText()
	{
		Assert.assertEquals(txtPassword.getText(), FileReaderManager.getInstance().getConfigReader().getPasswordDefaultText());
		Log.info("Verified password defailt text on LMS Login Page");
	}
	
	public void VerifyUsernameCenterAlignment()
	{
		int windowsCenter = driver.manage().window().getSize().getWidth()/2;
		int usernameFieldCenter = txtUserName.getSize().getWidth()/2;
		Assert.assertEquals(windowsCenter, usernameFieldCenter);
		
		Log.info("Verified username field is in the center horizontally");
	}
	
	public void VerifyPasswordCenterAlignment()
	{
		int windowsCenter = driver.manage().window().getSize().getWidth()/2;
		int usernameFieldCenter = txtPassword.getSize().getWidth()/2;
		Assert.assertEquals(windowsCenter, usernameFieldCenter);
		
		Log.info("Verified password field is in the center horizontally");
	}

}

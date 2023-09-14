package stepdefinitions;

import java.util.HashMap;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.DashboardPage;
import pages.ForgotPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;

public class ForgotCredentialsPage {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ForgotPage forgotPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	
	public ForgotCredentialsPage(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		forgotPage = testContext.getPageObjectManager().getForgotPage();
		
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
	}
	
	@Given("Admin is on LMS App Login Page")
	public void admin_is_on_lms_app_login_page() 
	{
		try
		{
			homePage.GoToHomePage();
			homePage.ClickOnLoginBtn();
			loginPage.VerifyLoginPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks forgot username or password link")
	public void admin_clicks_forgot_username_or_password_link() 
	{
		try
		{
			loginPage.ClickForgotCredLink();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should land on forgot username or password page")
	public void admin_should_land_on_forgot_username_or_password_page() 
	{
		try
		{
			forgotPage.VerifyForgotPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see Email text in gray color")
	public void admin_should_see_email_text_in_gray_color() 
	{
		try
		{
			forgotPage.VerifyEmailFontColor();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see Email correctly spelled with asterik in text field")
	public void admin_should_see_email_correctly_spelled_with_asterik_in_text_field() 
	{
		try
		{
			forgotPage.VerifyEmailDefaultText();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see send button with correct spelling in center of the page")
	public void admin_should_see_send_button_with_correct_spelling_in_center_of_the_page() 
	{
		try
		{
			forgotPage.VerifySendBtnPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Admin enters valid email id and clicks send link button")
	public void admin_enters_valid_email_id_and_clicks_send_link_button() 
	{
		try
		{
			forgotPage.EnterEmailId(loginExcelData.get("Login_Valid").get("username"));
			forgotPage.ClickOnSendButton();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should receive link in mail for reset username password")
	public void admin_should_receive_link_in_mail_for_reset_username_password() 
	{
		try
		{
			forgotPage.VerifyEmailSent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Admin enters invalid email id and clicks send link button")
	public void admin_enters_invalid_email_id_and_clicks_send_link_button() 
	{
		try
		{
			forgotPage.EnterEmailId(loginExcelData.get("Login_Invalid").get("username"));
			forgotPage.ClickOnSendButton();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should not receive link in mail for reset username password")
	public void admin_should_not_receive_link_in_mail_for_reset_username_password() 
	{
		try
		{
			forgotPage.VerifyEmailNotSent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

}

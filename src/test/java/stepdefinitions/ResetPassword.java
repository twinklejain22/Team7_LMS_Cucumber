package stepdefinitions;

import java.util.HashMap;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import utils.Log;

public class ResetPassword {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ResetPasswordPage resetPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> resetPwdExcelData;
	
	public ResetPassword(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		resetPage = testContext.getPageObjectManager().getResetPasswordPage();
		
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
		resetPwdExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("reset");
	}
	
	@Given("Admin has landed on LMS Login Page")
	public void admin_has_landed_on_lms_login_page() 
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

	@When("Admin clicks Reset Password Link")
	public void admin_clicks_reset_password_link() 
	{
		try
		{
			loginPage.ClickResetPasswordLink();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should land on reset password page")
	public void admin_should_land_on_reset_password_page() 
	{
		try
		{
			resetPage.VerifyResetPasswordPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see correct spellings on Reset page")
	public void admin_should_see_correct_spellings_on_reset_page() 
	{try
	{
		resetPage.VerifySpellings();
	}
	catch(Exception ex)
	{
		Log.error(ex.getMessage());
		Assert.fail();
	}
	}

	@Then("Admin should see Submit button")
	public void admin_should_see_submit_button() 
	{
		try
		{
			resetPage.VerifySubmitBtnDisplayed();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see submit button in center of the page")
	public void admin_should_see_submit_button_in_center_of_the_page() 
	{
		try
		{
			resetPage.VerifySubmitBtnAlignment();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see correct label text for new password")
	public void admin_should_see_correct_label_text_for_new_password() 
	{
		try
		{
			resetPage.VerifyNewPwdLabelTxt();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see correct label text for retyping new password.")
	public void admin_should_see_correct_label_text_for_retyping_new_password() 
	{
		try
		{
			resetPage.VerifyRetypePwdLabelTxt();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see text box in disabled state")
	public void admin_should_see_text_box_in_disabled_state() 
	{
		try
		{
			resetPage.VerifyNewPwdTextDisabled();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks on type in new password field")
	public void admin_clicks_on_type_in_new_password_field() 
	{
		try
		{
			resetPage.ClickOnNewPwdText();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see new pwd text box is enabled state")
	public void admin_should_see_new_pwd_text_box_is_enabled_state() 
	{
		try
		{
			resetPage.VerifyNewPwdTextEnabled();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks on retype password field")
	public void admin_clicks_on_retype_password_field() 
	{
		try
		{
			resetPage.ClickOnRetypePwdText();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see retype pwd text box is enabled state")
	public void admin_should_see_retype_pwd_text_box_is_enabled_state() 
	{
		try
		{
			resetPage.VerifyRetypePwdTextEnabled();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin enters passwords from {string}")
	public void admin_enters_passwords_from(String key) 
	{
		try
		{
			String newPwd = resetPwdExcelData.get(key).get("New Password");
			String retypePwd = resetPwdExcelData.get(key).get("Retype Password");
			
			resetPage.SubmitNewPassword(newPwd, retypePwd);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should recieve valid message as per {string}")
	public void admin_should_recieve_valid_message_as_per(String key) 
	{
		try
		{
			String message = resetPwdExcelData.get(key).get("Message");
			resetPage.VerifyMessage(message);
			if(key.contains("Valid"))
				loginPage.VerifyLoginPage();
			else
				resetPage.VerifyResetPasswordPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}


}

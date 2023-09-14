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
import utils.Log;

public class Login {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	
	public Login(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
	}
	
	@Given("Admin is in home page")
	public void admin_is_in_home_page() 
	{
		try
		{
			homePage.GoToHomePage();
			homePage.VerifyHomePage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks Login button")
	public void admin_clicks_login_button() 
	{
		try
		{
			homePage.ClickOnLoginBtn();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() 
	{
		try
		{
			loginPage.VerifyLoginPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see correct text in the header")
	public void admin_should_see_correct_text_in_the_header() 
	{
		try
		{
			loginPage.VerifyLoginHeader();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see right spellings in all fields")
	public void admin_should_see_right_spellings_in_all_fields() 
	{
		try
		{
			loginPage.VerifyAllSpellings();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() 
	{
		try
		{
			loginPage.VerifyUserNameTextBoxPresent();
			loginPage.VerifyPasswordTextBoxPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see correct default text with star in the first text field")
	public void admin_should_see_correct_default_text_with_star_in_the_first_text_field() 
	{
		try
		{
			loginPage.VerifyUserNameDefaultText();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see correct default text with star in the second text field")
	public void admin_should_see_correct_default_text_with_star_in_the_second_text_field() 
	{
		try
		{
			loginPage.VerifyPasswordDefaultText();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() 
	{
		try
		{
			loginPage.VerifyUsernameCenterAlignment();
			loginPage.VerifyPasswordCenterAlignment();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should be able to see login button")
	public void admin_should_be_able_to_see_login_button() 
	{
		try
		{
			loginPage.VerifyLoginBtn();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() 
	{
		try
		{
			loginPage.VerifyLoginBtnCenterAlignment();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see forgot username or password link")
	public void admin_should_see_forgot_username_or_password_link() 
	{
		try
		{
			loginPage.VerifyForgotCredDisplayed();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see reset password link")
	public void admin_should_see_reset_password_link() 
	{
		try
		{
			loginPage.VerifyResetPasswordDisplayed();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() 
	{
		try
		{
			loginPage.VerifyUsernameFontColor();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() 
	{
		try
		{
			loginPage.VerifyPasswordFontColor();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Admin logs in with username password combination from {string}")
	public void admin_logs_in_with_username_password_combination_from(String key) 
	{
		try
		{
			String userName = loginExcelData.get(key).get("username");
			String password = loginExcelData.get(key).get("password");
			loginPage.Login(userName, password);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should land on dashboard page or see error based on {string}")
	public void admin_should_land_on_dashboard_page_or_see_error_based_on(String key) 
	{
		try
		{
			if(key.equals("Login_Valid"))
				dashboardPage.VerifyDashboardPage();
			else
				loginPage.VerifyErrorMessage(loginExcelData.get(key).get("errormessage"));
				
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Given("Admin is on login page")
	public void admin_is_on_login_page() 
	{
		try
		{
			homePage.GoToHomePage();
			homePage.VerifyHomePage();
			homePage.ClickOnLoginBtn();
			loginPage.VerifyLoginPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() 
	{
		try
		{
			String userName = loginExcelData.get("Login_Valid").get("username");
			String password = loginExcelData.get("Login_Valid").get("password");
			loginPage.LoginUsingKeyboard(userName, password);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should go to on dashboard page")
	public void admin_should_go_to_on_dashboard_page() 
	{
		try
		{
			dashboardPage.VerifyDashboardPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
}

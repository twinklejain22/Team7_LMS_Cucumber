package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;

public class Login {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	
	public Login(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("Admin is in home page")
	public void admin_is_in_home_page() 
	{
		try
		{
			homePage.VerifyHomePage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
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
		}
	}
	
	@Then("Admin should see correct in the header")
	public void admin_should_see_correct_in_the_header() 
	{
		try
		{
			loginPage.VerifyLoginHeader();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
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
		}
	}

}

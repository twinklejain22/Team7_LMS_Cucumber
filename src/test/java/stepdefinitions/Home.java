package stepdefinitions;

import org.testng.Assert;

import context.TestContext;
import pages.HomePage;
import utils.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home {
	
	TestContext testContext;
	
	HomePage homePage;
	
	public Home(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() 
	{
		
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() 
	{
		try
		{
			homePage.GoToHomePage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() 
	{
		try
		{
			homePage.VerifyHomePage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() 
	{
		try
		{
			homePage.BrowseInvalidHomeURL();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should recieve page not found error")
	public void admin_should_recieve_page_not_found_error() 
	{
		try
		{
			homePage.ValidatePageNotFound();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Given("Admin gives the LMS portal URL")
	public void admin_gives_the_lms_portal_url() 
	{
		try
		{
			homePage.BrowseBrokenHomeURL();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("HTTP response error code for broken url")
	public void http_response_error_code_for_broken_url() 
	{
		try
		{
			homePage.ValidateErrorCode();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() 
	{
		try
		{
			homePage.VerifyLoginBtn();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() 
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

}

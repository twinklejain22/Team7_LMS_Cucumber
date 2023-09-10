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

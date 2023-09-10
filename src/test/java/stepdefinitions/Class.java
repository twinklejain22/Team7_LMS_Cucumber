package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClassPage;
import pages.HomePage;
import utils.Log;

public class Class {
	

	TestContext testContext;
	
	ClassPage classPage;
	
	public Class(TestContext context)
	
	{
		testContext = context;
		classPage = testContext.getPageObjectManager().getClassPage();
	}
	
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String string) {
	  
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
	   
	}

}



	

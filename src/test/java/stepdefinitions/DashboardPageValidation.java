package stepdefinitions;

import java.util.HashMap;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.HomePage;
import pages.LoginPage;
import pages.DashboardPage;
import utils.Log;

public class DashboardPageValidation {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	
	public DashboardPageValidation(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
	}
	
	@Given("User is on log in page")
	public void user_is_on_log_in_page() 
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

	@When("User clicks login after entering valid username and password")
	public void user_clicks_login_after_entering_valid_username_and_password() 
	{
		try
		{
			String userName = loginExcelData.get("Login_Valid").get("username");
			String password = loginExcelData.get("Login_Valid").get("password");
			loginPage.Login(userName, password);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see {string} as header")
	public void admin_should_see_as_header(String header) 
	{
		try
		{
			dashboardPage.VerifyPageHeader(header);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Maximum navigation time in milliseconds, defaults to thirty seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_thirty_seconds() 
	{
		try
		{
			dashboardPage.ValidateNavigationTimeToDashboard(loginPage, 
					loginExcelData.get("Login_Valid").get("username"), loginExcelData.get("Login_Valid").get("password"));
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("HTTP response should be error code for broken url")
	public void http_response_should_be_error_code_for_broken_url() 
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
	
	@Then("Admin should see LMS - Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() 
	{
		try
		{
			dashboardPage.VerifyDashboardTitle();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() 
	{
		try
		{
			dashboardPage.VerifyDashboardTitleAlignment();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see correct spelling and order in navigation bar text")
	public void admin_should_see_correct_spelling_and_order_in_navigation_bar_text() 
	{
		try
		{
			dashboardPage.VerifyNavigationBarLinks();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() 
	{
		try
		{
			dashboardPage.VerifyNavigationBarAlignment();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() 
	{
		try
		{
			dashboardPage.ClickOnLogout();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() 
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

}

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
import pages.PaginationPage;
import pages.UserPage;
import utils.Log;

public class DeleteUser {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> userExcelData;
	
	public DeleteUser(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		userPage = testContext.getPageObjectManager().getUserPage();
		
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
		userExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("user");
	}
	
	@Given("Admin is on dashboard page after Log in to LMS")
	public void admin_is_on_dashboard_page_after_log_in_to_lms() 
	{
		try
		{
			homePage.GoToHomePage();
			homePage.ClickOnLoginBtn();
			
			String userName = loginExcelData.get("Login_Valid").get("username");
			String password = loginExcelData.get("Login_Valid").get("password");
			loginPage.Login(userName, password);
			
			dashboardPage.VerifyDashboardPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks {string} from the navigation panel on Dashboard")
	public void admin_clicks_from_the_navigation_panel_on_dashboard(String page) 
	{
		try
		{
			dashboardPage.GoToPage(page);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() 
	{
		try
		{
			userPage.VerifyDeleteButtonInEachRow();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() 
	{
		try
		{
			userPage.ClickDeleteForUser(EditUser.user.get("First Name"));
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() 
	{
		try
		{
			userPage.AlertPresentWithButtons();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin click yes option")
	public void admin_click_yes_option() 
	{
		try
		{
			userPage.ClickYesOnDeleteAlert();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("User deleted alert pops and user is no more available in data table")
	public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() 
	{
		try
		{
			userPage.VerifyDeletionConfirmation();
			userPage.VerifyUserDeleted(EditUser.userOnlyMandatoryDetails);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Given("Admin is on Delete Confirmation pop up")
	public void admin_is_on_delete_confirmation_pop_up() 
	{
		try
		{
			userPage.ClickDeleteForUser(EditUser.userAllDetails);
			userPage.ClickNoOnDeleteAlert();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin click No option")
	public void admin_click_no_option() 
	{
		try
		{
			userPage.ClickNoOnDeleteAlert();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("User is still listed in data table")
	public void user_is_still_listed_in_data_table() 
	{
		try
		{
			userPage.VerifyUserPresent(EditUser.userAllDetails);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}


}

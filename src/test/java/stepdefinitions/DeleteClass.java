package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteClass {
	
	package stepdefinitions;
	​
	import java.util.HashMap;
	​
	import org.testng.Assert;
	​
	import context.TestContext;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import managers.FileReaderManager;
	import pages.DashboardPage;
	import pages.HomePage;
	import pages.LoginPage;
	import pages.PaginationPage;
	import pages.ManageAssignmentPage;
	import utils.Log;
	​
	public class DeleteAssignment {
		
		TestContext testContext;
		
		HomePage homePage;
		LoginPage loginPage;
		DashboardPage dashboardPage;
		PaginationPage paginationPage;
		ManageAssignmentPage manageassignmentPage;
		
		public static HashMap<String, HashMap<String, String>> loginExcelData;
		public static HashMap<String, HashMap<String, String>> assignmentExcelData;
		
		public DeleteAssignment(TestContext context)
		{
			testContext = context;
			homePage = testContext.getPageObjectManager().getHomePage();
			loginPage = testContext.getPageObjectManager().getLoginPage();
			dashboardPage = testContext.getPageObjectManager().getDashboardPage();
			paginationPage = testContext.getPageObjectManager().getPaginationPage();
			manageassignmentPage = testContext.getPageObjectManager().getManageAssignmentPage();
			
			loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
			assignmentExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("assignment");
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
	​
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
	​
		@Given("The delete icon on row level in data table is enabled")
		public void the_delete_icon_on_row_level_in_data_table_is_enabled() 
		{
			try
			{
				manageassignmentPage.VerifyDeleteButtonInEachRow();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
		@When("Admin clicks the delete icon")
		public void admin_clicks_the_delete_icon() 
		{
			try
			{
				manageassignmentPage.ClickDeleteForAssignment(EditAssignment.Assignment.get("Program Name"));
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
		@Then("Alert appears with yes and No option")
		public void alert_appears_with_yes_and_no_option() 
		{
			try
			{
				manageassignmentPage.AlertPresentWithButtons();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
		@When("Admin click yes option")
		public void admin_click_yes_option() 
		{
			try
			{
				manageassignmentPage.ClickYesOnDeleteAlert();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
		@Then("Assignment deleted alert pops and assignment is no more available in data table")
		public void assignment_deleted_alert_pops_and_user_is_no_more_available_in_data_table() 
		{
			try
			{
				manageassignmentPage.VerifyDeletionConfirmation();
				manageassignmentPage.VerifyUserDeleted(EditAssignment.AssignmentOnlyMandatoryDetails);
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
				manageassignmentPage.ClickDeleteForAssignment(EditAssignment.AssignmentAllDetails);
				manageassignmentPage.ClickNoOnDeleteAlert();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
		@When("Admin click No option")
		public void admin_click_no_option() 
		{
			try
			{
				manageassignmentPage.ClickNoOnDeleteAlert();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
		@Then("Assignment is still listed in data table")
		public void assignment_is_still_listed_in_data_table() 
		{
			try
			{
				manageassignmentPage.VerifyAssignmentPresent(EditAssignment.AssignmentAllDetails);
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	​
	​
	
//	@Given("Admin is on the dashboard page after Log in to LMS")
//	public void admin_is_on_the_dashboard_page_after_log_in_to_lms() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Admin clicks on {string} from the navigation panel on Dashboard")
//	public void admin_clicks_on_from_the_navigation_panel_on_dashboard(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("The delete icon on row level in data table is enabled")
//	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Admin clicks the delete icon")
//	public void admin_clicks_the_delete_icon() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Alert appears with yes and No option")
//	public void alert_appears_with_yes_and_no_option() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Admin click yes option")
//	public void admin_click_yes_option() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("User deleted alert pops and user is no more available in data table")
//	public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Admin is on Delete Confirmation pop up")
//	public void admin_is_on_delete_confirmation_pop_up() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Admin click No option")
//	public void admin_click_no_option() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Delete is still listed in data table")
//	public void delete_is_still_listed_in_data_table() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//



}

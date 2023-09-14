package stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class DeleteMultipleUsers {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> userExcelData;
	static List<String> usersToDelete = new ArrayList<>();
	
	public DeleteMultipleUsers(TestContext context)
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
	
	@Given("Admin is on dashboard after Log in to LMS")
	public void admin_is_on_dashboard_after_log_in_to_lms() 
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

	@When("Admin selects {string} from the navigation panel on Dashboard")
	public void admin_selects_from_the_navigation_panel_on_dashboard(String page) 
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

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() 
	{
		try
		{
			userPage.VerifyNoCheckBoxesSelectedInTable();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("The delete multiple icon should be disabled")
	public void the_delete_multiple_icon_should_be_disabled() 
	{
		try
		{
			userPage.VerifyDeleteMutipleBtnDisabled();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Given("One of the checkbox or row is selected")
	public void one_of_the_checkbox_or_row_is_selected() 
	{
		try
		{
			userPage.SelectCheckBoxInUserTable(EditUser.userAllDetails);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Click delete multiple icon")
	public void click_delete_multiple_icon() 
	{
		try
		{
			userPage.ClickMultipleDeleteButton();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() 
	{
		try
		{
			userPage.ClickYesOnDeleteAlert();
			userPage.VerifyDeletionConfirmation();
			userPage.VerifyUserDeleted(EditUser.userAllDetails);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Given("Two checkboxes or row is selected")
	public void two_checkboxes_or_row_is_selected() 
	{
		try
		{
			List<String> usersToDelete = new ArrayList<>();
			usersToDelete.add(AddNewUser.userForMultiDelete1);
			usersToDelete.add(AddNewUser.userForMultiDelete2);
			for(String user : usersToDelete)
			{
				userPage.SelectCheckBoxInUserTable(user);
			}
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Click on delete multiple icon")
	public void click_on_delete_multiple_icon() 
	{
		try
		{
			userPage.ClickMultipleDeleteButton();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("The respective rows in the data table is deleted")
	public void the_respective_rows_in_the_data_table_is_deleted() 
	{
		try
		{
			userPage.ClickYesOnDeleteAlert();
			userPage.VerifyDeletionConfirmation();
			for(String user : usersToDelete)
			{
				userPage.VerifyUserDeleted(user);
			}
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
}

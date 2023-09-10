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

public class UserPageValidation {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	
	public UserPageValidation(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		userPage = testContext.getPageObjectManager().getUserPage();
		
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("program");
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() 
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

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String page) 
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

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String pageUrlTxt) 
	{
		try
		{
			dashboardPage.ValidatePageURL(pageUrlTxt);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String headerTxt) 
	{
		try
		{
			dashboardPage.VerifyPageHeader(headerTxt);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() 
	{
		try
		{
			paginationPage.VerifyPaginationControlsPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin Should see the data table with headers Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_headers_id_name_location_phone_number_edit_delete() 
	{
		try
		{
			userPage.ValidateTableHeaders();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should be able to see the delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() 
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

	@Then("Admin should be able to see the add new user button")
	public void admin_should_be_able_to_see_the_add_new_user_button() 
	{
		try
		{
			userPage.VerifyAddUserBtnPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should be able to see the Assign staff button")
	public void admin_should_be_able_to_see_the_assign_staff_button() 
	{
		try
		{
			userPage.VerifyAssignStaffBtnPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should be able to see the search text box")
	public void admin_should_be_able_to_see_the_search_text_box() 
	{
		try
		{
			userPage.VerifySearchTextboxPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() 
	{
		try
		{
			userPage.VerifyCheckboxInEachRow();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() 
	{
		try
		{
			userPage.VerifyEditButtonInEachRow();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() 
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
	
	@When("Admin clicks add new user button")
	public void admin_clicks_add_new_user_button() 
	{
		try
		{
			userPage.ClickAddUserBtnPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}

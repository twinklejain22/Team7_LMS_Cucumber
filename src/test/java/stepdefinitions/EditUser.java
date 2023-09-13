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

public class EditUser {

	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	
	static HashMap<String, String> user;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> userExcelData;
	
	public EditUser(TestContext context)
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
	
	@Given("Admin is on dashboard page after Log in")
	public void admin_is_on_dashboard_page_after_log_in() 
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

	@When("Admin clicks {string} from the navigation panel")
	public void admin_clicks_from_the_navigation_panel(String page) 
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

	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() 
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

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() 
	{
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("A pop up with User details appears for Edit")
	public void a_pop_up_with_user_details_appears_for_edit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}

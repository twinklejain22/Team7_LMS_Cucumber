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
import utils.DynamicValues;
import utils.Log;

public class AddNewUser {
	
	TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	
	static HashMap<String, String> user;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> userExcelData;
	
	public AddNewUser(TestContext context)
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

	@Given("Admin is on {string} page")
	public void admin_is_on_page(String page) 
	{
		try
		{
			homePage.GoToHomePage();
			homePage.ClickOnLoginBtn();
			
			String userName = loginExcelData.get("Login_Valid").get("username");
			String password = loginExcelData.get("Login_Valid").get("password");
			loginPage.Login(userName, password);

			dashboardPage.GoToPage(page);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks on add new user button")
	public void admin_clicks_on_add_new_user_button() 
	{
		try
		{
			userPage.ClickAddUserBtn();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("The pop up should have all the {string}")
	public void the_pop_up_should_have_all_the(String field) 
	{
		try
		{
			userPage.VerifyFieldPresentOnUserDetailsPopUp(field);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Fill in all the fields except optional fields with valid values")
	public void fill_in_all_the_fields_except_optional_fields_with_valid_values() 
	{
		try
		{
			user = userExcelData.get("User_MandatoryFields");
			user.put("Phone", String.valueOf(DynamicValues.PhoneNumber()));
			user.replace("First Name", user.get("First Name") + DynamicValues.SerialNumber());
			
			userPage.EnterUserDetails(user);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Given("Mandatory {string}  are blank")
	public void mandatory_are_blank(String string) 
	{
		try
		{
			user = userExcelData.get("User_AllFields");
			user.put("Phone", String.valueOf(DynamicValues.PhoneNumber()));
			if(! user.get("First Name").isBlank())
				user.replace("First Name", user.get("First Name") + DynamicValues.SerialNumber());
			
			userPage.EnterUserDetails(user);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Error message should appear for missing {string}")
	public void error_message_should_appear_for_missing(String string) 
	{
		try
		{
			userPage.VerifyUserAdded(user);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@When("Fill in all the fields for {string}")
	public void fill_in_all_the_fields_for(String key) 
	{
		try
		{
			user = userExcelData.get(key);
			if(key.equals("User_MissingPhone"))
				user.put("Phone", "");
			else
				user.put("Phone", String.valueOf(DynamicValues.PhoneNumber()));
			if(! user.get("First Name").isBlank())
				user.replace("First Name", user.get("First Name") + DynamicValues.SerialNumber());
			
			userPage.EnterUserDetails(user);
			userPage.ClickOnSubmitButton();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin able to verify new record or error as per {string}")
	public void admin_able_to_verify_new_record_or_error_as_per(String key) 
	{
		try
		{
			if(user.get("First Name").isBlank() || user.get("Last Name").isBlank()
				|| user.get("Phone").isBlank() || user.get("Location").isBlank()
				|| user.get("Role Status").isBlank() || user.get("User Role").isBlank()
				|| user.get("Visa Status").isBlank() || key.contains("Invalid"))
			{
				userPage.VerifyMissingMandatoryErrorMessage(user.get("Message"));
			}
			else
			{
				userPage.VerifyUserAdded(user);
			}
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

}

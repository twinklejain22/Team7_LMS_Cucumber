package stepdefinitions;

import java.util.HashMap;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.ClassPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaginationPage;
import pages.UserPage;
import utils.DynamicValues;
import utils.Log;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewClass {
	
TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	ClassPage classPage;
	static HashMap<String, String> classDetails;
	public static String classAllDetails;
	public static String classOnlyMandatoryDetails;
	
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> classExcelData;
	
	public AddNewClass(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		userPage = testContext.getPageObjectManager().getUserPage();
		classPage = testContext.getPageObjectManager().getClassPage();
		
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

	@When("Admin clicks on add new class button")
	public void admin_clicks_on_add_new_class_button() 
	{
		try
		{
			classPage.ClickAddClassBtnPresent();
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
			classPage.VerifyFieldPresentOnClassDetailsPopUp(field);
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
			classDetails = classExcelData.get("Class_MandatoryFields");
//			classData.put("Phone", String.valueOf(DynamicValues.BatchID()));
			classDetails.replace("First Name", classDetails.get("Batch ID") + DynamicValues.SerialNumber());
			
			classPage.EnterClassDetails(classDetails);
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
			classDetails = classExcelData.get("Class_AllFields");
//			classData.put("Batch ID", String.valueOf(DynamicValues.BatchID()));
			if(! classDetails.get("Staff ID").isBlank())
				classDetails.replace("First Name", classDetails.get("Staff ID") + DynamicValues.SerialNumber());
			
			classPage.EnterClassDetails(classDetails);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Error message should appear for missing {string}")
	public void error_message_should_appear_for_missing(String classDetails) 
	{
		try
		{
			classPage.VerifyClassAdded(classDetails);
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
			classDetails = classExcelData.get(key);
			if(key.equals("Class_MissingBatchID"))
				classDetails.put("BatchID", "");
			else
//				classData.put("BatchID", String.valueOf(DynamicValues.BatchID()));
			if(! classDetails.get("Staff ID").isBlank())
//				classData.replace("Staff ID", classDetails.get("Staff ID") + DynamicValues.SerialNumber());
			
			classPage.EnterClassDetails(classDetails);
			classPage.ClickOnSubmitButton();
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
			if(classDetails.get("Batch ID").isBlank() || classDetails.get(" No of Classes").isBlank()
				|| classDetails.get("Class Date").isBlank() || classDetails.get("Class Topic").isBlank()
				|| classDetails.get("Staff Id").isBlank() || classDetails.get("Class description").isBlank()
				|| classDetails.get("Comments").isBlank() ||  key.contains("Invalid"))
			{
				classPage.VerifyMissingMandatoryErrorMessage(classDetails.get("Message"));
			}
			else
			{
				classPage.VerifyUserAdded(classDetails);
			}
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

}
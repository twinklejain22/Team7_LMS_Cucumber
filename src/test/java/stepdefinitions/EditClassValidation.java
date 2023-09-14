package stepdefinitions;

import java.util.HashMap;
import org.testng.Assert;

//import com.aventstack.extentreports.util.Assert;

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

public class EditClassValidation {
	
TestContext testContext;
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	UserPage userPage;
	ClassPage classPage;
	
	public static HashMap<String, String> classDetails;
	public static String userAllDetails;
	public static String userOnlyMandatoryDetails;
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> userExcelData;
	
	

@Given("Admin is on dashboard page after Log in")
public void admin_is_on_dashboard_page_after_log_in() {
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
public void admin_clicks_from_the_navigation_panel(String page) {
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
public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
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
public void admin_clicks_the_edit_icon() {
	try
	{
		ClassPage.ClickEditForClass(AddNewClass.classOnlyMandatoryDetails);
	}
	catch(Exception ex)
	{
		Log.error(ex.getMessage());
		Assert.fail();
	}
}

@Then("A pop up with Class details appears for Edit")
public void a_pop_up_with_class_details_appears_for_edit() {
	try
	{
		classPage.VerifyClassDetailsPopUpOpen();
	}
	catch(Exception ex)
	{
		Log.error(ex.getMessage());
		Assert.fail();
	}
}

@Given("Admin is on Class Details pop up for Edit")
public void admin_is_on_class_details_pop_up_for_edit() {
	try
	{
	classPage.VerifyClassDetailsPopUpOpen();
	}
	catch(Exception ex)
	{
		Log.error(ex.getMessage());
		Assert.fail();
	}
}  

@When("Update the fields with values as per {string} and click submit")
public void update_the_fields_with_values_as_per_and_click_submit(String key) {
	try
	{
		classDetails = userExcelData.get(key);
		if(key.equals("User_MissingBatchID"))
			classDetails.put("BatchID", "");
		else
//			user.put("BatchID", String.valueOf(DynamicValues.Batch ID()));
		if(! classDetails.get("Batch ID").isBlank())
//			user.replace("Batch ID", user.get("Batch ID") + DynamicValues.SerialNumber());
		
		if(key.equals("User_EditMandatoryFields"))
			userOnlyMandatoryDetails = classDetails.get("Batch ID"); 
		if(key.equals("User_EditAllFields"))
			userAllDetails = classDetails.get("First Name");
		
		classPage.EnterClassDetails(classDetails);
		classPage.ClickOnSubmitButton();
	}
	catch(Exception ex)
	{
		Log.error(ex.getMessage());
		Assert.fail();
	}
}



@Then("Valid values should get updated or error should appear {string}")
public void valid_values_should_get_updated_or_error_should_appear(String key) {
	try
	{
		if(classDetails.get("Batch ID").isBlank() || classDetails.get("No of Classess").isBlank()
			|| classDetails.get("Class Date").isBlank() || classDetails.get("Class Topic").isBlank()
			|| classDetails.get("Staff ID").isBlank() || classDetails.get("Class Description").isBlank()
			|| classDetails.get("Comments").isBlank() || key.contains("Invalid"))
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

/*
	

	
	


	@When("Update the fields with values as per {string} and click submit")
	public void update_the_fields_with_values_as_per_and_click_submit(String key) 
	{
		
	@Then("Valid values should get updated or error should appear {string}")
	public void valid_values_should_get_updated_or_error_should_appear(String key) 
	{
		
	}


}*/


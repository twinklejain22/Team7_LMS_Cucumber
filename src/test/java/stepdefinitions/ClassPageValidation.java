package stepdefinitions;

import static org.junit.Assert.assertEquals;

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
import utils.Log;

public class ClassPageValidation {
	TestContext testContext;

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	ClassPage classPage;

	public static HashMap<String, HashMap<String, String>> loginExcelData;

	public ClassPageValidation(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		classPage = testContext.getPageObjectManager().getClassPage();

		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		try {
			homePage.GoToHomePage();
			homePage.ClickOnLoginBtn();

			String userName = loginExcelData.get("Login_Valid").get("username");
			String password = loginExcelData.get("Login_Valid").get("password");
			loginPage.Login(userName, password);

			dashboardPage.VerifyDashboardPage();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin clicks {string} button on the navigation bar")
	public void admin_clicks_button_on_the_navigation_bar(String page) {
		try {
			dashboardPage.GoToPage(page);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String pageUrlTxt) {
		try {
			dashboardPage.ValidatePageURL(pageUrlTxt);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Get the response time for navigation from dashboard page to manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {
		long time = classPage.GetClassPageLoadingTime();
		assertEquals(time,30000);
		
		
		
	}

	@Then("Admin should see header with {string}")
	public void admin_should_see_header_with(String headerTxt) {

		try {
			dashboardPage.VerifyPageHeader(headerTxt);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
//		
		// Check the text content of each field against expected values
        String expectedBatchID = "Batch ID";
        // Get the actual text from the Page Object elements
        String actualBatchID = ClassPage.BatchIDText.getText().trim();
        
		// Compare the actual text with the expected text
        assertEquals("Incorrect spelling in the Batch ID", expectedBatchID, actualBatchID);
       
        // Add more assertions for other fields as needed
    }

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
		try {
			classPage.VerifyDeleteMutipleBtnDisabled();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {

		try {
			classPage.VerifySearchTextboxPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {
		try {
			classPage.ClickAddClassBtnPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see data table on the Manage Class Page With following column headers. \\(Check box symbol,Batch Id, Class No,Class Date, Class Topic, Staff Id, Description, Comments, Notes, Recording, Edit Delete)")
	public void admin_should_see_data_table_on_the_manage_class_page_with_following_column_headers_check_box_symbol_batch_id_class_no_class_date_class_topic_staff_id_description_comments_notes_recording_edit_delete() {
		try {
			classPage.ValidateTableHeaders();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		{
			try
			{
				classPage.VerifyEditButtonInEachRow();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}

	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		{
			try
			{
				classPage.VerifyEditButtonNoEnteriesInEachRow();
			}
			catch(Exception ex)
			{
				Log.error(ex.getMessage());
				Assert.fail();
			}
		}
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		try
		{
			classPage.VerifyDeleteButtonInEachRow();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		try
		{
			classPage.VerifyDeleteMutipleBtnDisabled();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		try {
			classPage.ClickSortBtnPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		try {
			classPage.ClickCheckBoxBtnPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

}

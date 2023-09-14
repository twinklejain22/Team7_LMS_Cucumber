package stepdefinitions;

import java.util.HashMap;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.AttendancePage;
import utils.Log;

public class ManageAttendancePageVerification {

	TestContext testContext;
	AttendancePage attendancePage;

	ManageAttendancePageVerification manageattendancePageverification;

	public static HashMap<String, HashMap<String, String>> loginExcelData;

	public ManageAttendancePageVerification(TestContext context) {
		testContext = context;
		attendancePage = testContext.getPageObjectManager().getAttendancePage();
		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("program");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		try {
			Object page = null;
			manageattendancePageverification.GoToPage(page);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	private void GoToPage(Object page) {
		// TODO Auto-generated method stub

	}

	@Then("Admin should see the Manage attendance in header")
	public void admin_should_see_the_manage_attendance_in_header() {
		try {
			Object pageUrlTxt = null;
			(manageattendancePageverification).ValidatePageURL(pageUrlTxt);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	private void ValidatePageURL(Object pageUrlTxt) {
		// TODO Auto-generated method stub

	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {

	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
		try {
			Object pageUrlTxt = null;
			manageattendancePageverification.ValidatePageURL(pageUrlTxt);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
//		driver = null;
//		WebElement manageattendancePageverification = driver
//				.findElement((SearchContext) By.tagName("manageattendancePageverification"));
//		String titleText = manageattendancePageverification.getText();
//		Assert.assertEquals("LMS - Learning management system", titleText);
	}

	@Then("Manage attendance header should be in left side of the page")
	public void manage_attendance_header_should_be_in_left_side_of_the_page() {
		{

		}

	}

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {

	}

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
		try {
			manageattendancePageverification.VerifyDeleteMutipleBtnDisabled();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	private void VerifyDeleteMutipleBtnDisabled() {
		// TODO Auto-generated method stub

	}

	@Then("Admin should see search bar on the attendance page")
	public void admin_should_see_search_bar_on_the_attendance_page() {
		try {
			manageattendancePageverification.VerifySearchTextboxPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	private void VerifySearchTextboxPresent() {
		// TODO Auto-generated method stub

	}

	@Then("Admin should see +Add New Attendance button on the attendance page")
	public void admin_should_see_add_new_attendance_button_on_the_attendance_page() {
		try {
			manageattendancePageverification.VerifyAddUserBtnPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	private void VerifyAddUserBtnPresent() {
		// TODO Auto-generated method stub

	}

//	@Then("Admin should see data table on the Manage Attendance Page With following column headers\\.\\(Check box symbol,Class ID, Student Id,Preasent, Edit \\/Delete)")
//	public void admin_should_see_data_table_on_the_manage_attendance_page_with_following_column_headers_check_box_symbol_class_id_student_id_preasent_edit_delete() {
//		try {
//			manageattendancePageverification.ValidateTableHeaders();
//		} catch (Exception ex) {
//			Log.error(ex.getMessage());
//			Assert.fail();
//		}
//
//	}


	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		if (manageattendancePageverification.isDisplayed()) {
			Assert.assertTrue(manageattendancePageverification.isDisplayed());
		} else {
			Assert.assertFalse(manageattendancePageverification.isDisplayed());
		}

	}

	private boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		try {
			manageattendancePageverification.VerifyEditButtonInEachRow();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	private void VerifyEditButtonInEachRow() {
		// TODO Auto-generated method stub

	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		try {
			manageattendancePageverification.VerifyEditButtonInEachRow();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		try {
			manageattendancePageverification.VerifyDeleteMutipleBtnDisabled();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		try {
			manageattendancePageverification.VerifyEditButtonInEachRow();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}

	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		try {
			manageattendancePageverification.VerifyCheckboxInEachRow();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	private void VerifyCheckboxInEachRow() {
		// TODO Auto-generated method stub

	}

	@Then("Admin should see the text with total number classes in the data table. \\( {string})")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String string) {
		String actualText = manageattendancePageverification.getText().trim();

		// Verify if the actual text matches the expected text
		Assert.assertEquals("Total number of classes text does not match", manageattendancePageverification,
				actualText);

	}

	private String getText() {
		// TODO Auto-generated method stub
		return null;
	}

}
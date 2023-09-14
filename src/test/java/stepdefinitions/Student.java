package stepdefinitions;

import org.testng.AssertJUnit;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StudentPage;

public class Student {

	TestContext testContext;
	StudentPage studentPage;

	public Student(TestContext context) {
		testContext = context;
		studentPage = testContext.getPageObjectManager().getStudentPage();
	}

//test_001	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		// studentPage.GoToHomePage();
		studentPage.goToDashBoardPage();
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String button) {
		if (button.equalsIgnoreCase("Student")) {
			studentPage.clickOnStudentBtn();
		}
	}

	@When("Admin clicks Student dropdown")
	public void admin_clicks_student_dropdown() {
		studentPage.clickOnStudentDropdown();
	}

	@When("Admin clicks batchId dropdown")
	public void admin_clicks_batchid_dropdown() {
		studentPage.clickOnBatchidDropdown();
	}

	@Then("Admin should see the Student details Page Title")
	public void admin_should_see_the_student_details_page_title() {
		studentPage.verifyStudentPageTitle();

	}
//test_002

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer time) {
		// Write code here that turns the phrase above into concrete actions
		// Assert.assertEquals(time.intValue(), Poststatuscode );
		Long navigationTime = studentPage.validateTime();

		AssertJUnit.assertTrue(navigationTime.intValue() < time.intValue());

	}

//test_003
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {

		studentPage.verifyUrl();

	}

//test_004
	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		studentPage.verifyStudentPageTitle();
	}

//test_005

	@Then("Student Detail title should be in centre of the page")
	public void student_detail_title_should_be_in_centre_of_the_page() {
		studentPage.verfyTheTitleIsCenter();

	}

//test_006
	@Then("{int} dropdowns should be present in the page")
	public void dropdowns_should_be_present_in_the_page(Integer int1) {
		studentPage.isDropDownPresent();
	}

//test_007
	@Then("Admin should see search box inside the drop down")
	public void admin_should_see_search_box_inside_the_drop_down() {
		studentPage.isTextBoxPresentInsideStudentNameDropDown();

	}

//test_008
	@Then("Admin should see search box inside  batch id drop down")
	public void admin_should_see_search_box_inside_batch_id_drop_down() {
		studentPage.isTextBoxPresentInsideBatchIdDropDown();

	}
//test_009

	@Then("Admin should see correct spelling {string}")
	public void admin_should_see_correct_spelling(String expTitle) {
		studentPage.defaultDropdownTextSpelledCorrect(expTitle);
	}

//test_010

	@Then("Admin should see correct spelling {string} text")
	public void admin_should_see_correct_spelling_text(String expTitle) {
		studentPage.defaultBatchDropdownTextSpelledCorrect(expTitle);
	}

//test_011

	@Then("Admin should see only numbers inside batch id drop down")
	public void admin_should_see_only_numbers_inside_batch_id_drop_down() {
		studentPage.checkNumbersBatchIdDropDown();
	}

//test_012

	@Then("Admin should see select student name in {string} color")
	public void admin_should_see_select_student_name_in_color(String color) {
		studentPage.checkColorStudentName(color);
	}
//test_013

	@Then("Admin should see select batch ID in gray color")
	public void admin_should_see_select_batch_id_in_gray_color(String color) {
		studentPage.checkColorBatchId(color);

	}
//test_014

	@Then("Admin should see {string} in first")
	public void admin_should_see_select_student_name_in_first(String text) {
		studentPage.checkLabelInStudentDropDown(text);
	}

//test_015
	@Then("Admin should see {string} in second")
	public void admin_should_see_select_batch_id_in_second(String text) {
		studentPage.checkLabelInBatchIdDropDown(text);

	}

//test_016
	@Then("Admin should able to scroll down to select the name")
	public void admin_should_able_to_scroll_down_to_select_the_name() {
		studentPage.validateStudentScrolldown();
	}

//test_017

	@Then("Admin should able to scroll down to select the batch id")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id() {
		studentPage.validateBatchIdScrolldown();
	}
//test_018

	@Given("Admin is on student details page")
	public void admin_is_on_student_details_page() {
		studentPage.verifyStudentDetailsPage();
	}

//@17_StudentNameIsfading
	@When("Admin select student name from the drop down")
	public void admin_select_student_name_from_the_drop_down() {
		studentPage.selectStudentInDropdown();
	}

	@Then("Admin should not see select student name text")
	public void admin_should_not_see_select_student_name_text() {
		studentPage.verifyStudentDropdownLabelAfterSelection();
	}

//@18_BatchIdIsfading
	@When("Admin select batch id from the drop down")
	public void admin_select_batch_id_from_the_drop_down() {
		studentPage.selectBatchIdInDropdown();
	}

	@Then("Admin should not see select batch id text")
	public void admin_shouldn_t_see_select_batch_id_text() {
		studentPage.verifyBatchDropdownLabelAfterSelection();
	}

//@19_SelectStudentUsingSearchBox

	@When("Admin clicks select student name and  enters {string} alphabet in the search box")
	public void admin_clicks_select_student_name_and_enters_alphabet_in_the_search_box(String searchText) {
		studentPage.clickOnStudentDropdown();

		studentPage.inputStudentSearchText(searchText);
	}

	@Then("Admin should see student name start with {string} is listed below")
	public void admin_should_see_student_name_start_with_is_listed_below(String searchText) {
		studentPage.verifyStudentDropdownOptions(searchText);
	}

//@20_SelectBatchUsingSearchBox
	@When("Admin  clicks select batch id and enter {int} number in the search box")
	public void admin_clicks_select_batch_id_and_enter_number_in_the_search_box(Integer batchId) {
		studentPage.clickOnBatchidDropdown();

		studentPage.inputBatchSearchText(batchId);
	}

	@Then("Admin should see batch id start with {int} is listed below")
	public void admin_should_see_batch_id_start_with_is_listed_below(Integer batchId) {
		studentPage.verifyBatchDropdownOptions(batchId);
	}
//@21_SelectStudentName
	@When("Admin selects only student name")
	public void admin_selects_only_student_name() {
		studentPage.clickOnStudentDropdown();
		studentPage.selectStudentInDropdown();
	}

	@Then("Student details should not be displayed")
	public void student_details_shouldn_t_be_displayed() {
		studentPage.detailsNotDisplayed();
	}

//@22BatchId
	@When("Admin selects only  batch id")
	public void admin_selects_only_batch_id() {
		studentPage.clickOnBatchidDropdown();
		studentPage.selectBatchIdInDropdown();
	}

//@23StudentNameandBatchId
	@When("Admin selects  student name and batch id")
	public void admin_selects_student_name_and_batch_id() {
		studentPage.clickOnStudentDropdown();
		studentPage.selectStudentInDropdown();

		studentPage.clickOnBatchidDropdown();
		studentPage.selectBatchIdInDropdown();
	}

	@Then("Particular student informations should be displayed")
	public void particular_student_informations_should_be_displayed() {
		studentPage.detailsDisplayed();
	}

}
package stepdefinitions;

import java.util.HashMap;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.AttendancePage;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaginationPage;

public class AddNewAttendance {

	TestContext testContext;

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	AttendancePage attendancePage;

	public static HashMap<String, String> user;
	public static String userAllDetails;
	public static String userOnlyMandatoryDetails;
	public static String userForMultiDelete1;
	public static String userForMultiDelete2;

	public static HashMap<String, HashMap<String, String>> loginExcelData;
	public static HashMap<String, HashMap<String, String>> userExcelData;

	public AddNewAttendance(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		attendancePage = testContext.getPageObjectManager().getAttendancePage();

		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
		userExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("user");
	}

	@Given("Admin is in  attendance details popup window")
	public void admin_is_in_attendance_details_popup_window() {

	}

	@When("Admin fills all the values and click save")
	public void admin_fills_all_the_values_and_click_save() {

	}

	@Then("The pop up should have all the {string}")
	public void the_pop_up_should_have_all_the(String string) {

	}

	@When("Fill in all the fields for {string}")
	public void fill_in_all_the_fields_for(String string) {

	}

	@Then("Admin able to verify new record or error as per {string}")
	public void admin_able_to_verify_new_record_or_error_as_per(String string) {

	}

}
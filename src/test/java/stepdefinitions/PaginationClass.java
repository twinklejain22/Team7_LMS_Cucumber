package stepdefinitions;

import java.util.HashMap;

import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pages.ClassPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaginationPage;
import utils.Log;

public class PaginationClass {
	TestContext testContext;

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	ClassPage classPage;

	public static HashMap<String, HashMap<String, String>> loginExcelData;

	public PaginationClass(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		classPage = testContext.getPageObjectManager().getClassPage();

		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
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

	@Then("Data table should display first page  when entries available")
	public void data_table_should_display_first_page_when_entries_available() {
		try {
			paginationPage.VerifyPaginationControlsPresent();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

}

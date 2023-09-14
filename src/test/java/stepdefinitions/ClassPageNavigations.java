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
import utils.Log;

public class ClassPageNavigations {
	

	TestContext testContext;

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	ClassPage classPage;

	public static HashMap<String, HashMap<String, String>> loginExcelData;

	public ClassPageNavigations(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		classPage = testContext.getPageObjectManager().getClassPage();

		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
	}

	@Given("Admin is in Manage class page")
	public void admin_is_in_manage_class_page(String headerTxt) {
		try
		{
			homePage.GoToHomePage();
			homePage.ClickOnLoginBtn();
			
			String userName = loginExcelData.get("Login_Valid").get("username");
			String password = loginExcelData.get("Login_Valid").get("password");
			loginPage.Login(userName, password);
			dashboardPage.VerifyPageHeader(headerTxt);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}


	@When("Admin clicks {string} button in the navigation bar")
	public void admin_clicks_button_in_the_navigation_bar(String string) {
		try {
			dashboardPage.GoToPage(string);
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on student page")
	public void admin_should_able_to_land_on_student_page(String string) {
		try
		{
			dashboardPage.GoToPage(string);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on program page")
	public void admin_should_able_to_land_on_program_page(String string) {
		try
		{
			dashboardPage.GoToPage(string);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on batch page")
	public void admin_should_able_to_land_on_batch_page(String string) {
		try
		{
			dashboardPage.GoToPage(string);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on user page")
	public void admin_should_able_to_land_on_user_page(String string) {
		try
		{
			dashboardPage.GoToPage(string);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on Assignment page")
	public void admin_should_able_to_land_on_assignment_page(String string) {
		try
		{
			dashboardPage.GoToPage(string);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on Attendance page")
	public void admin_should_able_to_land_on_attendance_page(String string) {
		try
		{dashboardPage.GoToPage(string);}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should able to land on login page")
	public void admin_should_able_to_land_on_login_page() {
		try
		{
			dashboardPage.ClickOnLogout();
			loginPage.VerifyLoginPage();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

}

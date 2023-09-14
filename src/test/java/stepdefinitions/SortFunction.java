package stepdefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import utils.ActionHelper;
import utils.Log;

public class SortFunction {
	
	TestContext testContext;

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	ClassPage classPage;
	ActionHelper actionHelper;
	
	
	public static HashMap<String, HashMap<String, String>> loginExcelData;

	public SortFunction(TestContext context) {
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
	
	@When("Admin click on Batch id column header to sort")
	public void admin_click_on_batch_id_column_header_to_sort() {
		try
		{
			classPage.ClickSortBtnPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see data table sorted in descending order")
	public void admin_should_see_data_table_sorted_in_descending_order() {
		try
		{
			actionHelper.isDataTableSortedDescending();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@When("Admin double click on Batch id column header to sort")
	public void admin_double_click_on_batch_id_column_header_to_sort() {
		try
		{
			classPage.DoubleClickOnBatchIDHeader();  
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}   
	}

	@Then("Admin should see data table sorted in ascending  order")
	public void admin_should_see_data_table_sorted_in_ascending_order() {
		try
		{
			actionHelper.isDataTableSortedAscending();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}




}

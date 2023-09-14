package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class ClassWindowPopUp {
	
	TestContext testContext;

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PaginationPage paginationPage;
	ClassPage classPage;

	public static HashMap<String, HashMap<String, String>> loginExcelData;

	public ClassWindowPopUp(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		dashboardPage = testContext.getPageObjectManager().getDashboardPage();
		paginationPage = testContext.getPageObjectManager().getPaginationPage();
		classPage = testContext.getPageObjectManager().getClassPage();

		loginExcelData = FileReaderManager.getInstance().getExcelReader().ReadExcelFile("login");
	}
	
	@Given("Admin is on Manage Class Page")
	public void admin_is_on_manage_class_page(String headerTxt) {
		
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

	@When("Admin click +Add New Class button")
	public void admin_click_add_new_class_button() {

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

	
	
	
	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
	   
	}
	
	
	
	
	
	
	

	@Then("Admin should see a popup  with  heading {string}")
	public void admin_should_see_a_popup_with_heading(String headerTxt) {
		try
		{
			dashboardPage.VerifyPageHeader(headerTxt);//class page n add button
			
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	   
	}

	@Then("Admin should see input fields Text \\(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)")
	public void admin_should_see_input_fields_text_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings() {
		try
		{
			classPage.ValidateTableHeaders();//verify fields 
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}
	
	@Then("Admin should see {string} text box in class details pop up window")
	public void admin_should_see_text_box_in_class_details_pop_up_window(String string) {

		try
		{
			classPage.VerifyTextboxPresent();
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}

	@Then("Admin should see {string} label in class details pop up window")
	public void admin_should_see_label_in_class_details_pop_up_window(String string) {
		try
		{
			classPage.ValidateBatchIDLabel(string);
		}
		catch(Exception ex)
		{
			Log.error(ex.getMessage());
			Assert.fail();
		}
	}


	@Then("Admin should see  dropdown option for Batch ID")
	public void admin_should_see_dropdown_option_for_batch_id() {
		try {
			classPage.isBatchIdDropdownDisplayed();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
			assertTrue("Batch ID dropdown is not displayed", classPage.isBatchIdDropdownDisplayed());
			 
		}
	}

	@Then("Admin should see  dropdown option for Staff Id")
	public void admin_should_see_dropdown_option_for_staff_id() {
		try {
			classPage.isStaffIdDropdownDisplayed();
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			Assert.fail();
			assertTrue("Batch ID dropdown is not displayed", classPage.isStaffIdDropdownDisplayed());
			 
		}
	}

	@Then("Admin should see  calendar icon for class date")
	public void admin_should_see_calendar_icon_for_class_date() {
		assertTrue("Calendar icon for class date is not displayed", classPage.isCalendarIconDisplayed());
    } 

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
		assertTrue("Save button is not displayed in the class detail popup window", classPage.isSaveButtonDisplayed());
		 
	}

	@Then("Admin should see  close button on the class details popup window")
	public void admin_should_see_close_button_on_the_class_details_popup_window() {
		 assertTrue("Close button is not displayed on the class details popup window", classPage.isCloseButtonDisplayed());
		    
	}
	@Then("Admin should see pop up alert")
	public void admin_should_see_pop_up_alert() {
		String popupTitle = classPage.GetClassAlertPopup();
		assertEquals(popupTitle, "Are you sure you want to delete");		
		
	  
	}


	
}

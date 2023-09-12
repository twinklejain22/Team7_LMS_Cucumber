package stepdefinitions;

import org.testng.AssertJUnit;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.Response;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.codec.http.HttpResponse;
import pages.HomePage;
import pages.StudentPage;

public class Student {
 
	TestContext testContext;
	StudentPage studentPage;
	
	public Student(TestContext context)
	{
		testContext = context;
		studentPage = testContext.getPageObjectManager().getStudentPage();
	}
//test_001	
@Given("Admin is on dashboard page after Login")
public void admin_is_on_dashboard_page_after_login() {
     //studentPage.GoToHomePage();
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
	//Assert.assertEquals(time.intValue(), Poststatuscode  );
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







	

	
  
}










}

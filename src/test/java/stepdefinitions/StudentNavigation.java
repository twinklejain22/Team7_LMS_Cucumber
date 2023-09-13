package stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StudentPage;

public class StudentNavigation {
	TestContext testContext;
	StudentPage studentPage;

	@Given("Admin is on student details page")
	public void admin_is_on_student_details_page() {
		studentPage.verifyStudentDetailsPage();

	}

	@When("Admin clicks on program link on student  page")
	public void admin_clicks_on_program_link_on_student_page() {
		studentPage.clickProgramLink();
	}

	@Then("Admin is redirected to Program page")
	public void admin_is_redirected_to_program_page() {
		studentPage.isProgramPage();
	}
//test_002

	@When("Admin clicks on Batch link on student page")
	public void admin_clicks_on_batch_link_on_student_page() {
		studentPage.clickBatchLink();
	}

	@Then("Admin is redirected to Batch page")
	public void admin_is_redirected_to_batch_page() {
		studentPage.verifyBatchPage();

	}

//test_003
	@When("Admin clicks on Class link on student page")
	public void admin_clicks_on_class_link_on_student_page() {
		studentPage.clickClassLink();

	}

	@Then("Admin is redirected to Class page")
	public void admin_is_redirected_to_class_page() {
		studentPage.isClassPage();

	}
//test_004

	@When("Admin clicks on User link on student page")
	public void admin_clicks_on_user_link_on_student_page() {
		studentPage.clickUserLink();
	}

	@Then("Admin is redirected to User page")
	public void admin_is_redirected_to_user_page() {
		studentPage.isUserPage();
	}


//test_005

@When("Admin clicks on Assignment link on student page")
public void admin_clicks_on_assignment_link_on_student_page() {
   studentPage.clickAdminLink();
}

@Then("Admin is redirected to Assignment Page")
public void admin_is_redirected_to_assignment_page() {
   studentPage.isAdminPage();;
}
//test__006
@When("Admin clicks on Attendance link on student page")
 public void admin_clicks_on_attendance_link_on_student_page() {
	studentPage.clickAttendanceLink();
    
}
@Then("Admin is redirected to Attendance page")
public void admin_is_redirected_to_attendance_page() {
    studentPage.isAttendancePage();
}
//test_007

@When("Admin clicks on Logout link on student page")
public void admin_clicks_on_logout_link_on_student_page() {
   studentPage.clickLogoutLink();
}

@Then("Admin is redirected to Login page")
public void admin_is_redirected_to_login_page() {
    studentPage.isLogoutPage();
}



}



package stepdefinitions;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttendanceWindowPopup
{
	private WebElement addnewattendanceButton;

	@Given("Admin is in manage attendance page")
	public void admin_is_in_manage_attendance_page() 
	{
		// driver.get("https://docs.google.com/presentation/d/1CC9MchYbotYtAd3wh0x0K42Uw66kDGIx-24_y6a4jHY/edit#slide=id.g240bf5dd818_0_99/manage-attendance"); 
	}

	@When("Admin clicks + a new attendance button")
	public void admin_clicks_a_new_attendance_button() 
	{
		addnewattendanceButton = null;
		//WebElement addButton = driver.findElement(By.id("addAttendanceButton")); // 
        addnewattendanceButton.click();
	    
	}

	@Then("Admin should see correct spellings in the label")
	public void admin_should_see_correct_spellings_in_the_label() {
	    
	}

	@Then("{int} dropdown should be present")
	public void dropdown_should_be_present(Integer int1) {
	    
	}

	@Then("Admin should see  close button on the attendance details popup window")
	public void admin_should_see_close_button_on_the_attendance_details_popup_window() {
	    
	}

	@Then("Close button should on the top right corner")
	public void close_button_should_on_the_top_right_corner() {
	   
	}

	@Then("First dropdown box {string} text  should be present")
	public void first_dropdown_box_text_should_be_present(String string) {
	   
	}

	@Then("Second dropdown box {string} text  should be present")
	public void second_dropdown_box_text_should_be_present(String string) {
	    
	}

	@Then("Third dropdown box {string} text  should be present")
	public void third_dropdown_box_text_should_be_present(String string) {
	    	}

	@Then("Fourth dropdown box {string} text  should be present")
	public void fourth_dropdown_box_text_should_be_present(String string) {
	    	}

	@Then("Admin  should text in gray color")
	public void admin_should_text_in_gray_color() {
	   
	}

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
	    	}

	@Then("Admin should see  cancel button in the class detail popup window")
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
	   	}

	@Then("Order of the label should be Program name, Class Name, Student Name, Attendance, Attendance Date.")
	public void order_of_the_label_should_be_program_name_class_name_student_name_attendance_attendance_date() {
	    	}

	@Then("Program Name in the drop down should match with  program name in  manage program page table")
	public void program_name_in_the_drop_down_should_match_with_program_name_in_manage_program_page_table() {
	    	}

	@Then("Class Name in the drop down should match with  class name in  manage class page table")
	public void class_name_in_the_drop_down_should_match_with_class_name_in_manage_class_page_table() {
	  	}

	@Then("Attendance field should have keywords such as - present, absent, late, excused")
	public void attendance_field_should_have_keywords_such_as_present_absent_late_excused() {
	    
	}

	@Then("Admin should see correct spellings in dropdown text")
	public void admin_should_see_correct_spellings_in_dropdown_text() {
	   
	}

	@Then("selected date should be their in class date text box")
	public void selected_date_should_be_their_in_class_date_text_box() {
	    	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format")
	public void selected_date_should_be_in_mm_dd_yyyy_format() {
	    	}

	@Then("Next month calender should visible")
	public void next_month_calender_should_visible() {
	    	}

	@Then("previous month calender should visible")
	public void previous_month_calender_should_visible() {
	    	}

	@Then("Admin should see current date is highled in the date picker")
	public void admin_should_see_current_date_is_highled_in_the_date_picker() {
	    	}

	@Then("Admin should see selected date is highled in the date picker")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker() {
	   	}



}
	
   
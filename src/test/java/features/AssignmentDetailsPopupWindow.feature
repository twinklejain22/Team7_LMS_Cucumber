@AssignmentDetailsPopupWindow
Feature: Assignment details Popup window verification

	Background: Admin logged into LMS portal and clicks assignment button on the navigation bar 
   Given Admin is on manage assignment page
    When Admin click +Add new assignment button
    
  @AssignmentDetailsPopupWindow 
  Scenario: Verify Assignment details popup window
    Then Admin should see a popup  with  heading "Assignment details"
    
  @AssignmentDetailsPopupWindow input field
  Scenario: Verify input fields in Assignment details popup window
    Then Admin should see input fields Text (Program name, batch number,Assignment Name, Assignment Description, grade by, Assignment due date, Assignment File1, Assignment file 2, Assignment file 3, Assignment file 4, Assignment file 5)
    
  @AssignmentDetailsPopupWindow texr box 
  Scenario: Verify text box present in Assignment details popup window
    Then 8 textbox should be  present in Assignment details popup window
    
  @AssignmentDetailsPopupWindow drop down in Batch Number
  Scenario: Verify drop down in Batch Number  in Assignment details popup window
    Then Admin should see  dropdown option for Batch Number
    
  @AssignmentDetailsPopupWindow  drop down in Program name
  Scenario: Verify drop down in Program name  in Assignment details popup window
    Then Admin should see  dropdown option for Program name
    
  @AssignmentDetailsPopupWindow calender icon in Assignment due date
  Scenario: Verify calendar icon in Assignment due date  in Assignment details popup window
    Then Admin should see  calendar icon for assignment due date
    
  @AssignmentDetailsPopupWindow save button
  Scenario: Verify save button is present
    Then Admin should see  save button in the Assignment detail popup window
    
  
  @AssignmentDetailsPopupWindow cancel button
  Scenario: Verify cancel button is present
    Then Admin should see  cancel button in the Assignment detail popup window
    
  @AssignmentDetailsPopupWindow close button
  Scenario: Verify close button in  Assignment details popup window
    Then  Admin should see  close button on the Assignment details popup window
    
@ClassPage
Feature: Class detail Popup window verification

  Background: Admin logged into LMS portal and clicks class button on the navigation bar
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button

  Scenario: Verify cancel button is present
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  cancel button in the class detail popup window

  Scenario: Verify class details popup window
    Then Admin should see a popup  with  heading "class details"

  Scenario: Verify input fields in class details popup window
    Then Admin should see input fields Text (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)

  Scenario: Verify text box present in class details popup window
    Then Admin should see "Batch ID" text box in class details pop up window

  Scenario: Verify text box present in class details popup window
    Then Admin should see "Batch ID" label in class details pop up window

  Scenario: Verify drop down in Batch Id  in class details popup window
    Then Admin should see  dropdown option for Batch ID

  Scenario: Verify drop down in Staff Id  in class details popup window
    Then Admin should see  dropdown option for Staff Id

  Scenario: Verify calendar icon in class date  in class details popup window
    Then Admin should see  calendar icon for class date

  Scenario: Verify save button is present
    Then Admin should see  save button in the class detail popup window

  Scenario: Verify cancel button is present
    Then Admin should see  cancel button in the class detail popup window

  Scenario: Verify close button   in class details popup window
    Then Admin should see  close button on the class details popup window

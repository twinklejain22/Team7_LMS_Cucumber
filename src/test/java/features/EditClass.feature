@ClassPage
Feature: Add New Class

  Background: Admin click +Add New Class button after reaching to Manage class page
    Given Admin is in  class detail popup window

  Scenario: Validate all batch id is reflecting in the dropdown
    When Admin clicks  Batch ID dropdown
    Then Batch id in the drop down should match with Batch id manage batch page table

  Scenario: Validate admin able to add new class with valid data in mandatory fields
    When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Admin should see new class details is added in the data table

  Scenario: Validate admin able to add new class with invalid data in mandatory fields
    When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Admin should see new class details is added in the data table

  Scenario: Validate admin able to add new class with valid data  in all fields
    When Admin enters values in all fields with valid data and clicks save button (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)
    Then Error message should appear in alert

  Scenario: Validate admin able to add new class with invalid data  in optional fields
    When Admin enters with invalid data in optional fields and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Admin should see new class details is added in the data table

  Scenario: Validate admin able to add new class missing Batch Id
    When Admin enters  data missing value in Batch ID and clicks save button (No of Classes, Class Date, Staff Id)
    Then Error message should appear in alert

  Scenario: Validate admin able to add new class missing No of Class
    When Admin enters data missing value in No of class and clicks save button (Batch ID ,  Class Date, Staff Id, )
    Then Batch Id is missing

  Scenario: Validate admin able to add new class missing Class Date
    When 
    Then No of classes is missing

  Scenario: Validate admin able to add new class missing staff id
    When 
    Then class date is missing

  Scenario: Validate  admin able to add new class passing past date
    When 
    Then staff id is missing

  Scenario: Validate date picker
    When 
    Then class cannot be  created for the passed date

  Scenario: validate date picker should be correct format
    When 
    Then selected date should be their in class date text box

  Scenario: Validate right arrow in data picker to navigate to next month
    When 
    Then selected date should be in  mm/dd/yyyy format

  Scenario: Validate left arrow in data picker to navigate to previous month
    When 
    Then Next month calender should visible

  Scenario: Validate current date is highlighted in the date picker
    When 
    Then previous month calender should visible

  Scenario: Validate selected date is highlighted in the date picker
    When 
    Then Admin should see current date is highled in the date picker

  Scenario: Validate cancel button function in class details popup window
    When 
    Then Admin should see selected date is highled in the date picker

  Scenario: Validate cancel button function in class details popup window with values in field

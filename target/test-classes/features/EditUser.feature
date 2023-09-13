@EditUser
Feature: Edit user

	Background: Go to User Page
   Given Admin is on dashboard page after Log in
    When Admin clicks "User" from the navigation panel
    
  Scenario: Validate row level edit icon
  	Given The edit icon on row level in data table is enabled
  	When Admin clicks the edit icon
  	Then A pop up with User details appears for Edit
  
  #Scenario: Check if the fields are updated
  #Scenario: Check if the update throws error with invalid values
  #Scenario: Check if you get error message when mandatory fields are erased
  #Scenario: Check if description field is optional in update

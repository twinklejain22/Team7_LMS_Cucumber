@UserPageValidation
Feature: User page validation

	Background: Go to User Page
   Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar

  @UserPageLanding
  Scenario: Validate landing in User page
    Then Admin should see the "Manage User" in the URL
    
  @UserPageHeader
  Scenario: Validate header in the User Page
  	Then Admin should see the "Manage User" in the header
  	
  @UserPagePagination
  Scenario: Validate pagination in the User Page
  	Then Admin should see the pagination controls under the data table

  Scenario: Validate data table headers in the User Page
  	Then Admin Should see the data table with headers Id, Name, location, Phone Number, Edit/Delete
  	
  Scenario: Validate Delete button in User Page
  	Then Admin should be able to see the delete icon button that is disabled
  	
  Scenario: Validate add new user button in User Page
  	Then Admin should be able to see the add new user button
  	
  Scenario: Validate Assign Staff  button in User page
  	Then Admin should be able to see the Assign staff button
  	
  Scenario: Validate search box in User page
  	Then Admin should be able to see the search text box
  	
  Scenario: Validate data rows
  	Then Each row in the data table should have a checkbox
  	
  Scenario: Validate data rows
  	Then Each row in the data table should have a edit icon that is enabled
  	
  Scenario: Validate data rows
  	Then Each row in the data table should have a delete icon that is enabled
  	
  Scenario: Validate pop up for adding user
  	When Admin clicks add new user button
  	Then A new pop up with User details appears

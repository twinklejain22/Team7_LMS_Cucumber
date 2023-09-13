@DashboardPage
Feature: Dashboard Page

	Background: Admin is logged in and on Dashboard
   Given User is on log in page
   When User clicks login after entering valid username and password

  @LoginPageNavigation
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Then Admin should see "Manage program" as header  
    
  Scenario: Verify the response time
  	Then Maximum navigation time in milliseconds, defaults to thirty seconds
  
  Scenario: Verify broken link
  	Then HTTP response should be error code for broken url

  Scenario: Verify LMS title with correct spelling
  	Then Admin should see LMS - Learning management system  as title 
  	
  Scenario: Verify  LMS title alignment
  	Then LMS title should be on the top left corner of page
  	
  Scenario: Validate navigation bar text and order
  	Then Admin should see correct spelling and order in navigation bar text
  	
  Scenario: Validate alignment for navigation bar
  	Then Admin should see the navigation bar text on the top right side
  	
	Scenario: Verify Logout button function
		When Admin click Logout button on navigation bar
		Then Admin should land on login in page
	
 


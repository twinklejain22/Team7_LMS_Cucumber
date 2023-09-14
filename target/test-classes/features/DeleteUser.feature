@DeleteUser
Feature: Delete user

	Background: Go to User Page
   Given Admin is on dashboard page after Log in to LMS
    When Admin clicks "User" from the navigation panel on Dashboard
    
  Scenario: Validate row level delete icon
  	Given The delete icon on row level in data table is enabled
  	When Admin clicks the delete icon
  	Then Alert appears with yes and No option

  Scenario: Validate accept alert
  	Given Alert appears with yes and No option
  	When Admin click yes option
  	Then User deleted alert pops and user is no more available in data table
  	
  Scenario: Validate reject alert
  	Given Admin is on Delete Confirmation pop up
  	When Admin click No option
  	Then User is still listed in data table
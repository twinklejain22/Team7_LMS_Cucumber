@DeleteClass
Feature: Delete Class 
​
  Background: Go to Class Page
    Given Admin is on dashboard page after Log in to LMS
    When Admin clicks "Class" from the navigation panel on Dashboard
    
    
  Scenario: Validate row level delete icon
    Given The delete icon on row level in data table is enabled
    When Admin clicks the delete icon
    Then Alert appears with yes and No option
​
  Scenario: Validate accept alert
    When Admin click yes option
    Then Admin deleted alert pops and class is no more available in data table
​
  Scenario: Validate reject alert
    Given Admin is on Delete Confirmation pop up
    When Admin click No option
    Then Admin is still listed in data table






@HomePage
Feature: Home Page Verification

  @tag1
  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    
  @tag1
  Scenario: Verify login button is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button 
    
	@tag1
  Scenario: Verify login button is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should able to click the Login button
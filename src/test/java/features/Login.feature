@HomePage
Feature: Login page verification

	Background: Click Login button on Home Page
   Given Admin is in home page
    When Admin clicks Login button

  @LoginPageNavigation
  Scenario: Verify the login page
    Then Admin should land on the login page 
    
  @LoginPageNavigation
  Scenario: Verify header of the login page
    Then Admin should see correct in the header
    
  @LoginPageNavigation
  Scenario: Verify text field is present
    Then Admin should see two text field
    
  @LoginPageUserNameDefaultText
  Scenario: Verify text on the first text field
    Then Admin should see correct default text with star in the first text field
    
  @LoginPagePasswordDefaultText
  Scenario: Verify text on the second text field
    Then Admin should see correct default text with star in the second text field
    
  @LoginPageTextFieldsAlignment
  Scenario: Verify the alignment input field for the login
    Then Admin should see input field on the centre of the page
   
   
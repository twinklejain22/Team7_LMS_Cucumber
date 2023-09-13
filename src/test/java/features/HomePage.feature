@HomePage
Feature: Home Page Verification

	Background: Browser launch
	 Given Admin launch the browser

  @HomePageNavigation
  Scenario: Verify admin is able to land on home page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    
  @HomePageInvalidURL
  Scenario: Verify admin is able to land on home page with invalid URL
  	When Admin gives the invalid LMS portal URL
  	Then Admin should recieve page not found error 
  	
  @HomePageBrokenLink
  Scenario: Verify for broken link
  	Given Admin gives the LMS portal URL
  	Then HTTP response error code for broken url
  	
  @HomePageTextSpellings
  Scenario: Verify the text spelling in the page 
  	Given Admin gives the correct LMS portal URL
  	Then Admin should see correct spellings in all fields 
  	
  @HomePageLogo
  Scenario: Verify the logo of the LMS 
  	When Admin gives the correct LMS portal URL
  	Then Admin should see correct logo of the LMS
  	
  @HomePageLogoAlignment
	Scenario: Admin should see logo is properly aligned
		When Admin gives the correct LMS portal URL
		Then Admin should see logo is properly aligned
    
  @LoginPresent
  Scenario: Verify login button is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button 
    
	@LoginClickable
  Scenario: Verify login button is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should able to click the Login button
    
@HomePage
Feature: Login page verification

	Background: Click Login button on Home Page
   Given Admin is in home page
    When Admin clicks Login button

  @LoginPageNavigation
  Scenario: Verify the login page
    Then Admin should land on the login page 
    
  #@LoginPageBrokenLink
  #Scenario: Verify for broken link
    
  @LoginPageNavigation
  Scenario: Verify header of the login page
    Then Admin should see correct text in the header
    
  #@LoginPageTextSpellings
  #Scenario: Verify the text spelling in login page 
    
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
    
  @LoginPageLoginBtnPresent
  Scenario: Verify Login is present
    Then Admin should be able to see login button 
    
  @LoginPageLoginBtnAlignment
	Scenario: Verify the alignment of the login button
		Then Admin should see login button on the centre of the page
	
	@LoginPageForgotLink
	Scenario: Verify forgot username or password link
		Then Admin should see forgot username or password link 
	
	@LoginPageResetLink
	Scenario: Verify for the Reset password link
		Then Admin should see reset password link 
	
	@LoginPageUserFontColor
	Scenario: Verify input descriptive test in user field
		Then Admin should see user in gray color
	
	@LoginPagePasswordFontColor
	Scenario: Verify input descriptive test in password field
		Then Admin should see password in gray color
	
	@LoginPageValidLogin
	Scenario: Validate login with valid credentials
		Given Admin is in login page
		When Admin enter valid credentials and clicks login button 
		Then Admin should land on dashboard page
	
	
#	Scenario: Validate login with invalid credentials
#	Scenario: Validate login with valid credentials in username
#	Scenario: Validate login with valid credentials in password
#	Scenario: Validate login with blank username credentials
#	Scenario: Validate login with blank password credentials
#	Scenario: validate login with empty values in both field
#	Scenario: verify login button action through keyboard
#	Scenario: verify login button action through mouse
   #
   
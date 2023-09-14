@HomePage
Feature: Login page verification

  Background: Click Login button on Home Page
    Given Admin is in home page
    When Admin clicks Login button

  @LoginPageNavigation
  Scenario: Verify the login page, when broken should give 404
    Then Admin should land on the login page

  @LoginPageNavigation
  Scenario: Verify header of the login page
    Then Admin should see correct text in the header

  @LoginPageTextSpellings
  Scenario: Verify the text spelling in login page
  	Then Admin should see right spellings in all fields 
  
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

  @LoginPageLogin
  Scenario Outline: Validate login with different credentials
    When Admin logs in with username password combination from "<key>"
    Then Admin should land on dashboard page or see error based on "<key>"

    Examples: 
      | key                   |
      | Login_Valid           |
      | Login_InvalidUsername |
      | Login_InvalidPassword |
      | Login_BlankUsername   |
      | Login_BlankPassword   |
      | Login_BlankFields     |

  @LoginPageValidLoginBtnKeyboard
  Scenario: Verify login button action through keyboard
    Given Admin is on login page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should go to on dashboard page

@ForgotCredentials
Feature: Forgot username/password page

  Background: Admin navigates to Forgot username password
    Given Admin is on LMS App Login Page
    When Admin clicks forgot username or password link

  @ForgotCredLanding
  Scenario: Verify forgot username or password link, broken link should give >= 400
    Then Admin should land on forgot username or password page

  @ForgotCredTextColor
  Scenario: verify input descriptive text for Email
    Then Admin should see Email text in gray color

  @ForgotCredEmail
  Scenario: Verify email text in text field
    Then Admin should see Email correctly spelled with asterik in text field

  @ForgotCredBtnAlignment
  Scenario: Verify the alignment of the send link button
    Then Admin should see send button with correct spelling in center of the page

  @ForgotCredVakidEmail
  Scenario: Validate email sent for forgot password
  	When Admin enters valid email id and clicks send link button
    Then Admin should receive link in mail for reset username password

  @ForgotCredInvalidEmail
  Scenario: Validate email sent for forgot password with invalid email
  	When Admin enters invalid email id and clicks send link button
    Then Admin should not receive link in mail for reset username password

@ResetPassword
Feature: Reset password

  Background: Admin navigates to Forgot username password
    Given Admin has landed on LMS Login Page
    When Admin clicks Reset Password Link

  @ResetPasswordLanding
  Scenario: Verify reset password link
    Then Admin should land on reset password page

  @ResetPasswordSpellings
  Scenario: Verify  text in the page
    Then Admin should see correct spellings on Reset page

  @ResetPasswordSubmitBtn
  Scenario: Verify submit button is present
    Then Admin should see Submit button

  @ResetPasswordSubmitBtnAlignment
  Scenario: Verify the alignment of the submit button
    Then Admin should see submit button in center of the page

  @ResetPasswordNewPwd
  Scenario: Verify first label text field present and its text
    Then Admin should see correct label text for new password

  @ResetPasswordRetypePwd
  Scenario: Verify second label text field present and its text
    Then Admin should see correct label text for retyping new password.

  @ResetPasswordNewPwdTxt
  Scenario: Verify text box is in disabled
    Then Admin should see text box in disabled state

  @ResetPasswordNewPwdTxt
  Scenario: verify text box is in enabled in new password field
    When Admin clicks on type in new password field
    Then Admin should see new pwd text box is enabled state

  @ResetPasswordRetypePwdTxt
  Scenario: Verify text box is in enabled in retype password field
    When Admin clicks on retype password field
    Then Admin should see retype pwd text box is enabled state

  @ResetPasswordNewPwdTxt
  Scenario Outline: Validate reset password with values from "<key>"
    When Admin enters passwords from "<key>"
    Then Admin should recieve valid message as per "<key>"

    Examples: 
      | key                           |
      | PasswordReset_Valid           |
      | PasswordReset_Invalid         |
      | PasswordReset_EmptyNewPass    |
      | PasswordReset_EmptyRetypePass |
      | PasswordReset_EmptyFields     |
      | PasswordReset_Mismatch        |

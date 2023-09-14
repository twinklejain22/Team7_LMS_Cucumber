@EditUser
Feature: Edit user

  Background: Go to User Page
    Given Admin is on dashboard page after Log in
    When Admin clicks "User" from the navigation panel

  Scenario: Validate row level edit icon
    Given The edit icon on row level in data table is enabled
    When Admin clicks the edit icon
    Then A pop up with User details appears for Edit

  Scenario Outline: Check if user able to update fields in different combinations
    Given Admin is on User Details pop up for Edit
    When Update the fields with values as per "<key>" and click submit
    Then Valid values should get updated or error should appear "<key>"

    Examples: 
      | key                        |
      | User_EditMandatoryFields   |
      | User_EditAllFields         |
      | User_EditMissingFirstName  |
      | User_EditMissingLastName   |
      | User_EditMissingLocation   |
      | User_EditMissingPhone      |
      | User_EditMissingUserRole   |
      | User_EditMissingRoleStatus |
      | User_EditMissingVisaStatus |
      | User_EditInvalidFirstName  |
      | User_EditInvalidLastName   |
      | User_EditInvalidEmail      |

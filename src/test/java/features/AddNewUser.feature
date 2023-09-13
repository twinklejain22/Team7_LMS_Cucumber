@AddNewUser
Feature: Add new user

  Background: Go to Add new user pop up
    Given Admin is on "User" page
    When Admin clicks on add new user button

  @AddUserLanding
  Scenario Outline: Check if the fields exist in popup
    Then The pop up should have all the "<field>"

    Examples: 
      | field         |
      | First Name    |
      | Middle name   |
      | Last Name     |
      | Location      |
      | Phone         |
      | Email         |
      | Linkedin Url  |
      | Undergraduate |
      | Postgraduate  |
      | Time Zone     |
      | User Comments |
      | Visa Status   |
      | Role Status   |
      | User Role     |

  @AddUserNewUser
  Scenario Outline: Check admin able to add new user with different values and gets error for missing mandatory fields
    When Fill in all the fields for "<key>"
    Then Admin able to verify new record or error as per "<key>"

    Examples: 
      | key                    |
      | User_MandatoryFields   |
      | User_AllFields         |
      | User_ForMultiDelete1   |
      | User_ForMultiDelete2   |
      | User_MissingFirstName  |
      | User_MissingLastName   |
      | User_MissingLocation   |
      | User_MissingPhone      |
      | User_MissingUserRole   |
      | User_MissingRoleStatus |
      | User_MissingVisaStatus |
      | User_InvalidFirstName  |
      | User_InvalidLastName   |
      | User_InvalidEmail      |

@AddNewClass
Feature: Add new class

  Background: Go to Add new class pop up
    Given Admin is on "Class" page
    When Admin clicks on add new class button

  @AddClassLanding
  Scenario Outline: Check if the fields exist in popup
    Then The pop up should have all the "<field>"

    Examples: 
      | field             |
      | Batch ID          |
      | No of Classes     |
      | Class Date        |
      | Class Topic       |
      | Staff Id          |
      | Class description |
      | Comments          |
      | Notes             |
      | Recordings        |
      | Time Zone         |
      | User Comments     |
      | Visa Status       |
      | Role Status       |
      | User Role         |

  @AddClassNewClass
  Scenario Outline: Check admin able to add new class with different values and gets error for missing mandatory fields
    When Fill in all the fields for "<key>"
    Then Admin able to verify new record or error as per "<key>"

    Examples: 
      | key                      |
      | Class_MandatoryFields    |
      | Class_AllFields          |
      | Class_MissingBatchID     |
      | Class_MissingNoOfClasses |
      | Class_MissingClassDate   |
      | Class_MissingStaffID     |

@EditClass
Feature: Edit class

  Background: Go to Class Page
    Given Admin is on dashboard page after Log in
    When Admin clicks "Class" from the navigation panel

  Scenario: Validate row level edit icon
    Given The edit icon on row level in data table is enabled
    When Admin clicks the edit icon
    Then A pop up with Class details appears for Edit

  Scenario Outline: Check if user able to update fields in different combinations
    Given Admin is on Class Details pop up for Edit
    When Update the fields with values as per "<key>" and click submit
    Then Valid values should get updated or error should appear "<key>"

    Examples: 
      | key                      |
      | Class_MandatoryFields    |
      | Class_AllFields          |
      | Class_MissingBatchID     |
      | Class_MissingNoOfClasses |
      | Class_MissingClassDate   |
      | Class_MissingStaffID     |

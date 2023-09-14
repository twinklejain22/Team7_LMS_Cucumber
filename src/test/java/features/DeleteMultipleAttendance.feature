@DeleteMultipleAttendance
Feature: Delete multiple Attendance

  Background: Go to Attendance Page
    Given Admin is on dashboard after Log in to LMS
    When Admin selects "Attendance" from the navigation panel on Dashboard

  Scenario: Validate the delete icon below the header
    Given None of the checkboxes in data table are selected
    Then The delete multiple icon should be disabled

  Scenario: Check for single row delete
    Given One of the checkbox or row is selected
    When Click delete multiple icon
    Then The respective row in the data table is deleted

  Scenario: Check for multi row delete
    Given Two checkboxes or row is selected
    When Click on delete multiple icon
    Then The respective rows in the data table is deleted
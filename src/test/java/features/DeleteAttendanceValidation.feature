@DeleteAttendanceValidation
Feature: Delete attendance validation

  Background: Admin logged into LMS portal and clicks attendance button on the navigation bar
    Given Admin is in manage attendance page
    When Admin clicks delete button in data table row level

  Scenario: Verify Delete attendance alert
    Then Admin should see alert

  Scenario: Verify  accept enabled in alert
    Then Alert should have "yes" button to accept

  Scenario: Verify reject enabled in alert
    Then Alert should have "No" button to reject

  Scenario: Validate accept in alert
    Then Success message and selected attendance details are deleted from the data table

  Scenario: Validate reject in alert
    Then Redirected attendance page and selected attendance details are not deleted from the data table
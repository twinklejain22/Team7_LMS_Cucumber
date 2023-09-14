@ClassPage
Feature: Pagination in manage class

  Background: Logged on the LMS portal as Admin
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar

  @ClassPageVerifySheet_1
  Scenario: Verify sheet one is displayed on default in data table
    Then Data table should display first page  when entries available

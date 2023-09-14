@SortFunction
Feature: Verify sort function in manage class page

  Background: Admin is manage class page after logged in
    Given Admin is in Manage class page

  Scenario: Verify sort function in data table for descending order
    When Admin click on Batch id column header to sort
    Then Admin should see data table sorted in descending order

  Scenario: Verify sort function in data table for ascending order
    When Admin double click on Batch id column header to sort
    Then Admin should see data table sorted in ascending  order

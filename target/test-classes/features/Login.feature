@HomePage
Feature: Login page verification

  @tag1
  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
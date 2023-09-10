@ClassPage
Feature: Manage Class Page Verification

  @ClassPageNavigation
  Scenario: Verify landing in class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Admin should see URL with "Manage Class"

  @ClassPageResponseTimeNavigation
  Scenario: Capture the response time to navigate to manage class page
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar
    Then Get the response time for navigation from dashboard page to manage class page

  
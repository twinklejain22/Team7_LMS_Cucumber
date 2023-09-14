@ClassPage
Feature: Navigation function validation from manage class page to other pages

  Background: Admin is manage class page after logged in
    Given Admin is in Manage class page

  @ClassPageClicksStudent
  Scenario: Verify admin is able to navigate from manage class to student page
    When Admin clicks " Student" button in the navigation bar
    Then Admin should able to land on student page

    @ClassPageClicksProgram
  Scenario: Verify admin is able to navigate from manage class to program page
    When Admin clicks " Program" button in the navigation bar
    Then Admin should able to land on program page
    
    @ClassPageClicksBatch
  Scenario: Verify admin is able to navigate from manage class to batch page
    When Admin clicks " Batch" button in the navigation bar
    Then Admin should able to land on batch page
    
    @ClassPageClicksUser
  Scenario: Verify admin is able to navigate from manage class to user page
    When Admin clicks " User" button in the navigation bar
    Then Admin should able to land on user page
    
    @ClassPageClicksAssignment
  Scenario: Verify admin is able to navigate from manage class to assignment page
    When Admin clicks " Assignment" button in the navigation bar
    Then Admin should able to land on Assignment page
    
    @ClassPageClicksAttendance
  Scenario:Verify admin is able to navigate from manage class to attendance page
    When Admin clicks " Attendance" button in the navigation bar
    Then Admin should able to land on Attendance page
    
    @ClassPageClicksLogout
  Scenario: Verify adminshould able to do logout function from manage class
    When Admin clicks "Logout" button in the navigation bar
    Then Admin should able to land on login page
    
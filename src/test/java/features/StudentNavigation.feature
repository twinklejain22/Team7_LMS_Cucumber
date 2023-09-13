Feature: Navigation Validation from student page to other Pages

Background:
	Admin is logged in and on the student Details page

@001_Programlinknavigation
  Scenario: Program link on navigation bar
    Given Admin is on student details page
    When Admin clicks on program link on student  page
    Then Admin is redirected to Program page
   

 @002_BatchLinkNavigation
   Scenario: Batch link on navigation bar
    Given Admin is on student details page
    When Admin clicks on Batch link on student page
    Then Admin is redirected to Batch page
    
  @003_ClassLinkNavigation
  Scenario: Class link on navigation bar
    Given Admin is on student details page
    When Admin clicks on Class link on student page
    Then Admin is redirected to Class page
    
  @004_UserlinkNavigation 
   Scenario: Class link on navigation bar
    Given User link on navigation bar
    When Admin clicks on User link on student page
    Then Admin is redirected to User page
    
   @005_AssignmentLinkNavigataion
     Scenario: Assignment link on navigation bar
     Given Admin is on student details page
     When Admin clicks on Assignment link on student page
    Then Admin is redirected to Assignment Page
    
    @006_AttendenceLinkNavigation
    Scenario: Attendance link on navigation bar
     Given Admin is on student details page
     When Admin clicks on Attendance link on student page
    Then Admin is redirected to Attendance page
    
    @007_LogoutNavigation
     Scenario:Logout link on navigation bar
     Given Admin is on student details page
     When Admin clicks on Logout link on student page
    Then Admin is redirected to Login page
    
    
   
Feature: For Student page

  @001_validate_Title
  Scenario: Validate the title of the page
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see the Student details Page Title

  @002_Validate_responsetime
  Scenario: Validate response time from dashboard page to student page
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation barA
    Then Maximum navigation time in milliseconds, defaults to 30 seconds

  @003_Broken_Link
  Scenario: Validate the broken link
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then HTTP response >= 400. Then the link is broken

  @004_LMS_Title
  Scenario: Verify LMS title
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see LMS -Learning management system  as title

  @005_VerifyTheAlignment
  Scenario: Verify the alignment of the Student detail title
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Student Detail title should be in centre of the page

  @006_Validatedropdownispresent
  Scenario: Validate drop down is present in the page
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then 2 dropdowns should be present in the page

  @007_VerifySearchButtonInStudentName
  Scenario: Validate search bar in select student name drop down
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    And Admin clicks Student dropdown
    Then Admin should see search box inside the drop down

  @008_VerifySearchbuttonbatchid
  Scenario: Validate search bar in select batch id drop down
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    And Admin clicks batchId dropdown
    Then Admin should see search box inside  batch id drop down

  @009_ValidateTextspellingStudentTName
  Scenario: Validate text spelling student name
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see correct spelling "Select Student Name"
    
   @010_ValidateTextSpellingBatchId
    Scenario: Validate text spelling select batch id
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see correct spelling "select  batch id" text
    
    @011_validateNumbersBatchIdDropDown
    Scenario: Validate only numbers inside select batch id
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see only numbers inside batch id drop down
    
    @012_validateColorStudentNameDropDown
     Scenario:Validate gray color in student name drop down
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see select student name in "gray" color
  
    @013_validateGreyColorBatchIdDropDown
    Scenario:Validate gray color in BatchId drop down
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see select batch ID in "gray" color
  
    @13_validateFirstDropDownLabelisSelectStudentName
    Scenario: Validate first drop down label is select student name
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see "select student name" in first
    
    @14_ValidateSecondDropdownBatchId
    Scenario: Validate second drop down label is select batch id
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should see "select batch id" in second
    
    @15_ValidateStudentScrollDown
    Scenario: Validate scroll down inside student name dropdown
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should able to scroll down to select the name
    
    @16_ValidateBatchIdScrollDown
    Scenario: Validate scroll down inside batch id dropdown
    Given Admin is on dashboard page after Login
    When Admin clicks "Student" on the navigation bar
    Then Admin should able to scroll down to select the batch id
    
    @17_StudentNameIsfading
    Scenario: Validate select student name is fading
    Given Admin is on student details page
    When Admin select student name from the drop down 
    Then Admin should not see select student name text 
    
    @18_BatchIdIsfading
    Scenario: Validate select batch id  is fading
    Given Admin is on student details page
    When Admin select batch id from the drop down 
    Then Admin should not see select batch id text     
    
    @19_SelectStudentUsingSearchBox
    Scenario: Validate select student name using search box
    Given Admin is on student details page
    When Admin clicks select student name and  enters "x" alphabet in the search box 
    Then Admin should see student name start with "x" is listed below
    
    @20_SelectBatchUsingSearchBox
    Scenario: Validate select batch id using search box
    Given Admin is on student details page
    When Admin  clicks select batch id and enter 6 number in the search box 
    Then Admin should see batch id start with 6 is listed below
    
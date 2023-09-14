@Attendance2
Feature: Attendance details popup window  verification

  Background: Logged on the LMS portal as Admin
    Given Admin is in manage attendance page
    When Admin clicks + a new attendance button

  @AttendanceAllLabelTextVerify
  Scenario: Verify all label text
    Then Admin should see correct spellings in the label

  @AttendanceDropdownBoxIsPresentVerify
  Scenario: Verify dropdown box is present
    Then 4 dropdown should be present

  @AttendanceCloseButtonInAttendanceDetailsPopupWindowVerify
  Scenario: Verify close button   in attendance details popup window
    Then Admin should see  close button on the attendance details popup window

  @AttendanceTheAlignmentOfTheCloseButtonVerify
  Scenario: Verify the alignment of the close button
    Then Close button should on the top right corner

  @AttendanceTheTextOnFirstDropdownSelectaProgramNameVerify
  Scenario: Verify the text on first dropdown select a program name
    Then First dropdown box "select a program name" text  should be present

  @AttendanceTheTextOnSecondDropdownSelectClassNameVerify
  Scenario: Verify the text on second dropdown select class  name
    Then Second dropdown box "select class name" text  should be present

  @AttendanceThetextOnSecondDropdownSelectClassNameVerify
  Scenario: Verify the text on second dropdown select class  name
    Then Second dropdown box "select class name" text  should be present

  @AttendanceTheTextOnThirdDropdownSelectStudentsVerify
  Scenario: Verify the text on third dropdown select students
    Then Third dropdown box "select students" text  should be present

  @AttendanceTheTextOnFourthDropdownSelectAttendanceVerify
  Scenario: Verify the text on fourth dropdown select attendance
    Then Fourth dropdown box "select attendance" text  should be present

  @AttendanceAllTheTextInsideTheDropdownBoxIsGrayColorVerify
  Scenario: Verify all the text inside the dropdown box is gray color
    Then Admin  should text in gray color

  @AttendanceSaveButtonIsPresentVerify
  Scenario: Verify save button is present
    Then Admin should see  save button in the class detail popup window

  @AttendanceCancelButtonIsPresentVerify
  Scenario: Verify cancel button is present
    Then Admin should see  cancel button in the class detail popup window

  @AttendanceOrderOfTheLabelInAttendanceDetailsPage
  Scenario: Verify order of the label in attendance details page
    Then Order of the label should be Program name, Class Name, Student Name, Attendance, Attendance Date.

  @AttendanceAllProgramNameIsReflectingInTheDropdownVerify
  Scenario: Validate all program name is reflecting in the dropdown
    Then Program Name in the drop down should match with  program name in  manage program page table

  @AttendaceAllClassNameIsReflectingInTheDropdownVerify
  Scenario: Validate all class name  is reflecting in the dropdown
    Then Class Name in the drop down should match with  class name in  manage class page table

  @AttendaneValidateAttendanceFieldDropdownAllMandatoryKeywordsVerify
  Scenario: Validate attendance field dropdown all mandatory keywords
    Then Attendance field should have keywords such as - present, absent, late, excused

  @AttendanceSpellingsInTheAttendanceFieldDropDownVerify
  Scenario: Verify spellings in the attendance field drop down
    Then Admin should see correct spellings in dropdown text

  @AttendanceDatePickerValidate
  Scenario: Validate date picker
    Then selected date should be their in class date text box

  @AttendanceDatePickerShouldBeCorrectFormatValidate
  Scenario: validate date picker should be correct format
    Then selected date should be in  mm/dd/yyyy format

  @AttendanceRightArrowInDataPickerToNavigateToNextMonthValidate
  Scenario: Validate right arrow in data picker to navigate to next month
    Then Next month calender should visible

  @AttendanceLeftArrowInDataPickerToNavigateToPreviousMonthValidate
  Scenario: Validate left arrow in data picker to navigate to previous month
    Then previous month calender should visible

  @AttendaceCurrentDateIsHighlightedInTheDatePickerValidate
  Scenario: Validate current date is highlighted in the date picker
    Then Admin should see current date is highled in the date picker

  @AttendanceSelectedDateIsHighlightedInTheDatePickerValidate
  Scenario: Validate selected date is highlighted in the date picker
    Then Admin should see selected date is highled in the date picker
@PaginationInManageAttendendance
Feature: Logged on the LMS portal as Admin

  Background: Logged on the LMS portal as Admin
    Given Admin is on dashboard page after Login
    When Admin clicks "attendance" button on the navigation bar

  @SheetOneIsDisplayedOnDefaultInDataTableVerify
  Scenario: Verify sheet one is displayed on default in data table
    Then Data table should display 1 page  when entries available

  @RightArrowIsEnableWhenSheetOneIsDisplayedInDataTableverify
  Scenario: Verify  right arrow is enable when sheet one is displayed in data table
    Then Right arrow should be enabled in page one  when entries are more than 5 available

  @LeftArrowIsDisableWhenSheetOneIsDisplayedInDataTableVerify
  Scenario: Verify  left arrow is disable when sheet one is displayed in data table
    Then Left arrow should be disabled in page one  when entries are more than 5 available

  @RightArrowIsEnableWhenSheetTwoIsDisplayedInDataTableWhenEntriesAreMoreThan10Verify
  Scenario: Verify pagination controls enabled
    Then Right arrow should be enabled in page two when entries are more than 10 available

  @LeftArrowIsEnableWhenSheetTwoIsDisplayedInDataTableVerify
  Scenario: Verify  left arrow is enable when sheet two is displayed in data table
    Then Left arrow should be enabled in page two

  @RightArrowIsDisableWhenSheetTwoIsisplayedInDataTableWhenEntriesAreLessThan10Verify
  Scenario: Verify  right arrow is disable when sheet two is displayed in data table when entries are less than 10
    Then Data table should display  page 1  when entries available

  @PaginationControlsEnabledVerify
  Scenario: Verify pagination controls enabled
    Then When entries are more than 5 in data table pagination controls enabled

  @PaginationControlsDisabledVerify
  Scenario: Verify pagination controls disabled
    Then When entries are less than 5 in data table pagination controls disabled

  @NextPageIsEnabledVerify
  Scenario: Verify next page is enabled
    Then Total attendance entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)

  @NextPageIsDisabledVerify
  Scenario: verify next page is disabled
    Then Total attendance entries  5 or below next page is disabled
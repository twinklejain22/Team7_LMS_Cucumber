@ClassPage
Feature: Manage Class Page Verification

  Background: Logged on the LMS portal as Admin
    Given Admin is on dashboard page after Login
    When Admin clicks "Class" button on the navigation bar

  @ClassPageNavigation
  Scenario: Verify landing in class page
    Then Admin should see URL with "Manage Class"

  @ClassPageResponseTimeNavigation
  Scenario: Capture the response time to navigate to manage class page
    Then Get the response time for navigation from dashboard page to manage class page

  @ClassPageHeader
  Scenario: Verify Manage Class Page Header
    Then Admin should see header with "Manage Class"

  @ClassPageTextHeader
  Scenario: Validate text in manage class page
    Then Admin should see correct spelling for the all the fields

  @ClassPageDeleteIconBelowHeader
  Scenario: Verify delete icon below the header
    Then Admin should see disabled delete icon below the "Manage Class"

  @ClassPageSearchBar
  Scenario: Verify search bar on the class page
    Then Admin should see search bar on the class page

  @ClassPageAddNewClaassBtn
  Scenario: Verify add new class button  on class page
    Then Admin should see +Add New Class button on the class page

  @ClassPageDataTableVerification
  Scenario: Verify data table on the class page
    Then Admin should see data table on the Manage Class Page With following column headers. (Check box symbol,Batch Id, Class No,Class Date, Class Topic, Staff Id, Description, Comments, Notes, Recording, Edit Delete)

  @ClassPageEditIconWithDataTable
  Scenario: Verify Edit icon in the data table
    Then Edit Icon in each row of data table only  when entries are available

  @ClassPageEditIconWithoutDataTable
  Scenario: Verify Edit icon when no data in the table
    Then Edit Icon will not be present in data table

  @ClassPageDeleteIcon
  Scenario: Verify delete icon in the data table
    Then Delete Icon in each row of data table only  when entries are available

  @ClassPageDeleteIcon
  Scenario: Verify delete icon when no data in the table
    Then Admin cant see delete  Icon in data table

  @ClassPageSortIcon
  Scenario: Verify sort icon in the data table
    Then Admin should see sort icon near the column headers except for Edit and Delete

  @ClassPageCheckBox
  Scenario: Verify check box in the data table
    Then Admin should see check box in the all rows  of data table

  @ClassPagePopUpAlertValidation
  Scenario: Verify pop up when Add Button clicked
    Then Admin should see pop up alert

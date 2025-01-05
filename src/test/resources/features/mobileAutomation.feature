@MobileAssignment
Feature: E2E Mobile Automation

  @Navigation
  Scenario: Validate Bottom Navigation Bar
    When user is at the home page
    And user scrolls "down" to the page
    Then user clicks the My Lists icon
    And user clicks the History icon
    And user clicks the NearBy icon
    And user clicks the Explore icon
    And user scrolls "up" to the page

  @Search
  Scenario: Validate Search Functionality
    When user clicks the Search icon
    And user searches "New York" in the search bar
    Then verify search bar expanded with returned results
    And close search button to clear and return to home page

  @Settings
  Scenario: Validate Setting Functionality
    When user is at the home page
    And user navigates to the Settings page
    Then verify user is able to disable all options
    And verify user is able to return to home page




Feature: Homepage

  @E2E-1 @TESTID-1 @smoke @homepage
  Scenario: Open homepage
    Given user opens the homepage
    Then homepage should be displayed

  @E2E-2 @TESTID-2 @regression @search
  Scenario: Search functionality
    Given user opens the homepage
    When user click the search button
    And user searches for "crane"
    Then search results should be displayed

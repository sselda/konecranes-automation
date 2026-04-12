Feature: Homepage

  @TEST-1
  Scenario: Open homepage
    Given user opens the homepage
    Then homepage should be displayed

  @TEST-2
  Scenario: Search functionality
    Given user opens the homepage
    When user click the search button
    And user searches for "crane"
    Then search results should be displayed

@ui
Feature: Google Search
  Scenario: Search for Playwright
    Given I open Google home page
    When I search for "Playwright"
    Then I should see results containing "Playwright"

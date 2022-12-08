Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage

  @ASB-6 @regression @smoke
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

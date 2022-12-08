Feature: Homepage tests
  @ASB-6 @regression
  Scenario: Verify header of current project
    Given I open url of homepage
    Then Verify title of the homepage should be "Advance Systems - Home"

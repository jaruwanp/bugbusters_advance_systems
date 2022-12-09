Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage

  @ASB-6 @regression @smoke
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

  @ASB-3 @regression @smoke
    Scenario: Contact info on main page
    Then Verify address line one is "10090 Main Street"
    Then Verify address line two is "Fairfax, VA, USA"
    Then Verify phone number is "+1 703-831-3217"
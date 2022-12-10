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

  @ASB-10-A @regression @smoke
    Scenario: Main social media section
    Then Verify social media button "https://facebook.com" is displayed
    Then Verify social media button "https://twitter.com" is displayed
    Then Verify social media button "https://google.com" is displayed
    Then Verify social media button "https://linkedin.com" is displayed

  @ASB-10-B @regression @smoke
  Scenario Outline: Main social media section destinations
    When When I click "<icon>"
    Then Verify destination of related social media has URL as "<URL>"
    Examples:
      | icon                 | URL                        |
      | https://facebook.com | https://www.facebook.com/  |
      | https://twitter.com  | https://twitter.com/       |
      | https://google.com   | https://www.google.com/    |
      | https://linkedin.com | https://www.linkedin.com/  |
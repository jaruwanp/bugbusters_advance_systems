Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage

  @ASB-6 @regression @smoke
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

  @ASB-16 @regression
  Scenario Outline:  Social media buttons displayed in the footer section
    Then Verify "<socialMediaBtn>" is displayed
    And Verify "<socialMediaBtn>" matches to related "<URL>"
    Examples:
      | socialMediaBtn       | URL                         |
      | https://facebook.com | https://www.facebook.com/   |
      | https://twitter.com  | https://twitter.com/        |
      | https://skype.com    | https://www.skype.com/en/   |
      | https://linkedin.com | https://www.linkedin.com/   |
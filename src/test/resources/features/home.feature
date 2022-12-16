Feature: Home page tests

  Background: Navigate to Home Page
    Given I open url of homepage

  @ASB-6 @regression @smoke
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

  @ASB-12A @regression
  Scenario: Verify the testimonials section is displayed as expected
    When I scroll down to Testimonials Section
    Then Verify "Words from our Clients" is displayed
    And Verify following clients' picture and actual testimonial different from others is displayed
      | Mark Cameron     |
#      | Michael Davidson |
      | John Smith       |
      | Mendel Gratt     |
      | Jenifer Hearly   |
#      | Amanda Clarkson  |
    And Verify following clients' location is displayed as a state
      | Mark Cameron     |
#      | Michael Davidson |
      | John Smith       |
      | Mendel Gratt     |
      | Jenifer Hearly   |
#      | Amanda Clarkson  |

  @SB-12B @smoke @regression
  Scenario: Verify the testimonials section is displayed as expected
    When I scroll down to Testimonials Section
    Then Verify "prevBtn" is enable
    And Verify "nextBtn" is enable


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